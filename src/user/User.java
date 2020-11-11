import java.time.LocalDate;
import java.util.HashMap;

public class User {
    //start the userIds from 1.
    private int userId = 1;

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

        public void setJoiningDate(LocalDate joiningDate) {
            this.joiningDate = joiningDate;
        }
    }

    /**
     * To store the users information {key=userID: value=UserDetail}
     */
    private HashMap<Integer, UserDetails> userMap = new HashMap<Integer, UserDetails>();

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
        userMap.put(userId, userDetails);
        userId++;
    }

    /**
     * Print the user information
     *
     * @param userID - a userID from outside generated somewhere else
     */
    public void displayUserProfile(String userId) {
        // userID coming from outside -> string type
        int userID = Integer.parseInt(userId);
        UserDetails details = userMap.get(userID);
        System.out.println("User Id: " + userID + "," + " User Name: " + details.getUserName() + "," + " Email Address: " +
                details.getUserEmail() + "," + " Phone Number: " + details.getPhoneNumber() + "," + " Joining Date: " + details.getJoiningDate());
    }

    /**
     * Change User's name - get info hash map
     *
     * @param userID  - a userID from outside generated somewhere else
     * @param newName - the new name to be assigned
     */
    public void changeUserName(String userId, String newName) {
        int userID = Integer.parseInt(userId);
        userMap.get(userID).setUserName(newName);
    }

    /**
     * Change user Email Address - get info hash map
     *
     * @param userID          - a userID from outside generated somewhere else
     * @param newEmailAddress - the new email address to be assigned
     */
    public void changeUserEmailAddress(String userId, String newEmailAddress) {
        int userID = Integer.parseInt(userId);
        userMap.get(userID).setUserEmail(newEmailAddress);
    }

    /**
     * Change user phone number- get info hash map
     *
     * @param userID         - a userID from outside generated somewhere else
     * @param newPhoneNumber - the new phone number to be assigned
     */
    public void changeUserPhoneNumber(String userId, String newPhoneNumber) {
        int userID = Integer.parseInt(userId);
        userMap.get(userID).setPhoneNumber(newPhoneNumber);
    }
}



