import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntBufferReentrant implements IntBuffer {
  private int contents;
  private boolean available = false;
  private Lock lock;
  private Condition isEmpty;
  private Condition isFull;

  public IntBufferReentrant() {
    lock = new ReentrantLock();
    isEmpty = lock.newCondition();
    isFull = lock.newCondition();
  }

  public int get() {
    try {
      lock.lock();
      while (available == false) {
        // wait for Producer to put value
        isFull.await();
      }
      available = false;
      // Notify Producer(s) that there is space available
      isEmpty.signalAll();
    }
    catch (InterruptedException e)
    {
    }
    finally {
      lock.unlock();
    }
    return contents;
  }

  public void put(int value) {
    try {
      lock.lock();
      while (available == true) {
        // wait for Consumer to get value
        isEmpty.await();
      }
      contents = value;
      available = true;
      // Notify Consumer(s) that there is a value available
      isFull.signalAll();
    }
    catch (InterruptedException e)
    {
    }
    finally {
      lock.unlock();
    }
  }
}
