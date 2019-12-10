package com.fpt.hr_management.listener.response.time_keeping;

public class TimeKeepingGetAllResponse {
	private int employeeId;
	private String employeeName;
	private String checkInFirst;
	private String checkOutLast;
	private String totalTime;
	private String date;

	public TimeKeepingGetAllResponse() {

	}

	public TimeKeepingGetAllResponse(int employeeId, String employeeName, String checkInFirst, String checkOutLast,
			String totalTime, String date) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.checkInFirst = checkInFirst;
		this.checkOutLast = checkOutLast;
		this.totalTime = totalTime;
		this.date = date;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCheckInFirst() {
		return checkInFirst;
	}

	public void setCheckInFirst(String checkInFirst) {
		this.checkInFirst = checkInFirst;
	}

	public String getCheckOutLast() {
		return checkOutLast;
	}

	public void setCheckOutLast(String checkOutLast) {
		this.checkOutLast = checkOutLast;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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
		builder.append("TimeKeepingGetAllResponse [employeeId=").append(employeeId).append(", employeeName=")
				.append(employeeName).append(", checkInFirst=").append(checkInFirst).append(", checkOutLast=")
				.append(checkOutLast).append(", totalTime=").append(totalTime).append(", date=").append(date)
				.append("]");
		return builder.toString();
	}

}
