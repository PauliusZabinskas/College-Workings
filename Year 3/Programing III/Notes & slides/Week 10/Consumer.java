public class Consumer extends Thread {
  private IntBuffer cubbyhole;
  private int number;

  public Consumer(IntBuffer c, int number) {
    cubbyhole = c;
    this.number = number;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 10; i++) {
    	System.out.println("Consumer #" + this.number + " trying to get a value");
      value = cubbyhole.get();
      System.out.println("Consumer #" + this.number + " got: " + value);
    }
  }
}
