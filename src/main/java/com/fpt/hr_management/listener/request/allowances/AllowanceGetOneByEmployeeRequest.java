package com.fpt.hr_management.listener.request.allowances;

public class AllowanceGetOneByEmployeeRequest {
	private int employeeId;

	public AllowanceGetOneByEmployeeRequest(int employeeId) {
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
		builder.append("AllowancesGetOneByEmployeeRequest [employeeId=").append(employeeId).append("]");
		return builder.toString();
	}

}