package com.fpt.hr_management.model.checkinout;

public class CheckInOutEntity {
	private int id;
	private int user_id;
	private String check_in_time;
	private String check_out_time;
	private String date;

	public CheckInOutEntity() {

	}

	public CheckInOutEntity(int id, int user_id, String check_in_time, String check_out_time, String date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckInOutEntity [id=").append(id).append(", user_id=").append(user_id)
				.append(", check_in_time=").append(check_in_time).append(", check_out_time=").append(check_out_time)
				.append(", date=").append(date).append("]");
		return builder.toString();
	}

}