package randomaccessfiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;

public class RandomAccessFileExample {

  static final String FILEPATH = "random-access-file.txt";

  public static void main(String[] args) {

    try {

      // Open the file for read / write access
      RandomAccessFile raf = new RandomAccessFile(FILEPATH, "rw");
      
      // Write out some basic data values first
      raf.writeShort(2020);  // Two bytes
      raf.writeInt(150123); // Four bytes
      raf.writeLong(433599873L); // Eight bytes
      raf.writeFloat(3.14F);  // Four bytes      
      
      // Get location of file pointer so we know where the first string begins
      long firstStringLocation = raf.getFilePointer();
      System.out.println("String objects start at file pointer location: " + firstStringLocation);
            
      // Write out a String using the writeUTF method
      raf.writeUTF("This hobbit was a very well-to-do hobbit, and his name was Baggins");
      
      // Write out another String as a byte[]
      String text = "The Bagginses had lived in the neighbourhood of The Hill for time out of mind";
      raf.write(text.getBytes());
      
      // Write out a timestamp as a String at the end
      raf.writeUTF(LocalDateTime.now().toString());
      
      // Read some data back in again in starting with the two Strings
      raf.seek(firstStringLocation);
      String first = raf.readUTF();
      System.out.println(first);
      
      byte[] bytes = new byte[text.length()];
      raf.read(bytes);
      System.out.println(new String(bytes));
      
      System.out.println(raf.readUTF());
      
      // Now read in the data values at the start oif the filename
      raf.seek(0);
      short s = raf.readShort();
      int i = raf.readInt();
      long l = raf.readLong();
      float f = raf.readFloat();
      System.out.println("s = " + s + " i = " + i + " l = " + l + " f = " + f);
      System.out.println("File pointer location: " + raf.getFilePointer());
      
      // Close the file
      raf.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
