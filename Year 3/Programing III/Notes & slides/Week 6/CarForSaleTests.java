import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import org.joda.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarForSaleTests {

	CarForSale c;

	@BeforeEach
	void init() {
		c = new CarForSale("Honda", "Civic", new Registration(LocalDate.of(1998, 1, 4), "98-MH-532"), Money.parse("EUR 1500"), 1998);
	}

	@Test
	void testValidSerialisationOfCar() {
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream("carsforsale.ser"));
			is = new ObjectInputStream(new FileInputStream("carsforsale.ser"));
			
			os.writeObject(c);
			
			CarForSale deSCar = (CarForSale) is.readObject();
			assertEquals(c.toString(), deSCar.toString());
			assertEquals(c.getRegistration(), deSCar.getRegistration());
			
		} catch (NotSerializableException e) {
			fail("Some object isn't serializable.");
		}catch (FileNotFoundException e) {
		
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(os != null)
					os.close();
				if(is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}










	}

}
