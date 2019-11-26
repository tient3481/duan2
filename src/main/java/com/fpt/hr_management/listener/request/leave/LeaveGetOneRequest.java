package com.fpt.hr_management.listener.request.leave;

public class LeaveGetOneRequest {
	private int idRecord;

	public LeaveGetOneRequest() {

	}

	public LeaveGetOneRequest(int idRecord) {
		this.idRecord = idRecord;
	}

	public int getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(int idRecord) {
		this.idRecord = idRecord;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveGetOneRequest [idRecord=").append(idRecord).append("]");
		return builder.toString();
	}

}
