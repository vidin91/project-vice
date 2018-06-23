package projectvice.examples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerExample {
  public static class Counter {
    int val = 0;
    void increment() {this.val++;}
  }
  public static void attempt1() {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    Counter cnt = new Counter();
    IntStream.range(0, 1000).forEach(i -> {
      executor.submit(() -> cnt.increment());
    });
    try {
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(cnt.val);
    // Gives unpredictable output from the range 980-1000
  }
  
  public static void attempt2() {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    AtomicInteger cnt = new AtomicInteger();
    IntStream.range(0, 1000).forEach(i -> {
      executor.submit(() -> cnt.incrementAndGet());
    });
    try {
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(cnt.get());
    // Always gives 1000
  }
  
  public static void main(String [] args) {
    attempt1();
    attempt2();
  }

}
