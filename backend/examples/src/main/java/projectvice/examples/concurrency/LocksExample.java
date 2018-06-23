package projectvice.examples.concurrency;

import java.util.concurrent.locks.StampedLock;

public class LocksExample {
  static class Counter {
    int counter = 0;
  }
  public static void main(String[] args) {
    Counter c = new Counter();
    StampedLock lock = new StampedLock();
    Runnable reader = new Runnable() {
      @Override
      public void run() {
        long stamp = lock.tryOptimisticRead();
        System.out.printf("Reader %s started%n", Thread.currentThread().getName());
        int value = c.counter;
        if (!lock.validate(stamp)) {
          System.out.println("check failed...");
          try {
            stamp = lock.readLock();
            value = c.counter;
          } finally {
            lock.unlock(stamp);
          }
        }
        System.out.printf("Reader %s consumed %d.%n", Thread.currentThread().getName(), value);
      }
    };
    Runnable writter = new Runnable() {
      @Override
      public void run() {
        long stamp = 0;
        try {
          stamp = lock.writeLock();
          System.out.printf("Writter %s started%n", Thread.currentThread().getName());
          Thread.sleep(2000);
          c.counter++;
          System.out.printf("Writter %s wroted %d%n", Thread.currentThread().getName(), c.counter);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } finally {
          lock.unlock(stamp);
        }
        
      }
    };
    
    new Thread(reader).start();
    new Thread(writter).start();
  }
}
