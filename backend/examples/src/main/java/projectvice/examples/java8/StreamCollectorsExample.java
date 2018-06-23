package projectvice.examples.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class StreamCollectorsExample {
  public static void main(String[] args) {
    Collector<String, LinkedList<String>, Integer> myCollector = Collector.of(
        () -> new LinkedList<String>(),
        (acc, item) -> {
          acc.add(item);
        },
        (acc1, acc2) -> {
          System.out.println("been here");
          return acc1;
        },
        (acc) -> {
          return acc.size();
        }
      );
    
    int a = Arrays.asList("Milos", "Marko", "Janko")
                  .stream()
                  .map(name -> {
                    return name;
                  })
                  .collect(myCollector);
    System.out.println(a);
    //OUTPUT: 3
  }
  
}
