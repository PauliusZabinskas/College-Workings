import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week5StructuredDataIODemo {

	public static void main(String[] args) {
		List<County> counties = new ArrayList<County>();
		
		BufferedReader in = null;
		String line;
		try {
			in = new BufferedReader(new FileReader("counties.txt"));
			while((line = in.readLine()) != null) {
				if(line.startsWith("L")) {
					Scanner lineScanner = new Scanner(new StringReader(line));
					counties.add(new County(lineScanner.next(), lineScanner.nextInt(),lineScanner.nextInt(),lineScanner.nextInt()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		counties.forEach(c -> {
			System.out.println(c);
		});
		DataOutputStream dout = null;
		DataInputStream din = null;
		boolean eof = false;
		
		try {
			dout = new DataOutputStream(new FileOutputStream("countyDensity"));
			din = new DataInputStream(new FileInputStream("countyDensity"));
			for(County c: counties) {
				dout.writeUTF(c.getName());
				dout.writeInt(c.getDensity());
			}
			
			while(eof == false) {
				System.out.printf("%s %d%n", din.readUTF(), din.readInt());
			}
		}catch (EOFException e) {
			eof = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dout != null)
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}

}
