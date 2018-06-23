import {IndexOutOfBoundsException} from './IndexOutOfBoundsException';

export class List {
  private list: ListNode = null;
  private size = 0;

  public constructor(elements?: Array<Number>) {
    if (elements) {
      let val = elements.pop();
      while (val) {
        this.list = {value: val, next: this.list};
        this.size++;
        val = elements.pop();
      }
    }
  }
  /**
   * Inserts new value at the beginning of the list
   * @param {*} value 
   */
  insert(value: any): void {
    let node: ListNode = {
      value,
      next: this.list
    };
    this.list = node;
    this.size++;
  }

  insertAt(position: number, value: any): void {
    if (position < 0 || position > this.size) {
      throw new IndexOutOfBoundsException();
    }
    let i = 0;
    let curr: ListNode = this.list;
    if (position === 0) {
      this.list = {value, next: this.list};
    } else {
      position--; //insertAt position is insertAfter position-1;
      while (i++ < position && curr) curr = curr.next;
      let newNode = {value, next: curr.next};
      curr.next = newNode;
    }
    this.size++;
  }
  remove(): any {
    if (this.size === 0) {
      throw new Error('List is empty');
    }
    let ret = this.list.value;
    this.list = this.list.next;
    this.size--;
    return ret;
  }

  reverse(): void {
    let curr: ListNode = this.list;
    let prev: any = null;
    while (curr) {
      let next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    this.list = prev;
  }

  reverseInGroups(k: number) {
    debugger;
    let curr = this.list;
    let prev;
    let next;
    let firstLoop = true;
    let lastLink = this.list;
    while (curr) {
      let potentialLink = curr;
      let n = k;
      prev = null;
      next = curr;
      while (n-- > 0 && next) {
        curr = next;
        next = next.next;
        curr.next = prev;
        prev = curr;
      }
      if (!firstLoop) {
        lastLink.next = curr;
        lastLink = potentialLink;
      } else {
        this.list = curr;
      }
      curr = next;
      firstLoop = false;
    }
  }

  concat(newList: List): void {
    if (!this.list) {
      this.list = newList.list;
      return;
    }
    let last = this.list;
    while (last.next) last = last.next;
    last.next = newList.list;
    this.size += newList.size;
  }

  /**
   * Example: 1->2->3, 5->6->7->8->9
   * after merge: 1->5->2->6->3->7, 8->9
   * @param list 
   */
  mergeAlternate(list: List): void {
    let curr_a = this.list;
    let curr_b = list.list;
    let next_a;
    let next_b;

    while (curr_a && curr_b) {
      next_a = curr_a.next;
      next_b = curr_b.next;

      curr_a.next = curr_b;
      curr_b.next = next_a;

      curr_a = next_a;
      curr_b = next_b;
    }
    list.list = next_b;
  }

  toString(): String {
    let ret: String = '';
    let curr: ListNode = this.list;
    while (curr) {
      if (curr !== this.list) {
        ret += ', ';
      }
      ret += curr.value;
      curr = curr.next;
    }
    return ret;
  }
}

interface ListNode {
  value?: any;
  next: ListNode | null;
}