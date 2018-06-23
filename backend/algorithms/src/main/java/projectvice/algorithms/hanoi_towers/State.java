package projectvice.algorithms.hanoi_towers;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class State {
  /**
   * note that everything can be valid state, but not all transitions are valid!
   */
  protected int x; // bigger disk
  protected int y; // smaller disk, if x == y assumption is that y is on top of x
  protected State parent;
  protected List<State> children = new LinkedList<State>();

  State(int x, int y, State parent) {
    this.x = x;
    this.y = y;
    this.parent = parent;
  }
  
  State(int x, int y) {
    this(x, y, null);
  }

  void expand() {
    // try to move x
    int[] nextX;
    if (this.x == this.y) {
      // can't move x since it's under y
      nextX = new int[] {this.x};
    } else {
      // can't end up on top of y
      nextX = IntStream.of(1, 2, 3).filter(i -> i != this.y).toArray();
    }
    
    // y can always move
    int[] nextY = new int[] {1, 2, 3};
    
    for (int x: nextX) {
      for (int y: nextY) {
        if (!(x != this.x && y != this.y)) {
          if (!this.doesExistOnPath(x, y)) {
            this.children.add(new State(x, y, this));
          }
        }
      }
    }

  }
  
  boolean isEqual(State s) {
    return this.x == s.x && this.y == s.y;
  }
  
  boolean doesExistOnPath(int x, int y) {
    if (this.x == x && this.y == y) return true;
    State curr = this.parent;
    while (curr != null) {
      if (curr.x == x && curr.y == y) return true;
      curr = curr.parent;
    }
    return false;
  }
}
