import Backbone from 'backbone';
import Todo from '../models/Todo';

export default Backbone.Collection.extend({
  model: Todo,
  completed: function () {
    return this.where({completed: true});
  }
});
