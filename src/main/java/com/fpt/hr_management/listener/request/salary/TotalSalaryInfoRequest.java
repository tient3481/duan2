package com.fpt.hr_management.listener.request.salary;

public class TotalSalaryInfoRequest {
	private int employeeId;

	public TotalSalaryInfoRequest() {

	}

	public TotalSalaryInfoRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
