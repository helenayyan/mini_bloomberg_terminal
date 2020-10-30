import java.time.LocalDate;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// User test
		User users = new User();
		users.addNewUserProfile("bukky", "bukky@", "39747");
		users.displayUserProfile(1);

		users.addNewUserProfile("helena", "helena@", "45345343");
		users.displayUserProfile(2);


	     HashSet<Integer> listOfUsers = new HashSet<Integer>();
	     listOfUsers.add(1);
	     listOfUsers.add(2);
	     
		 Calendar newDay = new Calendar();
		 newDay.createANewDay(listOfUsers);
			
	     newDay.addMeeting(listOfUsers, 8, 6, "test", LocalDate.now());

	}

}
