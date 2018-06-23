import angular from 'angular';
import App from './App';

App.provider('messageService', function () {
  let message = 'Hello Milos!';
  this.setMessage = m => message = m;

  this.$get = function () {
    return {
      getMessage: () => message
    };
  }
});