import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;


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
        users.addNewUserProfile("bukky", "bukky@", "39747");
        users.displayUserProfile("1");
        String expected1 = "User Id: 1, User Name: bukky, Email Address: bukky@, Phone Number: 39747, Joining Date: " + today + "\n";

        // add user 2
        users.addNewUserProfile("helena", "helena@", "45345343");
        users.displayUserProfile("2");
        String expected2 = "User Id: 2, User Name: helena, Email Address: helena@, Phone Number: 45345343, Joining Date: " + today + "\n";

        // user 3 does not exist
        users.displayUserProfile("3");
        String errorMessage = "User 3 not found.\n";

        Assert.assertEquals(expected1 + expected2 + errorMessage, outContent.toString(StandardCharsets.UTF_8));
    }

    /**
     * Test for changeUserName
     */
    @Test
    void changeUserNameTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "39747");
        users.changeUserName("1", "BUKKY");
        users.displayUserProfile("1");

        String expected = "User Id: 1, User Name: BUKKY, Email Address: bukky@, Phone Number: 39747, Joining Date: " + today + "\n";

        Assert.assertEquals(expected, outContent.toString(StandardCharsets.UTF_8));
    }

    /**
     * Test for changeUserEmailAddress
     */
    @Test
    void changeUserEmailAddressTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "39747");
        users.changeUserEmailAddress("1", "bukky@outlook.com");
        users.displayUserProfile("1");

        String expected = "User Id: 1, User Name: bukky, Email Address: bukky@outlook.com, Phone Number: 39747, Joining Date: " + today + "\n";

        Assert.assertEquals(expected, outContent.toString(StandardCharsets.UTF_8));
    }

    /**
     * Test for changeUserPhoneNumber
     */
    @Test
    void changeUserPhoneNumberTest() {
        User users = new User();
        LocalDate today = LocalDate.now();

        users.addNewUserProfile("bukky", "bukky@", "39747");
        users.changeUserPhoneNumber("1", "0000000");
        users.displayUserProfile("1");

        String expected = "User Id: 1, User Name: bukky, Email Address: bukky@, Phone Number: 0000000, Joining Date: " + today + "\n";

        Assert.assertEquals(expected, outContent.toString(StandardCharsets.UTF_8));
    }
}
