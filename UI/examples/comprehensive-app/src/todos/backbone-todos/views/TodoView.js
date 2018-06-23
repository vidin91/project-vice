import Backbone from 'backbone';
import todoViewTemplate from '../templates/todoView.template.handlebars';

export default Backbone.View.extend({
  events: {
    'click input[type="checkbox"]': 'onToggle',
    'click .remove-button': 'onRemove'
  },

  initialize: function () {
    this.listenTo(this.model, 'destroy', this.remove);
    this.render();
  },

  onToggle: function (e) {
    this.model.set('completed', e.target.checked);
  },

  onRemove: function (e) {
    this.model.destroy();
  },

  render: function () {
    this.$el.html(todoViewTemplate(this.model.toJSON()));
    return this;
  }
});