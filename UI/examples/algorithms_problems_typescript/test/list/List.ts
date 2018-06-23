import {List} from '../../src/list/List';
import {assert} from 'chai';
import 'mocha';

describe.only('List', () => {
  let list: List;
  beforeEach(() => {
    list = new List();
  });

  it('makes List from an array of numbers', function () {
    let list = new List([1, 2, 3, 4, 5]);
    assert.equal(list.toString(), '1, 2, 3, 4, 5');
  })

  it('inserts one element, and removes', () => {
    list.insert(10);
    assert.equal(list.remove(), 10);
  });

  it('insertAt position 2 throws an error', () => {
    list.insert(10);
    assert.throws(() => list.insertAt(2, 20));
  });

  it('inserts elements in correct order, and print them', () => {
    list.insertAt(0, 10);
    list.insertAt(1, 20);
    list.insertAt(0, 30);
    list.insertAt(1, 40);
    assert.equal(list.toString(), '30, 40, 10, 20');
  });

  it('reverse works', () => {
    list.insert(10);
    list.insert(20);
    list.insert(30);
    assert.equal(list.toString(), '30, 20, 10');
    list.reverse();
    assert.equal(list.toString(), '10, 20, 30');
  });

  it('concats empty list with new one', () => {
    let newList = new List();
    newList.insert(10);
    newList.insert(20);
    list.concat(newList);
    assert.equal(list.toString(), '20, 10');
  });

  it('concats two non-empty lists', () => {
    let newList = new List();
    newList.insert(10);
    newList.insert(20);
    list.insert(1);
    list.insert(2);
    list.concat(newList);
    assert.equal(list.toString(), '2, 1, 20, 10');
  });

  it('mergeAlternate works', function () {
    let list_a = new List([1, 2, 3]);
    let list_b = new List([5, 6, 7, 8, 9]);
    list_a.mergeAlternate(list_b);
    assert.equal(list_a.toString(), '1, 5, 2, 6, 3, 7');
    assert.equal(list_b.toString(), '8, 9');
  });

  it('xxx', function () {
    let list_a = new List([1, 2, 3, 4, 5, 6, 7]);
    list_a.reverseInGroups(5);
    console.log(list_a.toString());
  })
});
