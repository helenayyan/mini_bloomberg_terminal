import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Calendar {
    private LocalDate date;
    
    //each day in the calendar is mapped to a map of user ids and their meetings
    private HashMap<LocalDate, HashMap<Integer, String[][]>> calendarDays = new HashMap<LocalDate, HashMap<Integer, String[][]>>();
    String[][] defaultMeetings = {{"8", ""}, {"8.5", ""}, {"9", ""}, {"9.5", ""}, {"10", ""}, {"10.5", ""}, {"11", ""}, {"11.5", ""}, {"12", ""},
            {"12.5", ""}, {"13", ""}, {"13.5", ""}, {"14", ""}, {"14.5", ""}, {"15", ""}, {"15.5", ""}, {"16", ""}, {"16.5", ""}, {"17", ""}, {"17.5", ""}};
    
    public void createANewDay(HashSet<Integer> userIds) {
    	//each user id is mapped to their meetings for a particular day
	     HashMap<Integer, String[][]> userMeetings = new HashMap<Integer, String[][]>();

	    //2-d array of meetings. Each element contains [time, topic/Null]
	     String[][] defaultMeetings = {{"8.0", ""}, {"8.5", ""}, {"9.0", ""}, {"9.5", ""}, {"10.0", ""}, {"10.5", ""}, {"11.0", ""}, {"11.5", ""}, {"12.0", ""},
	            {"12.5", ""}, {"13.0", ""}, {"13.5", ""}, {"14.0", ""}, {"14.5", ""}, {"15.0", ""}, {"15.5", ""}, {"16.0", ""}, {"16.5", ""}, {"17.0", ""}, {"17.5", ""}};
	     
	     for (int userId : userIds) {
		     userMeetings.put(userId, defaultMeetings);
	     }
	     //Using current date as calendar day. Can be changed to any date
	     calendarDays.put(LocalDate.now(), userMeetings);
    }
    /*
     * completed and tested
     */
    public void addMeeting(HashSet<Integer> listOfUsers, double startTime, double endTime, String topic, LocalDate calendarDay) {

    	//parse times to String
    	String stringStartTime = Double.toString(startTime);
    	String stringEndTime = Double.toString(endTime);
        //assume that the time is entered in the format ( 1.30pm = 13.5)
    	
        HashMap<Integer, String[][]> userDay = calendarDays.get(calendarDay);
        
        for (Integer j : listOfUsers) {
        	String[][] userMeetings = userDay.get(j);
        	
        	boolean isFound = false;
        	boolean reachedEnd = false;
        	int index = 0;
        	while ((isFound == false) ||  (reachedEnd == false)) {

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
        }
    }

    /*
     * completed
     */
    public void displayUsersDay(int userId) {
        LocalDate today = LocalDate.now();
        displayUsersCalendarForGivenDay(userId, today);
    }

    /*
     * completed and tested
     */
    public void displayUsersCalendarForGivenDay(int userId, LocalDate calendarDay) {
        HashMap<Integer, String[][]> userDay = calendarDays.get(calendarDay);
        String[][] allMeetings = userDay.get(userId);

        System.out.println(String.format("Meetings scheduled for User %d on %s:", userId, calendarDay));
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


    /*
     * completed and tested
     */
    public HashSet<String> meetingTimeSuggestion(int organisingUser, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
        //assume that the time intervals are put in double (eg 30m = 0.5 2hr = 2)
        HashMap<Integer, String[][]> userDay = calendarDays.get(calendarDay);
        String[][] allMeetings = userDay.get(organisingUser);  // all meeting information of the user on the day
        HashSet<String> availabilities = new HashSet<String>();  // to store the result available sessions

        int sessionRequired = (int) (timeInterval * 2);  // the number of half-hour sessions needed
        int startSession = (int) (earliestTime * 2) - 16;  // match earliestTime to index in allMeetings
        int endSession = (int) (latestTime * 2) - 16;  //match latestTime to index in allMeetings

        while (startSession < (endSession - sessionRequired + 1)) {
            // While loop used as every possible start time need to be checked as required
            int countAvailable = 0;  //count for availabe sessions within timeInterval
            for (int sessionToCheck = startSession; sessionToCheck < startSession + sessionRequired; sessionToCheck++) {
                // iterate through the session within the interval
                if (allMeetings[sessionToCheck][1] == "") {
                    countAvailable++;
                } else {
                    startSession = sessionToCheck + 1; // reset startSession to the session after sessionToCheck
                    break;
                }
            }
            // all sessions in the timeinterval is availabel
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

        // print out results
        if (availabilities.isEmpty()) {
            System.out.println("Sorry, there is no available time slot in the given time frame for the meeting");
        } else {
            System.out.println("Available slots:");
            for (String i : availabilities) {
                System.out.println(i);
            }
        }
        
        return availabilities;
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

    /*
     * in progress
     */
    public void meetingTimeScheduler(HashSet<Integer> listOfuserID, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
    	HashSet<String> availabilities = new HashSet<String>(); 
    	int count = 0;
    	
        for (int userId : listOfuserID) {
        	if (count == 0) {
        		availabilities = meetingTimeSuggestion(userId, calendarDay, earliestTime, latestTime, timeInterval);

        	}
        	else {
        		HashSet<String> userAvailabilties = meetingTimeSuggestion(userId, calendarDay, earliestTime, latestTime, timeInterval);
        		availabilities.retainAll(userAvailabilties);
        	}
        	
        	count ++;
        }
    }
}
