import java.time.LocalDate;

public class User {
    private static class User {
        private String userName;
        private String userEmail;
        private String phoneNumber;
        private LocalDate joiningDate;

        public User(String userName, String userEmail, String phoneNumber, LocalDate joiningDate) {
            this.userName = userName;
            this.userEmail = userEmail;
            this.phoneNumber = phoneNumber;
            this.joiningDate = joiningDate;
        }

        public changeName(String newName) {
            this.userName = newName
        }

        public changeEmail(String newEmail) {
            this.userEmail = newEmail
        }

        public changePhoneNumber(String newNumber) {
            this.phoneNumber = newNumber
        }
    }

    // data structure to store user info - hashmap (key - userId, values - User)
    private int userId = 1;
    private HashMap<Integer, User> userMap = new HashMap<>();

    public void addNewUserProfile(String name, String emailAddress, String phoneNumber) {
        //generate id - go through the integers (1 , 2, ..)
        // create a new instance of user
        //add to data structure storing users
    }

    //displayuserprofile -
    // print formatted info
    public void displayUserProfile(String userID) {

    }

    //change user name - get info hash map
    public changeUserName(String userID, String newName) {
        userMap.get(userID).changeName(newName)
    }

    //change user Email Address - get info hash map
    public changeUserEmailAddress(String userID, String newEmailAddress) {
        userMap.get(userID).changeEmail(newEmailAddress)
    }

    //change user Phone Number - get info hash map
    public changeUserPhoneNumber(String userID, String newPhoneNumber) {
        userMap.get(userID).changePhoneNumber(newPhoneNumber)
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
