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
	     
	     //test for FX
	     FX fcn = new FX(null, null, 0, null);
	     fcn.addForeignExchangeValue("euro", "lei", 4.5, 1234);
	     fcn.addForeignExchangeValue("euro", "pound", 3.5, 123);
	     fcn.addForeignExchangeValue("pound", "lei", 1.5, 1400);
	     fcn.addForeignExchangeValue("euro", "lei", 4.7, 2500);
	     fcn.addForeignExchangeValue("euro", "leva", 8.5, 10);
	     fcn.addForeignExchangeValue("leva", "pound", 9.5, 4000);
	     fcn.addForeignExchangeValue("krikri", "lei", 6.4, 150);
	     fcn.addForeignExchangeValue("euro", "krikri", 3.5, 3456);
	     fcn.addForeignExchangeValue("krikri", "pound", 2.5, 1112);
	     fcn.addForeignExchangeValue("krikri", "leva", 7.4, 768);
	     fcn.addForeignExchangeValue("franc", "lei", 0.5, 908);
	     fcn.addForeignExchangeValue("euro", "lei", 1.2, 1100);
	     fcn.addForeignExchangeValue("franc", "leva", 2.3, 1400);

	     fcn.displayTop10RecentPrices();
	     fcn.displayTopMostRecentPricesForCurrencyPair("euro", "lei", 2);
	}

}
