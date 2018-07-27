package house_sale.model;

public class User {
	 private int user_ID;
	 private long userIDcardNum;
	 private String user_name;
	 private String  user_password;
	 private String user_sex;
	 private String user_real_name;
	 private int user_age;
	 private long user_balance;
	 private long user_IDnumber;
	 private int user_state;
     private long user_phone;
	 
	 
	 public long getUser_IDnumber() {
		return user_IDnumber;
	}

	public void setUser_IDnumber(long user_IDnumber) {
		this.user_IDnumber = user_IDnumber;
	}

	public long getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(long user_phone) {
		this.user_phone = user_phone;
	}

	 
	public User() {
		 
	}
	
	public User(int  user_ID, long userIDcardNum, String user_name,
			String user_password, String user_sex, String user_real_name,
			int user_age, int user_balance, int user_state) {
		super();
		this.user_ID = user_ID;
		this.userIDcardNum = userIDcardNum;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_real_name = user_real_name;
		this.user_age = user_age;
		this.user_balance = user_balance;
		this.user_state = user_state;
	}

	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_real_name() {
		return user_real_name;
	}
	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public long getUser_balance() {
		return user_balance;
	}
	public void setUser_balance(long user_balance) {
		this.user_balance = user_balance;
	}
	public int getUser_state() {
		return user_state;
	}
	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	public long getUserIDcardNum() {
		return userIDcardNum;
	}
	public void setUserIDcardNum(long userIDcardNum) {
		this.userIDcardNum = userIDcardNum;
	}
	 
	 
}
