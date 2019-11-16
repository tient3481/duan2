package com.fpt.hr_management.listener.response.leave;

import java.sql.Date;

public class LeaveEmployeeGetOneResponse {
	private String employeeName;
	private Date start_date;
	private Date end_date;
	private boolean status;
	private String statusName;

	public LeaveEmployeeGetOneResponse() {
	
	}

	public LeaveEmployeeGetOneResponse(String employeeName, Date start_date, Date end_date, boolean status,
			String statusName) {
		super();
		this.employeeName = employeeName;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
		this.statusName = statusName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveEmployeeGetOneResponse [employeeName=").append(employeeName).append(", start_date=")
				.append(start_date).append(", end_date=").append(end_date).append(", status=").append(status)
				.append(", statusName=").append(statusName).append("]");
		return builder.toString();
	}

}