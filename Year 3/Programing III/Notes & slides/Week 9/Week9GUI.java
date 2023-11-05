import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Week9GUI extends JFrame {
	
	private JComboBox box;
	private String [] options = {"One", "Two", "Three"};
	private int prevSelect = 0;
	
	public Week9GUI() {
		//instantiate the combo box
		box = new JComboBox(options);
		
		//add a listener
		box.addItemListener( e -> {
			System.out.println("Event triggered");
			switch(e.getStateChange()) {
			case ItemEvent.DESELECTED:
				System.out.println("Deselect Event triggered " + options[prevSelect]);
				break;
			case ItemEvent.SELECTED:
				System.out.println(" Select Event triggered " + options[box.getSelectedIndex()]);
				
			}
			prevSelect = box.getSelectedIndex();
		});
		
		//add it to the JFrame
		add(box);
		
		
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Week9GUI();

	}

}
