import {insertionSort} from '../../src/sorting/insertionSort';
import {assert} from 'chai';
import 'mocha';

describe('insertionSort', () => {
  it('sorts an array corectly', () => {
    assert.deepEqual(insertionSort([1, 5, 3, 10, 7, 6]), [1, 3, 5, 6, 7, 10]);
  });
})