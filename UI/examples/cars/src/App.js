import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import {Provider} from 'react-redux';
import thunk from 'redux-thunk';
import {createLogger} from 'redux-logger';
import {createStore, applyMiddleware} from 'redux';
import CarsPage from './cars/CarsPage';
import CarsStats from './cars/CarsStats';
import About from './About';
import {cars as carsReducer} from './Reducers';

const store = createStore(carsReducer, applyMiddleware(thunk, createLogger()));

class App extends Component {
  renderGridExample() {
    return (
      <div className="grid-container">
        <div className="first-item">MILOS MILENOVIC</div>
        <div className="second-item">PETAR PETROVIC</div>
        <div className="third-item">Marko Kraljevic</div>
        <div className="fourth-item">Kristijan Golubovic</div>
        <div className="fifth-item">Janes Drsko</div>
        <div className="sixth-item">Guzer Kruzer</div>
        <div className="seventh-item">Novak Jokic</div>
      </div>
    )
  }
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="main">
            <div className="header">
              <Link to="/">Home</Link>
              <Link to="/cars">Cars</Link>
              <Link to="/carsstats">Cars Stats</Link>
              <Link to="about">About</Link>
              <Link to="grid">Grid</Link>
            </div>
            <div className="content">
              <Route path="/" exact render={() => <div>HomePage</div>} />
              <Route path="/cars" component={CarsPage} />
              <Route path="/carsstats" component={CarsStats} />
              <Route path="/about" component={About} />
              <Route path="/grid" render={this.renderGridExample} />
            </div>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
