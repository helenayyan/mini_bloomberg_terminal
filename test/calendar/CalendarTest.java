package calendar;

import org.junit.jupiter.api.Test;
import user.User;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CalendarTest {

    @Test
    void createANewDay() {
        Calendar calendar = new Calendar();
        User user = new User();
        Map<Integer, User.UserDetails> userMap  = user.getUserMap();
        HashSet<String> userSet = new HashSet<String>(Collections.singleton(userMap.keySet().toString()));
        calendar.createANewDay(userSet, LocalDate.now());

    }

    @Test
    void addMeeting() {
    }

    @Test
    void displayUsersDay() {
    }

    @Test
    void displayUsersCalendarForGivenDay() {
    }

    @Test
    void meetingTimeSuggestion() {
    }

    @Test
    void meetingTimeScheduler() {
    }
}
