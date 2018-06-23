var Express = require('express');
var path = require('path');
var config = require('../webpack.config');
const webpack = require('webpack');
const webpackDevMiddleware = require('webpack-dev-middleware');

//API
var eventsRouter = require('./api/events');
var locationsRouter = require('./api/locations');

const compiler = webpack(config);

const app = Express();

app.use(webpackDevMiddleware(compiler, {
  publicPath: '/client'
}));

app.use('/api/events', eventsRouter);
app.use('/api/locations', locationsRouter);

app.use('/test', (req, res, next) => {
  console.log('app.use:/test');
  res.custom = {message: 'milos'};
  next();
});

app.get('/test', (req, res) => {
  console.log('app.get:/test');
  res.send(Object.assign(res.custom, {age: 27}));
});

app.get('/*', (req, res) => {
  res.sendFile(path.resolve(__dirname, './public/index.html'));
});

app.listen(3000, () => console.log('Server is running on port 3000'));
