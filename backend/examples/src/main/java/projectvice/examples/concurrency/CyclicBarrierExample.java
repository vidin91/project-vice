package projectvice.examples.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
  public static void main(String[] args) {
    Runnable barrierAction = new Runnable() {
      public void run() {
        System.out.printf("Barrier action is being executed by thread: %s. %n",
                          Thread.currentThread().getName());
      }
    };
    CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);
    Runnable task = new Runnable() {
      public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
        try {
          barrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has passed the barrier.");
      }
    };
    new Thread(task).start();
    new Thread(task).start();
    new Thread(task).start();
  }
}
