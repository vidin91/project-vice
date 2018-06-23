import React from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {fetchCars} from '../Actions';
import CarsStats from './CarsStats';
import {Link} from 'react-router-dom';

export class CarsPage extends React.Component {
  static propTypes = {
    isLoading: PropTypes.bool.isRequired,
    cars: PropTypes.arrayOf(PropTypes.object).isRequired
  }

  static defaultTypes = {
    cars: []
  }

  componentDidMount() {
    this.props.dispatch(fetchCars());
  }

  render() {
    const {isLoading, cars} = this.props;
    return (
      <div className="cars-page">
        {
          isLoading &&
          <div>LOADING</div>
        }
        {
          !isLoading &&
          <div className="cars-list">
            {cars.map(car => (
              <div><Link to={'./' + car.registration}>{car.model}</Link></div>
            ))}
          </div>
        }
        <CarsStats />
      </div>
    );
  }
}

const mapStateToProps = state => ({
  ...state
});
// if there is no 'map dispatch', by default it maps props.dispatch to store's dispatch

export default connect(mapStateToProps)(CarsPage);