package com.fpt.hr_management.listener.request.checkin;

public class CheckOutUpdateRequest {
	private int id;

	public CheckOutUpdateRequest() {

	}

	public CheckOutUpdateRequest(int id, String check_out_time) {
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
		builder.append("CheckOutUpdateRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
