import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Week5CharacterStreamExamples {

	public static void main(String[] args) {
//		Reader in = null;
//		Writer out = null;
		
//		BufferedReader in = null;
//		BufferedWriter out = null;
		PrintWriter out = null;
		LineNumberReader in = null;
		int c;
		
		try {
//			in = new FileReader("myFile.txt");
//			out = new FileWriter("myFileW.txt");
//			while((c = in.read()) != -1) {
//				System.out.printf("%d -- %s%n", c, (char) c);
//				out.write(c);
//			}
//			in = new BufferedReader(new FileReader("myFile.txt"));
			in = new LineNumberReader(new FileReader("myFile.txt"));
//			out = new BufferedWriter(new FileWriter("myBufferedFile.txt"));
			out = new PrintWriter("myPWFile.txt");
			
			String line;
			
			while((line = in.readLine()) != null) {
				System.out.println(line);
				out.format("%d %s%n", in.getLineNumber(), line);
			}
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
