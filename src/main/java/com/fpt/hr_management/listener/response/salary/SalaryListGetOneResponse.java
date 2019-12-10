package com.fpt.hr_management.listener.response.salary;

public class SalaryListGetOneResponse {
	private int employeeId;
	private String employeeName;
	private int month;
	private long totalDay;
	private long totalSalary;

	public SalaryListGetOneResponse() {

	}

	public SalaryListGetOneResponse(int employeeId, String employeeName, int month, long totalDay, long totalSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.month = month;
		this.totalDay = totalDay;
		this.totalSalary = totalSalary;
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(long totalDay) {
		this.totalDay = totalDay;
	}

	public long getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(long totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryListGetOne [employeeId=").append(employeeId).append(", employeeName=")
				.append(employeeName).append(", month=").append(month).append(", totalDay=").append(totalDay)
				.append(", totalSalary=").append(totalSalary).append("]");
		return builder.toString();
	}

}