import React from 'react';
import SideBarLink from './SideBarLink';

export default class SideBar extends React.Component {
  render() {
    return (
      <div>
        <SideBarLink label="Go to home page" goTo="/home" />
        <SideBarLink label="Visit About" goTo="/about" />
        <SideBarLink label="Todos" goTo="/todos" />
      </div>
    )
  }
}