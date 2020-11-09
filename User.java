import java.time.LocalDate;
import java.util.HashMap;

public class User {

    private String userId;

    private static class UserDetails {
        private String userName;
        private String userEmail;
        private String phoneNumber;
        private LocalDate joiningDate;

        public UserDetails(String userName, String userEmail, String phoneNumber, LocalDate joiningDate) {
            this.userName = userName;
            this.userEmail = userEmail;
            this.phoneNumber = phoneNumber;
            this.joiningDate = joiningDate;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public LocalDate getJoiningDate() {
            return joiningDate;
        }
    }

    /**
     * To store the users information {key=userID: value=UserDetail}
     */
    private HashMap<String, UserDetails> userMap = new HashMap<String, UserDetails>();

    /**
     * Add new user profile to User
     *
     * @param name         - the name of the new user
     * @param emailAddress - the email address of the new user
     * @param phoneNumber  -the phone number of the new user
     */
    public void addNewUserProfile(String name, String emailAddress, String phoneNumber) {
        LocalDate today = LocalDate.now();
        UserDetails userDetails = new UserDetails(name, emailAddress, phoneNumber, today);
        userId = generateUserId(name, emailAddress, phoneNumber);
        userMap.put(userId, userDetails);
    }

    /**
     * generate userId
     */
    public String generateUserId(String name, String emailAddress, String phoneNumber) {
    	char ch1 = name.toUpperCase().charAt(0);
    	String ch2 = Integer.toString((emailAddress.length()*2020)/54);
    	char ch3 = phoneNumber.charAt(4);
    	char ch4 = phoneNumber.charAt(9);
    	char ch5 = phoneNumber.charAt(10);
    	String userId = ch1 + ch2 + ch3 + ch4 + ch5;
    	return userId;
    }
    
    /**
     * Print the user information
     *
     * @param userId - a userID from outside generated somewhere else
     */
    public void displayUserProfile(String userId) {
        // userID coming from outside -> string type
        UserDetails details = userMap.get(userId);
        System.out.printf("User ID: %s, User Name: %s, Email Address: %s, Phone Number: %s, Joining Date: %s." , userId , details.getUserName() ,details.getUserEmail() ,details.getPhoneNumber(), details.getJoiningDate());
        System.out.println();
    }

    /**
     * Change User's name - get info hash map
     *
     * @param userID  - a userID from outside generated somewhere else
     * @param newName - the new name to be assigned
     */
    public void changeUserName(String userId, String newName) {
        userMap.get(userId).setUserName(newName);
    }

    /**
     * Change user Email Address - get info hash map
     *
     * @param userID          - a userID from outside generated somewhere else
     * @param newEmailAddress - the new email address to be assigned
     */
    public void changeUserEmailAddress(String userId, String newEmailAddress) {
        userMap.get(userId).setUserEmail(newEmailAddress);
    }

    /**
     * Change user phone number- get info hash map
     *
     * @param userID         - a userID from outside generated somewhere else
     * @param newPhoneNumber - the new phone number to be assigned
     */
    public void changeUserPhoneNumber(String userId, String newPhoneNumber) {
        userMap.get(userId).setPhoneNumber(newPhoneNumber);
    }
}


