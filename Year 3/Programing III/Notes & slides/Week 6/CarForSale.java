import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

import org.joda.money.Money;

public class CarForSale implements Serializable {
	
	private String make;
	private String model;
	private transient Registration registration;
	private Money price;
	private int year;

	public CarForSale(String make, String model, Registration registration, Money price, int year) {
		this.make = make;
		this.model = model;
		this.registration = registration;
		this.price = price;
		this.year = year;
	}
	
	public String getMake() {
		return make; 
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return make + " " + model;
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		
		os.writeObject(registration.getRegDate());
		os.writeObject(registration.getRegPlate());
	}
	
	private void readObject(ObjectInputStream is) throws IOException {
		try {
			is.defaultReadObject();
			
			LocalDate regDate = (LocalDate) is.readObject();
			String reg = (String) is.readObject();
			
			this.setRegistration(new Registration(regDate, reg));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
