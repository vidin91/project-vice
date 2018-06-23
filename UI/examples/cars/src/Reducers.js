import {
  REQUEST_CARS,
  RECEIVE_CARS,
  FETCH_CARS
} from './Actions';

export function cars(state = {
  isLoading: false,
  cars: []
}, action) {
  switch(action.type) {
    case REQUEST_CARS:
      return {
        ...state,
        isLoading: true
      };
    case RECEIVE_CARS:
      return {
        ...state,
        isLoading: false,
        cars: action.cars
      }
    default:
      return state;
  }
}