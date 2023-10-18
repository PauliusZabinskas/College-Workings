package nestedclasses;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArraySequencesTests {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	

	@Test
	void testPrintEven() {
		System.setOut(new PrintStream(outContent));
		new ArraySequences(10).printEven();
		assertEquals("0 2 4 6 8 ", outContent.toString());
		System.setOut(originalOut);
	}

}
