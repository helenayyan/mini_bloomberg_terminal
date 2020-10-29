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
    private String[][] meetingsInDay = {{"8", ""}, {"8.5", ""}, {"9", ""}, {"9.5", ""}, {"10", ""}, {"10.5", ""}, {"11", ""}, {"11.5", ""}, {"12", ""},
            {"12.5", ""}, {"13", ""}, {"13.5", ""}, {"14", ""}, {"14.5", ""}, {"15", ""}, {"15.5", ""}, {"16", ""}, {"16.5", ""}, {"17", ""}, {"17.5", ""}};


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

            while (isFound == false) {

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

    /*
     * completed and tested
     *
     */
    public void meetingTimeSuggestion(int organisingUser, LocalDate calendarDay, double earliestTime, double latestTime, double timeInterval) {
        //assume that the time intervals are put in double (eg 30m = 0.5 2hr = 2)
        HashMap<Integer, String[][]> userDay = calendarDays.get(calendarDay);
        String[][] allMeetings = userDay.get(organisingUser);  // all meeting information of the user on the day
        List<String> availabilities = new ArrayList<>();  // to store the result available sessions

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

    public void meetingTimeScheduler(HashSet<Integer> listOfuserID, LocalDate calendarDay, int earliestTime, int latestTime, double timeInterval) {

    }
}

