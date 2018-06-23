var Express = require('express');
var path = require('path');
var config = require('../webpack.config');
const webpack = require('webpack');
const webpackDevMiddleware = require('webpack-dev-middleware');

const compiler = webpack(config);

const app = Express();

app.use(webpackDevMiddleware(compiler, {
  publicPath: '/client'
}));

app.get('/*', (req, res) => {
  res.sendFile(path.resolve(__dirname, './public/index.html'));
});

app.listen(3000, () => console.log('Server is running on port 3000'));