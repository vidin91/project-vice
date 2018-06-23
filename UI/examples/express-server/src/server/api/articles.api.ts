import {Router, Request, Response} from 'express';

let router = Router();

router.get('/', (req: Request, res: Response) => {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.write(
`
<html>
  <button>click</button>
</html>
`);
  res.end();
});

router.get('/:id', (req, res) => {
  res.send('param: ' + req.params.id);
});

export default router;