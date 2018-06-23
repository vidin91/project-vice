package projectvice.examples.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class StreamCollectors2Example {
  static class Accumulator {
    int cnt = 0;
    int sum = 0;
    List<Integer> sums = new ArrayList<Integer>();
  }
  public static void main(String[] args) {
    /*
     * Sums elements in groups of 3
     */
    Collector<Integer, Accumulator, List<Integer>> myCollector = Collector.of(
      () -> new Accumulator(),
      (acc, number) -> {
        acc.sum += number;
        acc.cnt += 1;
        if (acc.cnt == 3) {
          acc.sums.add(acc.sum);
          acc.sum = 0;
          acc.cnt = 0;
        }
      },
      (a, b) -> a,
      (acc) -> acc.sums
    );
    
    List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().collect(myCollector);
    System.out.println(result);
  }
}
