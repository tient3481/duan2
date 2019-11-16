package com.fpt.hr_management.listener.request.checkin;

public class CheckInAddRequest {
	private int user_id;

	public CheckInAddRequest() {

	}

	public CheckInAddRequest(int user_id) {
		super();
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckInAddRequest [user_id=").append(user_id).append("]");
		return builder.toString();
	}

}
