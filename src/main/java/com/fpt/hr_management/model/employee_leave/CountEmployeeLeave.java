package com.fpt.hr_management.model.employee_leave;

public class CountEmployeeLeave {
	private int leaveDefault = 12;

	private int employeeId;
	private int leaveNumber;

	public CountEmployeeLeave() {
		super();
	}

	public CountEmployeeLeave(int employeeId, int leaveNumber) {
		this.employeeId = employeeId;
		this.leaveNumber = leaveNumber;
	}

	public int getLeaveDefault() {
		return leaveDefault;
	}

	public void setLeaveDefault(int leaveDefault) {
		this.leaveDefault = leaveDefault;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getLeaveNumber() {
		return leaveNumber;
	}

	public void setLeaveNumber(int leaveNumber) {
		this.leaveNumber = leaveNumber;
	}

}