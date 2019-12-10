package com.fpt.hr_management.listener.request.TimeKeeping;

public class TimeKeepingGetAllRequest {
	private int employeeId;

	public TimeKeepingGetAllRequest() {

	}

	public TimeKeepingGetAllRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}