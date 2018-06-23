import React from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';

export class CarsStats extends React.Component {
  static propTypes = {
    carsCount: PropTypes.number.isRequired
  }

  render() {
    return (
      <div className="cars-stats">
        Total cars: {this.props.carsCount}
      </div>
    );
  }
}

export default connect(state => ({
  carsCount: state.cars && state.cars.length || 0
}))(CarsStats);
