public class IntBufferDemo implements IntBuffer {
	private int contents = -1;
	private boolean available = false;

	public synchronized int get() {
		while(!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		available = false;
		System.out.printf("Value %d consumed%n", contents);
		return contents;

	}

	public synchronized void put(int value) {

		while(available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		contents = value;
		System.out.printf("Value %d produced%n", contents);
		available = true;
		notifyAll();
	}

}
