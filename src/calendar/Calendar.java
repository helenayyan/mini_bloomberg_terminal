import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Calendar {

    //each day in the calendar is mapped to a map of user ids and their meetings
    private HashMap<LocalDate, HashMap<String, String[][]>> calendarDays = new HashMap<LocalDate, HashMap<String, String[][]>>();
    
    /**
     * Create a blank calendar for all users
     * @param userIds
     * @param date
     */
    public void createANewDay(HashSet<String> userIds, LocalDate date) {
    	//each user id is mapped to their meetings for a particular day
	     HashMap<String, String[][]> userMeetings = new HashMap<String, String[][]>();

	    //2-d array of meetings. Each element contains [time, topic/Null]
	     //"8.0" means the slot from 8:00am to 8:30am 
	     String[][] defaultMeetings = {{"8.0", ""}, {"8.5", ""}, {"9.0", ""}, {"9.5", ""}, {"10.0", ""}, {"10.5", ""}, {"11.0", ""}, {"11.5", ""}, {"12.0", ""},
	            {"12.5", ""}, {"13.0", ""}, {"13.5", ""}, {"14.0", ""}, {"14.5", ""}, {"15.0", ""}, {"15.5", ""}, {"16.0", ""}, {"16.5", ""}, {"17.0", ""}, {"17.5", ""}};
	     
	     for (String userId : userIds) {
		     userMeetings.put(userId, defaultMeetings);
	     }
	     calendarDays.put(date, userMeetings);
    }
    
    /**
     * Adds a meeting to the calendars of users given
     * @param listOfUsers
     * @param startTime
     * @param endTime
     * @param topic
     * @param calendarDay
     */
    public void addMeeting(HashSet<String> listOfUsers, double startTime, double endTime, String topic, LocalDate calendarDay) {

    	//parse times to String
    	String stringStartTime = Double.toString(startTime);
    	String stringEndTime = Double.toString(endTime);
    	
        //assume that the time is entered in the format ( 1.30pm = 13.5)
    	
        HashMap<String, String[][]> userDay = calendarDays.get(calendarDay);
        
        System.out.println("Meeting added for users: ");
        for (String j : listOfUsers) {
        	//get user's meetings
        	String[][] userMeetings = userDay.get(j);
        	
        	boolean isFound = false;
        	boolean reachedEnd = false;
        	int index = 0;
        	while ((isFound == false) || (reachedEnd == false)) {
        		if (userMeetings[index][0].equals(stringStartTime)) {
        			isFound = true;
        		}
        		if (isFound == true) {
        			userMeetings[index][1] = topic;
        		}
        		if (userMeetings[index][0].equals(stringEndTime) || (userMeetings[index][0].equals("17.5"))) {
        			reachedEnd = true;
        			break;
        		}	
        		index++;
        	}  
        	System.out.printf("%s", j);
        	System.out.println("");
        }    
    }

    /**
     * Adds a meeting for one user only
     * @param userId
     * @param startTime
     * @param endTime
     * @param topic
     * @param calendarDay
     */
    public void addMeetingOneUser(String userId, double startTime, double endTime, String topic, LocalDate calendarDay) {
	     HashSet<String> user = new HashSet<String>();
	     user.add(userId);
	     addMeeting(user, startTime, endTime, topic, calendarDay);
    }
    
    /**
     * Displays a user's calendar for the current day
     * @param userId
     */
    public void displayUsersDay(String userId) {
        LocalDate today = LocalDate.now();
        displayUsersCalendarForGivenDay(userId, today);
    }

    /**
     * Displays a user's calendar for a given day
     * @param userId
     * @param calendarDay
     */
    public void displayUsersCalendarForGivenDay(String userId, LocalDate calendarDay) {
        HashMap<String, String[][]> userDay = calendarDays.get(calendarDay);
        String[][] allMeetings = userDay.get(userId);
        

        System.out.println(String.format("Meetings scheduled for User %s on %s:", userId, calendarDay));
        // iterate through the meetings
        int i = 0;
        while (i < allMeetings.length) {
            if (allMeetings[i][1] != "") {
                String startTime = indexToTime(i); //meeting start time
                String topic = allMeetings[i][1];
                i++;
                // find the interval for meeting of this topic
                while (i < allMeetings.length) {
                    if (allMeetings[i][1] == topic) {
                        i++;
                    } else {
                        break;
                    }
                }
                String endTime = indexToTime(i);
                if (i == allMeetings.length) {
                    endTime = indexToTime(i - 1);
                }
                // meeting ending time
                System.out.println(String.format("Time: %1s - %2s, Topic: %3s;", startTime, endTime, topic));
            } else {
                i++;
            }
        }
    }

    /**
     * Suggests a meeting time for a user
     * @param organisingUser
     * @param calendarDay
     * @param earliestTime
     * @param latestTime
     * @param timeInterval
     * @return
     */
    public void meetingTimeSuggestion(String organisingUser, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
    	printAvailableMeetings(getAvailabiltiesForMeeting(organisingUser, calendarDay, earliestTime, latestTime, timeInterval));
    }

    private ArrayList<String> getAvailabiltiesForMeeting(String userId, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
        //assume that the time intervals are put in double (eg 30m = 0.5 2hr = 2)
        HashMap<String, String[][]> userDay = calendarDays.get(calendarDay);
        String[][] allMeetings = userDay.get(userId);  // all meeting information of the user on the day
        ArrayList<String> availabilities = new ArrayList<String>();  // to store the result available sessions

        int sessionRequired = (int) (timeInterval * 2);  // the number of half-hour sessions needed
        int startSession = (int) (earliestTime * 2) - 16;  // match earliestTime to index in allMeetings
        int endSession = (int) (latestTime * 2) - 16;  //match latestTime to index in allMeetings

        while (startSession < (endSession - sessionRequired + 1)) {
            // While loop used as every possible start time need to be checked as required
            int countAvailable = 0;  //count for available sessions within timeInterval
            for (int sessionToCheck = startSession; sessionToCheck < startSession + sessionRequired; sessionToCheck++) {
                // iterate through the session within the interval
                if (allMeetings[sessionToCheck][1] == "") {
                    countAvailable++;
                } else {
                    startSession = sessionToCheck + 1; // reset startSession to the session after sessionToCheck
                    break;
                }
            }
            // all sessions in the time interval is available
            if (countAvailable == sessionRequired) {
                // covert index back to a time formated string; e.g. index 0 -> "8:00"; index 1 -> "8:30".
                String startTimeString = indexToTime(startSession);
                String endTimeString = indexToTime(startSession + sessionRequired);

                // add the result into availabilities
                String availableInterval = String.format("%1s - %2s", startTimeString, endTimeString);
                availabilities.add(availableInterval);
                startSession++;
            }
        }
        return availabilities;
    }
    private void printAvailableMeetings(ArrayList<String> availabilities) {
        // print out results
        if (availabilities.isEmpty()) {
            System.out.println("Sorry, there is no available time slot in the given time frame for the meeting");
        } else {
            System.out.println("Available slots:");
            for (String i : availabilities) {
                System.out.println(i);
            }
        }
    }
    /*
     * for meetingInDays, given an index of the meeting, return a time formated string
     */
    private static String indexToTime(int sessionIndex) {
        int hour = (int) (sessionIndex / 2) + 8;
        String timeString = new String();
        if (sessionIndex % 2 == 0) {
            timeString = String.format("%d:00", hour);
        } else {
            timeString = String.format("%d:30", hour);
        }
        return timeString;
    }

    /**
     * Suggests a meeting time for all given users
     * @param listOfuserID
     * @param calendarDay
     * @param earliestTime
     * @param latestTime
     * @param timeInterval
     */
    public void meetingTimeScheduler(HashSet<String> listOfuserID, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
    	ArrayList<String> availabilities = new ArrayList<String>(); 
    	int count = 0;
    	
        for (String userId : listOfuserID) {
        	if (count == 0) {
        		availabilities = getAvailabiltiesForMeeting(userId, calendarDay, earliestTime, latestTime, timeInterval);

        	}
        	else {
        		ArrayList<String> userAvailabilties = getAvailabiltiesForMeeting(userId, calendarDay, earliestTime, latestTime, timeInterval);
        		availabilities.retainAll(userAvailabilties);
        	}        	
        	count ++;
        }
        printAvailableMeetings(availabilities);
        
        
    }
}
