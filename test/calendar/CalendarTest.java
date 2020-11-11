package calendar;

import org.junit.jupiter.api.Test;
import user.User;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalendarTest {

    @Test
    void createANewDay() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>(Collections.singleton(userMap.keySet().toString()));
        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

    }

    @Test
    void addMeeting() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>();
        userSet.add("H261333");
        userSet.add("B224923");

        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

        Calendar newDay = new Calendar();
        newDay.createANewDay(userSet, LocalDate.now());

        newDay.addMeeting(userSet, 8, 10, "test", LocalDate.now());
        newDay.addMeeting(userSet, 15, 16, "test2", LocalDate.now());
        assertEquals(newDay.getCalendarDays().get(LocalDate.now()).size(), 2);
    }

    @Test
    void displayUsersDay() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>();
        userSet.add("H261333");
        userSet.add("B224923");

        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

        Calendar newDay = new Calendar();
        newDay.createANewDay(userSet, LocalDate.now());

        newDay.addMeeting(userSet, 8, 10, "test", LocalDate.now());
        newDay.addMeeting(userSet, 15, 16, "test2", LocalDate.now());
        newDay.addMeetingOneUser("B224923", 13, 15, "test3", LocalDate.now()); //has issue

        newDay.displayUsersCalendarForGivenDay("H261333", LocalDate.now());
        newDay.displayUsersCalendarForGivenDay("B224923", LocalDate.now());

        newDay.displayUsersDay("H261333");
    }

    @Test
    void displayUsersCalendarForGivenDay() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>();
        userSet.add("H261333");
        userSet.add("B224923");

        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

        Calendar newDay = new Calendar();
        newDay.createANewDay(userSet, LocalDate.now());

        newDay.addMeeting(userSet, 8, 10, "test", LocalDate.now());
        newDay.addMeeting(userSet, 15, 16, "test2", LocalDate.now());
        newDay.addMeetingOneUser("B224923", 13, 15, "test3", LocalDate.now()); //has issue

        newDay.displayUsersCalendarForGivenDay("H261333", LocalDate.now());


    }

    @Test
    void meetingTimeSuggestion() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>();
        userSet.add("H261333");
        userSet.add("B224923");

        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

        Calendar newDay = new Calendar();
        newDay.createANewDay(userSet, LocalDate.now());

        newDay.addMeeting(userSet, 8, 10, "test", LocalDate.now());
        newDay.addMeeting(userSet, 15, 16, "test2", LocalDate.now());
        newDay.addMeetingOneUser("B224923", 13, 15, "test3", LocalDate.now()); //has issue

        newDay.displayUsersCalendarForGivenDay("H261333", LocalDate.now());
        newDay.displayUsersCalendarForGivenDay("B224923", LocalDate.now());

        newDay.meetingTimeSuggestion("B224923", LocalDate.now(), 12, 18, 1);

    }

    @Test
    void meetingTimeScheduler() {
        Calendar calendar = new Calendar();
        User user = new User();
        HashMap<String, User.UserDetails> userMap = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>();
        userSet.add("H261333");
        userSet.add("B224923");

        calendar.createANewDay(userSet, LocalDate.now());
        assertEquals(calendar.getCalendarDays().size(), 1);

        Calendar newDay = new Calendar();
        newDay.createANewDay(userSet, LocalDate.now());

        newDay.addMeeting(userSet, 8, 10, "test", LocalDate.now());
        newDay.addMeeting(userSet, 15, 16, "test2", LocalDate.now());
        newDay.addMeetingOneUser("B224923", 13, 15, "test3", LocalDate.now()); //has issue

        newDay.meetingTimeScheduler(userSet, LocalDate.now(), 12, 14, 0.5);

    }
}
