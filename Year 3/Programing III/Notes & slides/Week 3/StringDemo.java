package strings;

public class StringDemo {

	public static boolean validateEmail(String aValidEmail) {
		String [] theParts = aValidEmail.split("@");
		if(theParts.length != 2 || theParts[0].length() == 0)
			return false;
		String secondPart = theParts[1];
		String [] theDotParts = secondPart.split("\\.");
		if(theDotParts.length != 2 || theDotParts[0].length() == 0)
			return false;
		
		return true;
	}

}
