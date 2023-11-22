public class Producer extends Thread {
  private IntBuffer cubbyhole;
  private int number;

  public Producer(IntBuffer c, int number) {
    cubbyhole = c;
    this.number = number;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      int value = (number * 1000) + i;
      System.out.println("Producer #" + this.number + " putting value: " + value);
      cubbyhole.put(value);
      System.out.println("Producer #" + this.number + " put: " + value);
      try {
        sleep((int)(Math.random() * 1000));
      } catch (InterruptedException e) { 
    	  
      }
    }
  }
}
