import java.time.LocalDate;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// User test
		User users = new User();
		users.addNewUserProfile("bukky", "bukky@", "07539038223");
		users.displayUserProfile("B224923");

		users.addNewUserProfile("helena", "helena@", "03453453433");
		users.displayUserProfile("H261333");


	     HashSet<String> listOfUsers = new HashSet<String>();
	     listOfUsers.add("H261333");
	     listOfUsers.add("B224923");
	     
		 Calendar newDay = new Calendar();
		 newDay.createANewDay(listOfUsers, LocalDate.now());
			
	     newDay.addMeeting(listOfUsers, 8, 10, "test", LocalDate.now());
	     newDay.addMeeting(listOfUsers, 15, 16, "test2", LocalDate.now());
		 newDay.addMeetingOneUser("B224923", 13, 15, "test3", LocalDate.now()); //has issue
	     
		 newDay.displayUsersCalendarForGivenDay("H261333", LocalDate.now());
		 newDay.displayUsersCalendarForGivenDay("B224923", LocalDate.now());
	     
	     newDay.meetingTimeSuggestion("B224923", LocalDate.now(), 12, 18 , 1);

	     newDay.meetingTimeScheduler(listOfUsers, LocalDate.now(), 12, 14, 0.5);
	}

}
