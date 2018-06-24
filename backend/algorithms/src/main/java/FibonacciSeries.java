
public class FibonacciSeries {
  /**
   * Naive solution - to much wasted CPU cycles
   * Example:
   * f(5)
   * -> f(4) + f(3)
   * -> (f(3) + f(2)) + (f(2) + f(1))
   * -> ((f(2) + f(1)) + (f(1) + f(0))) + ((f(1) + f(0)) + (1)...
   * => To much overlapping sub-problems, function is being called with the same arguments
   * many times. This is more obvious with larger numbers. For instance, finding Fibonacci(50) with
   * this approach is almost impossible!
   * => Simple solution - Memoization.
   * => Another solution - Dynamic Programming - finding results for smaller inputs
   */
  static int fibonacci_1(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci_1 (n - 1) + fibonacci_1(n - 2);
  }
  /**
   * Improved approach - using memoization
   * @param n
   * @return
   */
  static long fibonacci_2(int n) {
    return fibonacci_2_help(n, new long[n + 1]);
  }

  static long fibonacci_2_help(int n, long[] lookup) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (lookup[n] > 0) return lookup[n];
    lookup[n] = fibonacci_2_help(n - 1, lookup) + fibonacci_2_help(n - 2, lookup);
    return lookup[n];
  }

  public static void main(String[] args) {
    System.out.println(fibonacci_2(50));
  }

}
