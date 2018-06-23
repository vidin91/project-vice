import React from 'react';

export default class About extends React.Component {
  state = {}
  componentDidMount() {
    import('./AboutContent').then(component => {
      this.setState({LazyComponent: component.default});
    });
  }

  render() {
    const {LazyComponent} = this.state;
    return (
      <div>
        About content
        {
          LazyComponent &&
          <LazyComponent />
        }
      </div>
    );
  }
}