
public class Words {
	public static void wordAndLetterCounter(String ... words) {
		int letterCounter = 0;
		for(String w: words) {
			letterCounter += w.length();
		}
		System.out.printf("You entered %d words with a "
				+ "total number of %d letters.", 
				words.length, letterCounter);
	}
	
	public static void main(String [] args) {
		Words.wordAndLetterCounter("Hello", "my", "name", "is", "Luke", ".");
	}
}
