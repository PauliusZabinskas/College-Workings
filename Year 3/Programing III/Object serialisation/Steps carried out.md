1. **Preparation for Serialization**
public class Main {
	public static void main (String[] args) {
		// User class must implement serializable interface
		User user = new User();
		user.name = "Bro";
		user.password = "I<3Coffe";

		FileOutputStream out = new FileOutputStream("theTime.ser");  
		ObjectOutputStream s = new ObjectOutputStream(out);  
		s.writeObject(user);  
		s.writeObject(new Date());  
		s.flush();

		// deconstruction
		FileInputStream in = new FileInputStream("theTime");  
		ObjectInputStream s = new ObjectInputStream(in);  
		String today = (String) s.readObject();  
		Date date = (Date) s.readObject();

	}
}