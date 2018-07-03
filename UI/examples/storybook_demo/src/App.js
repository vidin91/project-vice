import React, { Component } from 'react';
import MyCoolButton from './components/MyCoolButton';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <MyCoolButton onClick={() => alert('done')}>CLICK ME</MyCoolButton>
      </div>
    );
  }
}

export default App;
