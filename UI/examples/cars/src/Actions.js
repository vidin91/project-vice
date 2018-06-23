export const REQUEST_CARS = 'REQUEST_CARS';
export const RECEIVE_CARS = 'RECEIVE_CARS';
export const FETCH_CARS = 'FETCH_CARS';

export const requestCars = () => ({
  type: REQUEST_CARS
});

export const receiveCars = cars => ({
  type: RECEIVE_CARS,
  cars
});

export const fetchCars = () => dispatch => {
  dispatch(requestCars());
  return fetch('/api/cars')
         .then(response => response.json())
         .then(cars => dispatch(receiveCars(cars)));
}
