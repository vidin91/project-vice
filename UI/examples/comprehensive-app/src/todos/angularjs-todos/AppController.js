import angular from 'angular';
import todoApp from './App';

todoApp.controller('AppController', function ($scope, todoService, messageService, alertService) {
  alertService.alert('staring app...');
  $scope.message = messageService.getMessage();
  $scope.show = false;
  $scope.todos = [];
  $scope.inputText = '';
  $scope.completedNum = 0;
  $scope.visibleFilter = {};
  $scope.newTodo = () => {
    $scope.todos = todoService.newTodo($scope.inputText);
    $scope.inputText = '';
  }
  $scope.toggleTodo = (id) => {
    $scope.todos = todoService.toggleTodo(id);
  }
  $scope.removeTodo = (id) => {
    $scope.todos = todoService.removeTodo(id);
  }
  $scope.filter = (value) => {
    if (!value) {
      $scope.visibleFilter = {};
    } else {
      $scope.visibleFilter = {completed: value === 'completed'};
    }
  }
  $scope.removeCompleted = () => {
    $scope.todos = todoService.removeCompleted();
  }

});
