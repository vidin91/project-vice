import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Link} from 'react-router-dom';
import Home from './home';
import About from './about';
import Todos from './todos'
import {SideBar} from './sidebar';
import './index.less';

const WelcomeLabel = () => <div>Welcome to our app!</div>;

const App = () => (
  <BrowserRouter>
  {/*BrowserRouter is allowed to have only one child element*/}
    <div className="app-shell">
      <div className="header">
        {/*This should be always visible no matter what is in path param!
        When using render instead of children, works the same as with component*/}
        <Route path="/salaba" children={<WelcomeLabel />} />
      </div>
      <div className="content">
        <div className="side-bar-nav">
          <Route path="/" component={SideBar} />
        </div>
        <div className="main-content">
          <Route path="/home" component={Home} />
          {/*"milos" is visible if path starts with "a"*/}
          <Route path="/a*" render={() => <div>milos</div>} />
          <Route path="/about" component={About} />
          <Route path="/todos" component={Todos} />
        </div>
      </div>
    </div>
  </BrowserRouter>
);

ReactDOM.render(<App />, document.getElementById('root'));
