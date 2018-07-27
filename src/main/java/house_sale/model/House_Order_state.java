package house_sale.model;

import java.sql.Timestamp;

public class House_Order_state extends House_sale{

	private int request_state;
	private int request_ID;
	private Timestamp order_time;

	public Timestamp getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}

	public int getRequest_ID() {
		return request_ID;
	}

	public void setRequest_ID(int request_ID) {
		this.request_ID = request_ID;
	}

	public int getRequest_state() {
		return request_state;
	}

	public void setRequest_state(int request_state) {
		this.request_state = request_state;
	}
	
}
