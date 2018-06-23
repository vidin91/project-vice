import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import './App.css';

class App extends Component {
  renderHomeContent() {
    return (
      <div className="home">
        This is home page
      </div>
    )
  }

  render() {
    return (
      <Router>
        <div className="main">
          <div className="header">
            <Link to="/">home</Link>
            <Link to="/events">events</Link>
          </div>
          <div className="content">
            <Route exact="true" path="/" render={() => this.renderHomeContent()} />
            <Route path="/events" render={() => <div>events</div>} />
          </div>
        </div>
      </Router>
    )
  }
}

export default App;
