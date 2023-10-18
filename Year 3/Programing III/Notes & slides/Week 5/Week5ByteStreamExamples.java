import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Week5ByteStreamExamples {

	public static void main (String [] args) {
		
		InputStream in = null;
		OutputStream out = null;
		int c;
		
		try {
			in = new FileInputStream("myFile.txt");
			out = new FileOutputStream("myFilex.txt");
			while((c = in.read()) != -1) {
				System.out.printf("%d -- %s%n", c, (char) c);
				out.write(c);
			}
			System.out.println(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(in != null)
						in.close();
					if(out != null)
						out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
