package strings;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringDemoTest {

	@Test
	void testAValidEmail() {
		String aValidEmail = "adrian.clear@universityofgalway.ie";
		boolean result = StringDemo.validateEmail(aValidEmail);
		assertTrue(result);
	}
	
	@Test
	void testInvalidEmail_noAtSign() {
		String anInvalidEmail = "adrian.clearuniversityofgalway.ie";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	
	@Test
	void testInvalidEmail_noPrefix() {
		String anInvalidEmail = "@universityofgalway.ie";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	@Test
	void testInvalidEmail_noSuffix() {
		String anInvalidEmail = "adrian.clear@";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	@Test
	void testInvalidEmail_suffixWithoutPeriod() {
		String anInvalidEmail = "adrian.clear@universityofgalwayie";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	@Test
	void testInvalidEmail_suffixBeginWithPeriod() {
		String anInvalidEmail = "adrian.clear@.universityofgalwayie";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	@Test
	void testInvalidEmail_suffixEndWithPeriod() {
		String anInvalidEmail = "adrian.clear@universityofgalwayie.";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	
	@Test
	void testInvalidEmail_blank() {
		String anInvalidEmail = "";
		boolean result = StringDemo.validateEmail(anInvalidEmail);
		assertFalse(result);
	}
	
	

}
