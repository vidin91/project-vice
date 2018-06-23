import angular from 'angular';
import app from './App';

app.service('alertService', function () {
  this.alert = message => {
    alert(message);
  }
});
