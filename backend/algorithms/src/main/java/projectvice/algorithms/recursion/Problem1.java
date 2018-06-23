/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid.
 * The robot can only move in two directions: right and down. How many possible 
 * paths are there for the robot to get to the bottom-right end?
 * FOLLOW UP
 * Imagine robot MUST visit certain cell on it's path.
 * 
 * TODO - Write mathematical function that counts total number of paths
 */
package projectvice.algorithms.recursion;

public class Problem1 {
  public static String[] visit (int x, int y, int n) {
    if (x == n && y == n) {
      // we reached the destination
      return new String[] {"(" + x + "," + y + ")"};
    }
    String[] rightPart = null;
    String[] downPart = null;
    if (x < n) {
      // can move right
      rightPart = visit(x + 1, y, n);
    }
    if (y < n) {
      // can move down
      downPart = visit(x, y + 1, n);
    }
    int length = 0;
    if (rightPart != null) length += rightPart.length;
    if (downPart != null) length += downPart.length;

    String[] ret = new String[length];
    int i = 0;
    if (rightPart != null) {
      for (String s : rightPart) {
        ret[i++] = "(" + x + "," + y + ") -> " + s;
      }
    }
    if (downPart != null) {
      for (String s : downPart) {
        ret[i++] = "(" + x + "," + y + ") -> " + s;
      }
    }
    return ret;
  }
  
  public static String[] visitOver (int x, int y, int n, int overX, int overY) {
    if (x == n && y == n) {
      // we reached the destination
      return new String[] {"(" + x + "," + y + ")"};
    }
    String[] rightPart = null;
    String[] downPart = null;
    boolean reachedOverCell = x >= overX && y >= overY;
    if (x < n) {
      if (!reachedOverCell && x < overX || reachedOverCell) {
        rightPart = visitOver(x + 1, y, n, overX, overY);
      }
    }
    if (y < n) {
      if (!reachedOverCell && y < overY || reachedOverCell) {
        downPart = visitOver(x, y + 1, n, overX, overY);
      }
    }
    int length = 0;
    if (rightPart != null) length += rightPart.length;
    if (downPart != null) length += downPart.length;

    String[] ret = new String[length];
    int i = 0;
    if (rightPart != null) {
      for (String s : rightPart) {
        ret[i++] = "(" + x + "," + y + ") -> " + s;
      }
    }
    if (downPart != null) {
      for (String s : downPart) {
        ret[i++] = "(" + x + "," + y + ") -> " + s;
      }
    }
    return ret;
  }
  
  public static void main(String[] args) {
    int N = 3;
    String[] paths = visit(0, 0, N - 1);
    for (String s : paths) {
      System.out.println(s);
    }
    
    paths = visitOver(0, 0, N - 1, 1, 1);
    System.out.println("Visiting over: (1, 1)");
    for (String s : paths) {
      System.out.println(s);
    }
  }
}
