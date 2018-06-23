import React from 'react';
import autobind from 'autobind-decorator';
import TodoStore, {
  ACTIONS,
  FILTERS,
  addNewTodo,
  toggleTodo,
  removeTodo,
  changeFilter
} from './TodoStore';

@autobind
export default class TodosPage extends React.Component {
  state = {
    newTodo: ''
  }

  addNewTodo() {
    TodoStore.dispatch(addNewTodo(this.state.newTodo));
    this.setState({newTodo: ''});
  }

  toggleTodo(id) {
    TodoStore.dispatch(toggleTodo(id));
  }

  removeTodo(id) {
    TodoStore.dispatch(removeTodo(id));
  }

  componentDidMount() {
    this.unsubscribe = TodoStore.subscribe(() => {
      this.setState(TodoStore.getState());
    });
  }

  render() {
    return (
      <div>
        <div>
          <input
            type="text"
            value={this.state.newTodo}
            onChange={e => this.setState({newTodo: e.currentTarget.value})} />
          <button onClick={this.addNewTodo}>Add new Todo</button>
        </div>
        <div>
          {
            this.state.todos &&
            this.state.todos.map(todo => (
              <TodoItem
                key={todo.id}
                todo={todo}
                onToggle={this.toggleTodo}
                onRemove={this.removeTodo} />
            ))
          }
        </div>
      </div>
    )
  }
}

class TodoItem extends React.Component {
  render() {
    let {todo} = this.props;
    // let props = {};
    // if (todo.completed) {
    //   props.checked = true;
    // }
    return (
      <div>
        <input type="checkbox" checked={todo.completed} onChange={e => this.props.onToggle(todo.id)} />
        {todo.text}
        <button onClick={() => this.props.onRemove(todo.id)}>remove</button>
      </div>
    );
  }
}