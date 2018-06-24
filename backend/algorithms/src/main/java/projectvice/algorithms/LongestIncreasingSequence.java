/**
 * Longest Increasing Sequence
 * Problem: For the given input array of natural numbers, find the longest increasing sequence.
 * Example: [1, 4, 5, 3, 4, 8, 7, 10, 11] => [3, 4, 8]
 */

package projectvice.algorithms;

public class LongestIncreasingSequence {
  static void approach_1(int[] input) {
    int longestLength = 1;
    int index = 0;
    for (int i = 0; i < input.length; i++) {
      int currentLength = 1;
      for (int j = i + 1; j < input.length && input[j] >= input[j - 1]; j++) {
        currentLength++;
      };
      if (currentLength > longestLength) {
        longestLength = currentLength;
        index = i;
      }
    }
    for (int i = index; i < index + longestLength; i++)
      System.out.print(input[i]);
  }
  
  public static void main(String [] args) {
    approach_1(new int[] {1, 7, 5, 3, 4, 8, 7, 10, 11});
  }
}
