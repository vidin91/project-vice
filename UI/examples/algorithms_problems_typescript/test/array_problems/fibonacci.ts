import {fibonacci, fibonacciRecursion} from '../../src/array_problems/fibonacci';
import {assert} from 'chai';

describe('fibonacci', function () {
  it('works as expected', function () {
    assert.equal(fibonacci(7), 13);
    assert.equal(fibonacci(5), 5);
    assert.equal(fibonacciRecursion(7), 13);
    assert.equal(fibonacciRecursion(5), 5);
  });
});
