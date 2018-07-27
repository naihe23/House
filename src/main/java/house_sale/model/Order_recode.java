package house_sale.model;

import java.sql.Timestamp;

public class Order_recode {

	   private int order_ID;
	   private Timestamp time;
	   private int user_ID;
	   private int house_ID;
	   private int staff_ID;
	public int getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public int getHouse_ID() {
		return house_ID;
	}
	public void setHouse_ID(int house_ID) {
		this.house_ID = house_ID;
	}
	public int getStaff_ID() {
		return staff_ID;
	}
	public void setStaff_ID(int staff_ID) {
		this.staff_ID = staff_ID;
	}
	   
}
