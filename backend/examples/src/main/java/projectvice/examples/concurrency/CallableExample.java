package projectvice.examples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newSingleThreadExecutor();
    Callable<List<String>> task = new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        Thread.sleep(2000);
        return Arrays.asList("Milos", "Mirko");
      }
    };
    Future<List<String>> future = service.submit(task);
    System.out.println(future.get());
    service.shutdown();
  }
}
