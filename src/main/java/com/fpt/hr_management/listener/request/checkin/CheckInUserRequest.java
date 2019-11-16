package com.fpt.hr_management.listener.request.checkin;

public class CheckInUserRequest {
	private int id;

	public CheckInUserRequest() {
		super();
	}

	public CheckInUserRequest(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckInUserRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
