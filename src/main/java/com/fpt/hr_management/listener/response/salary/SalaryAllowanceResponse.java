package com.fpt.hr_management.listener.response.salary;

public class SalaryAllowanceResponse {
	private int employeeId;
	private String employeeName;
	private String allowanceName;
	private String allowanceDescription;
	private long allowanceSalary;

	public SalaryAllowanceResponse() {

	}

	public SalaryAllowanceResponse(int employeeId, String employeeName, String allowanceName,
			String allowanceDescription, long allowanceSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.allowanceName = allowanceName;
		this.allowanceDescription = allowanceDescription;
		this.allowanceSalary = allowanceSalary;
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

	public String getAllowanceName() {
		return allowanceName;
	}

	public void setAllowanceName(String allowanceName) {
		this.allowanceName = allowanceName;
	}

	public String getAllowanceDescription() {
		return allowanceDescription;
	}

	public void setAllowanceDescription(String allowanceDescription) {
		this.allowanceDescription = allowanceDescription;
	}

	public long getAllowanceSalary() {
		return allowanceSalary;
	}

	public void setAllowanceSalary(long allowanceSalary) {
		this.allowanceSalary = allowanceSalary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryAllowanceResponse [employeeId=").append(employeeId).append(", employeeName=")
				.append(employeeName).append(", allowanceName=").append(allowanceName).append(", allowanceDescription=")
				.append(allowanceDescription).append(", allowanceSalary=").append(allowanceSalary).append("]");
		return builder.toString();
	}

}
