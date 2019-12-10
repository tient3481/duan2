package com.fpt.hr_management.listener.request.leave_type;

public class LeaveTypeDeleteRequest {
	private int id;

	public LeaveTypeDeleteRequest() {

	}

	public LeaveTypeDeleteRequest(int id) {
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
		builder.append("LeaveTypeDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}
}
