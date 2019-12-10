package com.fpt.hr_management.listener.request.checkin;

public class CheckInGetTimeRequest {

	private int id;
	private String check_in_time;
	private String check_out_time;

	public CheckInGetTimeRequest() {

	}

	public CheckInGetTimeRequest(int id, String check_in_time, String check_out_time) {
		this.id = id;
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckInGetTimeRequest [id=").append(id).append(", check_in_time=").append(check_in_time)
				.append(", check_out_time=").append(check_out_time).append("]");
		return builder.toString();
	}

}
