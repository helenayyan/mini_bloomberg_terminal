import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Calendar {
	private LocalDate date;
	
    // calendarMap <key=calendarDay, value = < key=userID, value = Arrary [[8,None],[8.5,'Topic'],[9,...]] > >
	
	//each day in the calendar is mapped to a map of user ids and their meetings
	private HashMap<LocalDate, HashMap<Integer, String[][]>> calendarDays = new HashMap<LocalDate, HashMap<Integer, String[][]>>();
	
	//each user id is mapped to their meetings for a particular day
	private HashMap<Integer, String[][]> userMeetings = new HashMap<Integer, String[][]>();
	
	//2-d array of meetings. Each element contains [time, topic/Null]
	private String[][] meetingsInDay = {{"8",""},{"8.5",""},{"9",""},{"9.5",""},{"10",""},{"10.5",""},{"11",""},{"11.5",""},{"12",""},
			{"12.5",""},{"13",""},{"13.5",""},{"14",""},{"14.5",""},{"15",""},{"15.5",""},{"16",""},{"16.5",""},{"17",""},{"17.5",""}};


	/*
	 * gonna complete later
	 */
    public void addMeeting(HashSet<Integer> listOfUsers, double startTime, double endTime, String topic, LocalDate calendarDay) {
    	//assume that the time is entered in the format ( 1.30pm = 13.5)
    	HashMap<Integer, String[][]> userDay = calendarDays.get(calendarDay);
    	
    	//note: bad complexity here (order n^2) because of nested loop - should consider a better way
    	for (Integer i : listOfUsers) {
    		String[][] userMeetings = userDay.get(i);
    		
    		//assume that the start and end times are free already 
    		
    		boolean isFound = false;
    		int counter = 0;
    		
    		while (isFound == false){
    			
    		}
    	}
    }

    /*
     * completed
     */
    public void displayUsersDay(int userId) {
    	LocalDate today = LocalDate.now();
    	displayUsersCalendarForGivenDay(userId, today);      
    }

    public void displayUsersCalendarForGivenDay(int userId, LocalDate calendarDay) {

    }

    public void meetingTimeSuggestion(int organisingUser, LocalDate calendarDay, int earliestTime, int latestTime, double timeInterval) {
    	//assume that the time intervals are put in double (eg 30m = 0.5 2hr = 2)
    }
}

