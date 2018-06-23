import {binarySearch, binarySearchRecursive} from '../../src/searching/binarySearch';
import {assert} from 'chai';
import 'mocha';

describe('binarySearch', () => {
  var testArray = [1, 3, 4, 6, 8, 10, 11];
  it('finds correct index', () => {
    assert.equal(binarySearch(testArray, 8), 4);
    assert.equal(binarySearchRecursive(testArray, 6), 3);
  });

  it('can\'t find number, returns -1', () => {
    assert.equal(binarySearch(testArray, 7), -1);
    assert.equal(binarySearch(testArray, 0), -1);
    assert.equal(binarySearchRecursive(testArray, 20), -1);
  });
});
