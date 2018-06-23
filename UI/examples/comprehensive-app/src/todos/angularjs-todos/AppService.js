import angular from 'angular';
import app from './App';

app.service('todoService', function () {
  let todos = [];
  let lastID = 0;
  this.newTodo = function (text) {
    todos.push({
      text,
      completed: false,
      id: lastID++
    });
    return todos;
  }

  this.toggleTodo = function (id) {
    let todo = todos.find(i => i.id === id);
    if (todo) {
      todo.completed = !todo.completed;
    }
    return todos;
  }

  this.removeTodo = function (id) {
    let index = todos.findIndex(i => i.id === id);
    if (index >=0) {
      todos.splice(index, 1);
    }
    return todos;
  }

  this.removeCompleted = function () {
    return todos = todos.filter(t => !t.completed);
  }
});