var Express = require('express');
var locations = require('./locationsFixture');

var router = Express.Router();

router.get('/', (req, res) => {
  res.send(locations);
});

module.exports = router;
