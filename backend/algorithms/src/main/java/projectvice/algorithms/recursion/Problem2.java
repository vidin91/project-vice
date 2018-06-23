/**
 * N-QUEENS PROBLEM
 * Find all possible ways of placing n queens on an n x n
 * chess board so that no two queens occupy the same row,
 * column, or diagonal.
 */
package projectvice.algorithms.recursion;

import java.util.Arrays;

public class Problem2 {
  public static void displayBoards(int n) {
    int[] queens = new int[n];
    Arrays.fill(queens, 0);
    visitRow(0, n, queens);
  }
  
  public static void visitRow(int row, int n, int[] queens) {
    if (row == n) {
      // we placed all queens
      printBoard(queens);
      return;
    }
    for (int column = 0; column < n; column++) {
      if (isSafe(row, column, queens)) {
        queens[row] = column;
        visitRow(row + 1, n, queens);
      }
    }
  }
  
  public static boolean isSafe(int row, int column, int[] queens) {
    for (int i = 0; i < row; i++) {
      // i is previous queen row, and queens[i] is a column
      if (queens[i] == column) return false; // in the same column
      if (Math.abs(row - i) == Math.abs(column - queens[i])) return false; // not on the same way diagonally
    }
    return true;
  }
  
  public static void printBoard(int[] queens) {
    for (int row = 0; row < queens.length; row++) {
      for (int column = 0; column < queens.length; column++) {
        if (queens[row] == column) {
          System.out.print("X ");
        } else {
          System.out.print("0 ");
        }
      }
      System.out.println("");
    }
    System.out.println("");
  }
  
  public static void main(String[] args) {
    displayBoards(10);
  }
}
