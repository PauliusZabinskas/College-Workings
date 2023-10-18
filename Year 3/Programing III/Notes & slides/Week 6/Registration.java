import java.time.LocalDate;

public class Registration {
	
	private LocalDate regDate;
	private String regPlate;

	public Registration(LocalDate regDate, String regPlate) {
		this.regDate = regDate;
		this.regPlate = regPlate;
	}
	
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getRegPlate() {
		return regPlate;
	}

	public void setRegPlate(String regPlate) {
		this.regPlate = regPlate;
	}
	
	public boolean equals(Object r) {
		if(this.regPlate.equals(((Registration)r).getRegPlate()))
			return true;
		return false;
	}
	

}
