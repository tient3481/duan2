package com.fpt.hr_management.listener.request.checkin;

import java.sql.Time;

public class CheckOutUpdateRequest {
	private int id;
	private Time total_time;

	public CheckOutUpdateRequest() {

	}

	public CheckOutUpdateRequest(int id, String check_out_time, Time total_time) {
		this.id = id;
		this.total_time = total_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getTotal_time() {
		return total_time;
	}

	public void setTotal_time(Time total_time) {
		this.total_time = total_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckOutUpdateRequest [id=").append(id).append(", total_time=").append(total_time).append("]");
		return builder.toString();
	}

}
