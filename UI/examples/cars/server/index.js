const Express = require('express');
const carsRouter = require('./api/cars.api').router;

const app = Express();

app.use('/api/cars', carsRouter);

app.listen(4000, () => console.log('server is running at port 4000'));