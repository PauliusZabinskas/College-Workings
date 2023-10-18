package javadocexample;
/**
 * This is a Javadoc comment for a class. It should describe the main responsibilities
 * of the class.
 * @author Adrian Clear
 * @version 1.0
 */
public class JavaDocExamples {
	private String name;
	private int size;
	
	/*
	 * This is a simple multi-line comment.
	 * It is not a Javadoc comment. 
	 * Notice the single asterisk on the first line.
	 * A Javadoc comment has double asterisk on the first line.
	 */
	
	
	/**
	 * This is a javadoc comment for a simple method that doesn't take any parameters
	 * and doesn't return anything. A javadoc comment for a method should describe the 
	 * method and what it is for.
	 */
	public void simpleMethod() {
		
	}
	
	/**
	 * Methods that return something should include the @return tag and a description
	 * of what is returned. For example,
	 * @return a String representation of the JavaDocExamples object
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Methods that have parameters should include the @param tag and describe the parameters 
	 * as follows
	 * @param aName the new name for the JavaDocExamples object. 
	 */
	public void setName(String aName) {
		this.name = aName;
	}
	
	/**
	 * 
	 * @param aSize
	 * @param aName
	 * @return
	 */
	public static String createStringFromNameAndSize(int aSize, String aName) {
		return aName + ":" + aSize;
	}	
	
	/**
	 * 
	 * @throws Exception 
	 */
	public String throwsException() throws Exception {
		return null;
	}
}
