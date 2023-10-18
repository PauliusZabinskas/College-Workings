package lambdafunctions;

// Fig. 10.20: TokenTest.java
// Testing the StringTokenizer class of the java.util package

// Java core packages
import java.util.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class TokenTest extends JFrame {
	private JLabel promptLabel;
	private JTextField inputField;
	private JTextArea outputArea;

	// set up GUI and event handling
	public TokenTest()
	{
		super( "Testing Class StringTokenizer" );

		Container container = getContentPane();
		container.setLayout( new FlowLayout() );

		promptLabel = new JLabel( "Enter a sentence and press Enter" );
		container.add( promptLabel );

		inputField = new JTextField( 20 );
		
		inputField.addActionListener(event -> {
			String stringToTokenize = 
					event.getActionCommand();
			StringTokenizer tokens =
					new StringTokenizer( stringToTokenize );

			outputArea.setText( "Number of elements: " +
					tokens.countTokens() + "\nThe tokens are:\n" );

			while ( tokens.hasMoreTokens() )
				outputArea.append( tokens.nextToken() + "\n" );
		});

		inputField.addActionListener(

				// anonymous inner class
				new ActionListener() {
					// handle text field event
					public void actionPerformed( ActionEvent event )
					{      
						String stringToTokenize = 
								event.getActionCommand();
						StringTokenizer tokens =
								new StringTokenizer( stringToTokenize );

						outputArea.setText( "Number of elements: " +
								tokens.countTokens() + "\nThe tokens are:\n" );

						while ( tokens.hasMoreTokens() )
							outputArea.append( tokens.nextToken() + "\n" );
					}

				}  // end anonymous inner class

				); // end call to addActionListener

		container.add( inputField );

		outputArea = new JTextArea( 10, 20 );
		outputArea.setEditable( false );
		container.add( new JScrollPane( outputArea ) );

		setSize( 275, 260 );  // set the window size
		setVisible(true);     // show the window
	}

	// execute application
	public static void main( String args[] )
	{
		TokenTest application = new TokenTest();

		application.addWindowListener(

				// anonymous inner class
				new WindowAdapter() {

					// handle event when user closes window
					public void windowClosing( WindowEvent windowEvent )
					{
						System.exit( 0 );
					}

				}  // end anonymous inner class

				); // end call to addWindowListener

	}  // end method main

}  // end class TokenTest



