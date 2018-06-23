import React from 'react';
import {Route} from 'react-router-dom';

export default class SideBarLink extends React.Component {
  render() {
    let {label, goTo} = this.props;
    return (
      <Route
        path={goTo}
        children={props => <LinkChild {...props} label={label} goTo={goTo} />}
      />
    )
  }
}

const LinkChild = ({match, history, label, goTo}) => (
  <div className="side-bar-link">
    {match && ">>> "}
    <a onClick={() => history.push(goTo)}>{label}</a>
  </div>
);