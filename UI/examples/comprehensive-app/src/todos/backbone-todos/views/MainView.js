import Backbone from 'backbone';
import TodoView from './TodoView';
import mainViewTemplate from '../templates/mainView.template.handlebars';
import footerTemplate from '../templates/footer.template.handlebars';
import TodoCollection from '../collections/TodoCollection';

export default Backbone.View.extend({
  events: {
    'click .add-button': 'onAddNewItem'
  },

  initialize: function () {
    this.model = new TodoCollection();
    this.listenTo(this.model, 'add', this.addNewItem);
    this.listenTo(this.model, 'change:completed', this.renderFooter);
    this.listenTo(this.model, 'remove', this.renderFooter);
    this.render();
  },

  onAddNewItem: function () {
    let val = this.$input.val().trim();
    if (val) {
      this.model.add({text: val});
      this.$input.val('');
    }
  },

  addNewItem: function (model) {
    this.$list.append(new TodoView({model}).render().$el);
    this.renderFooter();
  },

  renderFooter: function() {
    this.$footer.html(footerTemplate({
      total: this.model.length,
      completed: this.model.completed().length,
      labels: ['label1', 'label2', 'label3']
    }));
  },

  render: function () {
    this.$el.html(mainViewTemplate());
    this.$input = this.$el.find('.search-box input[type="text"]');
    this.$list = this.$el.find('.list');
    this.$footer = this.$el.find('.footer');
    this.renderFooter();
    return this;
  },

  myDestroy: function () {
    this.remove();
  }
});