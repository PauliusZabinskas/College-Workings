
public class TestProducerConsumer {

  public static void main(String args[]) {
    // Create the shared buffer to store int values
    IntBuffer buffer = new IntBufferDemo();

    // Create and start some Producer and Consumer threads
    for (int i = 1; i <= 5; i++) {
      Producer p = new Producer(buffer, i);
      Consumer c = new Consumer(buffer, i);
      p.start();
      c.start();
    }

    System.out.println("Wating for Producers and Comsumers to finish...");
  }
}
