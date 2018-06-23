export interface Stack {
  size(): number;
  push(value: any): void;
  pop(): any;
}
