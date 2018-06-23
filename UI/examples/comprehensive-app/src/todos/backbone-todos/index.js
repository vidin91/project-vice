import React from 'react';
import MainView from './views/MainView';

export default class Todos extends React.Component {
  componentDidMount() {
    this.view = new MainView({el: this.container});
  }

  shouldComponentUpdate() {
    return false;
  }

  render() {
    return (
      <div>
        <div className="backbone-root" ref={r => this.container = r} />
      </div>
    );
  }

  componentWillUnmount() {
    this.view.myDestroy();
  }
}