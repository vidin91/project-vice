var Express = require('express');

var router = Express.Router();

router.get('/', (req, res) => {
  res.send('ALL EVENTS');
});

router.get('/:id', (req, res) => {
  let header = req.header('Authorization');
  if (!header) {
    res.setHeader('WWW-Authenticate', 'Basic realm="Access to the staging site", charset="UTF-8"');
    res.status(401);
    res.send();
  } else {
    console.log(header);
    res.send({eventId: req.params.id});
  }
});

router.get('/types', (req, res) => {
  // TODO
});

module.exports = router;