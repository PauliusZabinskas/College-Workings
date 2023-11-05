import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileGUI extends JFrame {

	/*
	 * Instance variables for the default short
	 * version of the form.
	 */
	private JPanel shortProfileDetails;
	private JPanel buttonPanel;
	private JButton show;
	private JButton submit;
	private JLabel username;
	private JTextField usernameEntry;
	private JLabel email;
	private JTextField emailEntry;

	/*
	 * Instance variables for the extended form.
	 */
	private JPanel longProfileDetails;
	private JLabel address1;
	private JTextField address1Entry;
	private JLabel address2;
	private JTextField address2Entry;
	private JLabel city;
	private JComboBox cityEntry;
	private String [] cities = {"Dublin", "Belfast", "Galway"};

	private boolean showMore = false;

	public ProfileGUI() {
		setLayout(new GridLayout(2,1));	//change from the default border layout

		/*
		 * Instantiate components for the short form
		 */
		shortProfileDetails = new JPanel(new GridLayout(2,2,5,5));

		username = new JLabel("Username:");
		usernameEntry = new JTextField();

		email = new JLabel("Email:");
		emailEntry = new JTextField();

		/*
		 * Add components to the JPanel - be careful of order
		 */
		shortProfileDetails.add(username);
		shortProfileDetails.add(usernameEntry);
		shortProfileDetails.add(email);
		shortProfileDetails.add(emailEntry);

		/*
		 * Instantiate components for the button panel and add to panel
		 */
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		submit = new JButton("Submit");
		show = new JButton("Show more >");
		buttonPanel.add(show);
		buttonPanel.add(submit);

		/*
		 * Add panels to JFrame for the short form
		 */
		add(shortProfileDetails);
		add(buttonPanel);


		/*
		 * Instantiate components for the long form and add them to panel
		 * Don't add them to JFrame yet.
		 */
		longProfileDetails = new JPanel(new GridLayout(3,2,5,5));
		address1 = new JLabel("Address line 1:");
		address1Entry = new JTextField();
		address2 = new JLabel("Address line 2:");
		address2Entry = new JTextField();
		city = new JLabel("City: ");
		cityEntry = new JComboBox<String>(cities);
		longProfileDetails.add(address1);
		longProfileDetails.add(address1Entry);
		longProfileDetails.add(address2);
		longProfileDetails.add(address2Entry);
		longProfileDetails.add(city);
		longProfileDetails.add(cityEntry);

		/*
		 * Add a handler for the "show more" button
		 */
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!showMore) {
					//set the layout of the container
					setLayout(new GridLayout(3,1));

					//set the size of the container (600, 230)
					setSize(600,230);

					//change the button text
					show.setText("< Show less");

					//remove the button panel
					remove(buttonPanel);

					//add the long profile details panel
					add(longProfileDetails);

					//add the button panel back in
					add(buttonPanel);
					showMore = true;
				} else {
					setLayout(new GridLayout(2,1));
					setSize(600,120);
					show.setText("Show more >");
					remove(longProfileDetails);
					
				}
			}
		});



		/*
		 * Set up the JFrame
		 */
		setSize(600,120);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

	public static void main(String[] args) {
		new ProfileGUI();

	}

}
