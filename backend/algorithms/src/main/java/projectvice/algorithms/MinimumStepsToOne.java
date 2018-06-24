/**
 * Problem:
 * On a positive integer, you can perform any one of the following 3 steps.
 * 1.) Subtract 1 from it. ( n = n - 1 ),
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  ),
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 */

package projectvice.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsToOne {
  static class Node {
    Node parent;
    int n;
    String operation;
    Node(Node parent, int n, String operation) {
      this.parent = parent;
      this.n = n;
      this.operation = operation;
    }
  }
  static void printSteps(int n) {
    boolean[] visited = new boolean[n + 1];
    Queue<Node> toVisit = new LinkedList<>();
    toVisit.offer(new Node(null, 1, ""));
    while (!toVisit.isEmpty()) {
      Node current = toVisit.poll();
      visited[current.n] = true;
      if (current.n == n) {
        // found, print path
        while (current != null) {
          System.out.print(current.operation);
          current = current.parent;
        }
        break;
      }
      int next = current.n + 1;
      if (next <= n && !visited[next]) {
        toVisit.offer(new Node(current, next, "SUB "));
      }
      next = current.n * 2;
      if (next <= n && !visited[next]) {
        toVisit.offer(new Node(current, next, "DIV_2 "));
      }
      next = current.n * 3;
      if (next <= n && !visited[next]) {
        toVisit.offer(new Node(current, next, "DIV_3 "));
      }
    }
  }
  

  public static void main(String[] args) {
    printSteps(100);

  }

}
