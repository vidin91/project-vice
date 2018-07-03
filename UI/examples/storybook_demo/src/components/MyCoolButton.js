import React from 'react';
import PropTypes from 'prop-types';

export default class MyCoolButton extends React.Component {
  static propTypes = {
    variant: PropTypes.oneOf(['primary', 'secondary']),
    onClick: PropTypes.func,
    disabled: PropTypes.bool,
    children: PropTypes.string
  }

  static defaultProps = {
    variant: 'primary',
    onClick: () => {},
    disabled: false
  }

  styles = {
    backgroundColor: '#03A9F4',
    color: 'white',
    fontWeight: 'bold',
    border: 'none',
    margin: 0,
    padding: '7px',
    borderRadius: '6px'
  }

  render() {
    const {variant, onClick, disabled} = this.props;
    const styles = Object.assign({}, this.styles, {backgroundColor: variant === 'primary' ? '#03A9F4' : 'green'});
    return (
      <button className="button-component" style={styles} onClick={onClick}>
        {this.props.children}
      </button>
    );
  }
}
