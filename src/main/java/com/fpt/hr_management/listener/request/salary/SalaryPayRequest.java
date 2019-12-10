package com.fpt.hr_management.listener.request.salary;

public class SalaryPayRequest {

	private int employeeId;
	private String fromDate;
	private String toDate;

	public SalaryPayRequest() {

	}

	public SalaryPayRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public SalaryPayRequest(String fromDate, String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public SalaryPayRequest(int employeeId, String fromDate, String toDate) {
		this.employeeId = employeeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryPayRequest [employeeId=").append(employeeId).append(", fromDate=").append(fromDate)
				.append(", toDate=").append(toDate).append("]");
		return builder.toString();
	}

}
