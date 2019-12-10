package com.fpt.hr_management.listener.request.salary;

public class SalaryListGetOneRequest {
	private int employeeId;

	public SalaryListGetOneRequest() {

	}

	public SalaryListGetOneRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryListGetOneRequest [employeeId=").append(employeeId).append("]");
		return builder.toString();
	}

}