package projectvice.examples.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
  public static void main(String args[]) throws InterruptedException {
    int i = 0;
    Executor executor = Executors.newFixedThreadPool(2);
    while (i++ < 2) {
      executor.execute(new Runnable() {
        public void run() {
          System.out.println(Thread.currentThread());
        }
      });
    }
    //Executor service inherits Executor but it has much richer API
    ExecutorService executorService = (ExecutorService) executor;
    
    executorService.shutdown();
    // Await blocks current thread but it doesn't send shutdown signal, so shutdown() should
    // be called first.
    executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
    System.out.println("done");
  }
}
