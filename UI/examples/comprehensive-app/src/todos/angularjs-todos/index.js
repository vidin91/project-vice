import React from 'react';
import angular from 'angular';
import app from './App.js';
import './AppController';
import './AppService';
import './MessageSErviceProvider';
import './AlertService';
import mainTemplate from './main.template.html';

// app.decorator('alertService', function () {
//   // Decorating alertService to do console.log instead of alert
//   // in this case I basically override alertService
//   return {
//     alert: message => console.log(message)
//   };
// });

export default class AngularJSTodo extends React.Component {
  componentDidMount() {
    this.container.innerHTML = mainTemplate;
    app.config(function (messageServiceProvider) {
      messageServiceProvider.setMessage('This is new message');
    });
    angular.bootstrap(this.container, ['todoApp']);
  }

  render() {
    return (
      <div>
        <div ref={r => this.container = r} />
      </div>
    );
  }
}
