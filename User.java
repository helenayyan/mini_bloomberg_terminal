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


    private HashMap<Integer, UserDetails> userMap = new HashMap<Integer, UserDetails>();

    public void addNewUserProfile(String name, String emailAddress, String phoneNumber) {
    	LocalDate today = LocalDate.now();
    	UserDetails userDetails = new UserDetails(name, emailAddress, phoneNumber, today);
    	userMap.put(userId, userDetails);
    	userId++;
    }

    public void displayUserProfile(int userID) {
    	UserDetails details = userMap.get(userID);
    	System.out.println("User Id: " + userID + "," + " User Name: " + details.getUserName() + "," + " Email Address: " + 
    	details.getUserEmail() + "," + " Phone Number: " + details.getPhoneNumber() + "," + " Joining Date: " + details.getJoiningDate());
    }

    public void changeUserName(int userID, String newName) {
        userMap.get(userID).setUserName(newName);
    }

    //change user Email Address - get info hash map
    public void changeUserEmailAddress(int userID, String newEmailAddress) {
        userMap.get(userID).setUserEmail(newEmailAddress);
    }

    //change user Phone Number - get info hash map
    public void changeUserPhoneNumber(int userID, String newPhoneNumber) {
        userMap.get(userID).setPhoneNumber(newPhoneNumber);
    }
}



