const Express = require('express');
const usersRouter = require('./api/events').router;

const server = Express();

server.use('/api/events', usersRouter);
server.get('/*', (req, res) => {
  res.send('express server');
})

server.listen(8080, () => {console.log('Server is running at post: 8080')});
