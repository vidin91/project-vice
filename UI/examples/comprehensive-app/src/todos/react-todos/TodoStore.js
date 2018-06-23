/**
 * @fileoverview This file demonstrates how to simply create store for todos page.
 * By redux best practices, you should have root reducer (store) per App, not per page, but this was done
 * for demo purpose.
 * TODO - What If one state depends on another - In this case, what if I wanted to set todos based on filter ?
 */


import {createStore, combineReducers} from 'redux';

export const ACTIONS = {
  NEW_TODO: 'NEW_TODO',
  TOGGLE_TODO: 'TOGGLE_TODO',
  REMOVE_TODO: 'REMOVE_TODO',
  CHANGE_FILTER: 'CHANGE_FILTER'
};

export const FILTERS = {
  SHOW_ALL: 'SHOW_ALL',
  SHOW_COMPLETED: 'SHOW_COMPLETED',
  SHOW_ACTIVE: 'SHOW_ACTIVE'
};

let lastTodoID = 0;

export function addNewTodo(text) {
  return {
    type: ACTIONS.NEW_TODO,
    payload: {
      id: lastTodoID++,
      text,
      completed: false
    }
  };
};

export function toggleTodo(id) {
  return {
    type: ACTIONS.TOGGLE_TODO,
    payload: {
      id
    }
  };
}

export function removeTodo(id) {
  return {
    type: ACTIONS.REMOVE_TODO,
    payload: {
      id
    }
  };
}

export function changeFilter(newValue) {
  return {
    type: ACTIONS.CHANGE_FILTER,
    payload: {
      filter: newValue
    }
  };
}

function todosReducer (state = [], action) {
  switch(action.type) {
    case ACTIONS.NEW_TODO:
      return [...state, action.payload];
    case ACTIONS.TOGGLE_TODO:
      return state.map(todo => {
        if (todo.id === action.payload.id) {
          return {
            id: todo.id,
            text: todo.text,
            completed: !todo.completed
          };
        }
        return todo;
      });
    case ACTIONS.REMOVE_TODO:
      return state.filter(item => item.id !== action.payload.id);
  }
}

function filtersReducer (state = FILTERS.SHOW_ALL, action) {
  if (action.type === ACTIONS.CHANGE_FILTER) {
    return action.payload.newValue;
  }
  return state;
}

function rootReducer (state = {}, action) {
  return {
    todos: todosReducer(state.todos, action),
    filter: filtersReducer(state.filter, action)
  };
}

export default createStore(rootReducer);
