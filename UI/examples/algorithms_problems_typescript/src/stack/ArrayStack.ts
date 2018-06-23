import {Stack} from './Stack';

export class ArrayStack implements Stack {
  private array: Array<number>;
  private tail: number;

  constructor(size: number = 10) {
    this.array = new Array(size);
    this.tail = 0;
  }

  size(): number {
    return this.tail;
  }

  push(value: number) {
    if (this.tail === this.array.length) {
      throw new Error('Not enough space');
    }
    this.array[this.tail++] = value;
  }

  pop(): number {
    if (this.tail === 0) {
      throw new Error('Stack is empty');
    }
    return this.array[--this.tail];
  }
  toString(): String {
    return this.array.toString();
  }
}