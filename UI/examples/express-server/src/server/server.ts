import * as express from 'express';
import * as path from 'path';
import articlesRouter from './api/articles.api';

var server: express.Express = express();

server.use('/api/articles', articlesRouter);


// server.get('/', (req, res) => {
//   res.sendFile(__dirname + '/public/index.html');
// });
// server.get('/js/:filename', (req, res) => {
//   res.sendFile(__dirname + '/client/' + req.params.filename);
// });
server.use(express.static(path.resolve(__dirname, '../../public')));

server.listen(3000, () => console.log('server started at port 3000'));