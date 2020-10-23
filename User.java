import java.time.LocalDate;

public class User {
	private int userId;
	private String userName;
	private String userEmail;
	private String phoneNumber;
	private LocalDate joiningDate;
	
	public static void main(String[] args) {
		//create an empty array
		HashMap<int, Array> allUserInfo = new HashMap<int, Array>()
		// data structure is created here
		User newUser = new User(,,);
		// add new user to data structure 
		//
		// TODO Auto-generated method stub

	}

	public User(int userId, String userName, String userEmail, String phoneNumber, LocalDate joiningDate) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.phoneNumber = phoneNumber;
		this.joiningDate = joiningDate;
	}

	//data structure to store user info - hashmap (key - userId, values - Array with user indo)
	// 
	
	public void addNewUserProfile(String name, String emailAddress, String phoneNumber) {
		//generate id - go through the integers (1 , 2, ..)
		// create a new instance of user
		//add to data structure storing users 
	}
	
	//displayuserprofile - 
	// print formatted info
	
	//change user name - get info hash map
	

	
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
