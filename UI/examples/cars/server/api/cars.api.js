const Express = require('express');

let cars = [{
  registration: 'bg-222-10',
  model: 'A3',
  manufacturer: 'Audi',
  year: 2006,
  doors: 3,
  color: 'black'
}, {
  registration: 'bg-1010-66',
  model: '118D',
  manufacturer: 'BMW',
  year: 2006,
  doors: 5,
  color: 'black'
}, {
  registration: 'bg-100-88',
  model: 'C4',
  manufacturer: 'Citroen',
  year: 2010,
  doors: 5,
  color: 'red'
}]

const router = Express.Router();

router.get('/', (req, res) => {
  setTimeout(() => {
    res.send(cars);
  }, 300);
});

exports.router = router;