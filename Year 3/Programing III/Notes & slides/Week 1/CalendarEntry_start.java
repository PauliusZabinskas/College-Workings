import java.time.LocalDateTime;
/**
 * A code-along example to illustrate constructor overloading
 * 
 * @author adrianclear
 *
 */
public class CalendarEntry_start {
	
	private String title;
	private String description;
	private String location;
	private LocalDateTime start_time;
	private int duration; //in minutes
	
	//create a default constructor where the title is "(No subject)", the duration is 30, 
	// and the start time is the current time
	
	
	//create an overloaded constructor that takes a value for the start time as a parameter
	
	
	//create an overloaded constructor that takes a value for each of the attributes as parameters
	
	
	
	@Override
	public String toString() {
		return "Date-time: " + start_time.toString() + "\n" +
				"Title: " + title + "\n" +
				"Location: " + location + "\n" +
				"Description: " + description + "\n" +
				"Duration: " + duration + " minutes\n";
	}
	
	public static void main(String [] args) {
		System.out.println(new CalendarEntry_start());
		
		new CalendarEntry_start(LocalDateTime.of(2023, 12, 8, 1, 00);
		
		System.out.println(new CalendarEntry_start(LocalDateTime.of(2023, 9, 8, 15, 00), "Meeting", "Discuss project progress", "IT408", 60));
	}
}
