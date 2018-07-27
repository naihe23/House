package house_sale.model;

import java.sql.Timestamp;

public class Request_order {
	   private int request_ID;
	   private int house_ID;
	   private int user_ID;
	   private Timestamp time;
	   private int request_state;
	public int getRequest_ID() {
		return request_ID;
	}
	public void setRequest_ID(int request_ID) {
		this.request_ID = request_ID;
	}
	public int getHouse_ID() {
		return house_ID;
	}
	public void setHouse_ID(int house_ID) {
		this.house_ID = house_ID;
	}
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getRequest_state() {
		return request_state;
	}
	public void setRequest_state(int request_state) {
		this.request_state = request_state;
	}
	   
	   
}
