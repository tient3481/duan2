package com.fpt.hr_management.listener.response.account;

public class AccountRegisterGetEmployeeNameResponse {
	private int employeeId;
	private String employeeName;

	public AccountRegisterGetEmployeeNameResponse() {

	}

	public AccountRegisterGetEmployeeNameResponse(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountRegisterEmployeeGetResponse [employeeId=").append(employeeId).append(", employeeName=")
				.append(employeeName).append("]");
		return builder.toString();
	}

}
