package com.fpt.hr_management.listener.request.checkin;

public class CheckInDeleteRequest {
	private int id;

	public CheckInDeleteRequest() {

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
		builder.append("CheckInDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
