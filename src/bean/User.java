package bean;

public class User {
	private long userId;
	private String userName;
	private String userPassword;
	private String userNickname;
	private String userMotto;
	private int userLevel;
	
	public User(){}
	
	public User(long userId, String userName, String userPassword,
			String userNickname, String userMotto, int userLevel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userMotto = userMotto;
		this.userLevel = userLevel;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserMotto() {
		return userMotto;
	}
	public void setUserMotto(String userMotto) {
		this.userMotto = userMotto;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
}
