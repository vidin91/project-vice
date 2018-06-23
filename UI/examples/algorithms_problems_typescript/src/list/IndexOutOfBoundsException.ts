export class IndexOutOfBoundsException extends Error {
  constructor() {
    super('Index exceeded valid bounds');
  }
};