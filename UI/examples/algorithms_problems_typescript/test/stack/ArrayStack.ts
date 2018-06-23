import {ArrayStack} from '../../src/stack/ArrayStack';
import {assert} from 'chai';
import 'mocha';

describe('ArrayStack', () => {
  let testStack: ArrayStack;
  beforeEach(() => {
    testStack = new ArrayStack(10);
  });

  it('gets correct stack size', () => {
    testStack.push(22);
    testStack.push(33);
    assert.equal(testStack.size(), 2);
  });

  it('throws an error on pop from empty stack', () => {
    assert.throws(() => testStack.pop());
  });

  it('push/pop leave stack in consistant state', () => {
    testStack.push(22);
    testStack.push(11);
    testStack.pop();
    assert.equal(testStack.pop(), 22);
  });
});