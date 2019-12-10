package com.fpt.hr_management.listener.request.leave_type;

public class LeaveTypeListGetOneRequest {
	private int id;

	public LeaveTypeListGetOneRequest() {

	}

	public LeaveTypeListGetOneRequest(int id) {
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
		builder.append("LeaveTypeListGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}

}