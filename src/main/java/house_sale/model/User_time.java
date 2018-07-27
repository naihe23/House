package house_sale.model;

public class User_time extends User{

	private int request_ID;
	private  java.util.Date time;

	public java.util.Date  getTime() {
		return time;
	}

	public void setTime(java.util.Date  time) {
		this.time = time;
	}

	public int getRequest_ID() {
		return request_ID;
	}

	public void setRequest_ID(int request_ID) {
		this.request_ID = request_ID;
	}
	
	
}
