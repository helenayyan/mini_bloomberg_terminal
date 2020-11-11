package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Test for addNewUserProfile and displayUserProfile
     */
    @Test
    void UserProfileTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        // add user 1
        users.addNewUserProfile("bukky", "bukky@", "39747397474");
        users.displayUserProfile(users.userId);
        String expected1 = "User Id: " + users.userId + ", User Name: bukky, Email Address: bukky@, Phone Number: 39747397474, Joining Date: " + today + "\n";

        // add user 2
        users.addNewUserProfile("helena", "helena@", "45345343454");
        users.displayUserProfile(users.userId);
        String expected2 = "User Id: " + users.userId + ", User Name: helena, Email Address: helena@, Phone Number: 45345343454, Joining Date: " + today + "\n";


        assertEquals(users.getUserMap().size(),2);
    }

    /**
     * Test for changeUserName
     */
    @Test
    void changeUserNameTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "03974739747");
        users.changeUserName(users.userId, "BUKKY");
        users.displayUserProfile(users.userId);

        String expected = "User Id: " + users.userId + ", User Name: BUKKY, Email Address: bukky@, Phone Number: 03974739747, Joining Date: " + today + "\n";

        assertEquals(users.getUserMap().get(users.userId).getUserName(), "BUKKY");
    }

    /**
     * Test for changeUserEmailAddress
     */
    @Test
    void changeUserEmailAddressTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "03974739747");
        users.changeUserEmailAddress(users.userId, "bukky@outlook.com");
        users.displayUserProfile(users.userId);

        String expected = "User Id: 1, User Name: bukky, Email Address: bukky@outlook.com, Phone Number: 03974739747, Joining Date: " + today + "\n";

        assertEquals(users.getUserMap().get(users.userId).getUserEmail(), "bukky@outlook.com");
    }

    /**
     * Test for changeUserPhoneNumber
     */
    @Test
    void changeUserPhoneNumberTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "39747000000");
        users.changeUserPhoneNumber(users.userId, "0000000000");
        users.displayUserProfile(users.userId);

        String expected = "User Id: 1, User Name: bukky, Email Address: bukky@, Phone Number: 0000000000, Joining Date: " + today + "\n";

        assertEquals(users.getUserMap().get(users.userId).getPhoneNumber(),"0000000000");
    }
}
