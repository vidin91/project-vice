import React from 'react';
import {Link, Route, withRouter, Redirect} from 'react-router-dom';
import ReactTodos from './react-todos';
import BackboneTodos from './backbone-todos';
import AngularTodos from './angularjs-todos';
import './style/index.less';

export default class Todos extends React.Component {
  render () {
    const {url} = this.props.match;
    if (this.props.match.isExact) {
      // It means: path is equal '/todos'
      return <Redirect to={url + '/react'} />
    }
    return (
      <div className="todos-page">
        <div className="side-menu">
          {/* I didn't have to wrap this in router since TopLevel Class is already inside router
          This was only for demo purpose */}
          <SideMenu />
        </div>
        <div className="todos-main">
          <Route path={url + '/react'} component={ReactTodos} />
          <Route path={url + '/backbone'} component={BackboneTodos} />
          <Route path={url + '/angularjs'} component={AngularTodos} />
        </div>
      </div>
    )
  }
}

const SideMenu = withRouter(({match}) => (
  <div>
    <Link to={match.path + '/react'}>React todos</Link>
    <Link to={match.path + '/backbone'}>Backbone todos</Link>
    <Link to={match.path + '/angularjs'}>AngularJS todos</Link>
  </div>
));

const InitialRedirect = withRouter(function () {
  //debugger;
  return null;
});