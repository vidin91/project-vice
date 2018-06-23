/**
 * @fileoverview Binary-Search-Tree
 * By definition, for each node, left descendant is value(left) < value(node),
 * and for the right one value(right) > value(node) (or >= if there repeating is allowed)
 * Creating BST for an existing collection just for searching is an expencive, but
 * if we want to make collection that is going to stay sorted, it OK to use BST.
 */

export class BST {
  private root: Node = null;

  /**
   * TODO
   * In general, searching performace depends on how tree is balanced. Naive solution for insertion
   * would be to everytime compare value with current node - if it's smaller add it as left, it greater
   * add it as right node. For sorted input sequence like 1,2,3,4,5 - tree is not balanced at all.
   * @param {number} value 
   */
  insert(value: number) {
    
  }

  /**
   * When we have BST, we can easily recreate input sequence by traversing it in "inorder" manner.
   */
  toArray() {

  }
}

interface Node {
  value: number,
  left: Node,
  right: Node
};