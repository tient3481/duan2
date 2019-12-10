package com.fpt.hr_management.listener.request.salary;

public class SalaryAllowanceRequest {
	private int employeeId;

	public SalaryAllowanceRequest() {

	}

	public SalaryAllowanceRequest(int employeeId) {
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
		builder.append("SalaryAllowanceRequest [employeeId=").append(employeeId).append("]");
		return builder.toString();
	}

}
