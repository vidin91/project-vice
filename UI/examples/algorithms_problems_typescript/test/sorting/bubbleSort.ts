import {bubbleSort} from '../../src/sorting/bubbleSort';
import {assert} from 'chai';
import 'mocha';

describe('bubbleSort', () => {
  it('sorts an array corectly', () => {
    assert.deepEqual(bubbleSort([1, 5, 3, 10, 7, 6]), [1, 3, 5, 6, 7, 10]);
  });
})