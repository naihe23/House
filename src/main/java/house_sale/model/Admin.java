package house_sale.model;

public class Admin {
	private int admin_ID;
	private int staff_ID;
	private String staff_name;
	   private String staff_password;
	   private String staff_sex;
	   private int staff_age;
	   
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public String getStaff_sex() {
		return staff_sex;
	}
	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}
	public int getStaff_age() {
		return staff_age;
	}
	public void setStaff_age(int staff_age) {
		this.staff_age = staff_age;
	}
	public int getAdmin_ID() {
		return admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		this.admin_ID = admin_ID;
	}
	public int getStaff_ID() {
		return staff_ID;
	}
	public void setStaff_ID(int staff_ID) {
		this.staff_ID = staff_ID;
	}
	
}
