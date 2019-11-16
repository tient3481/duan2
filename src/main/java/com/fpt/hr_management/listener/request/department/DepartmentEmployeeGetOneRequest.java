package com.fpt.hr_management.listener.request.department;

public class DepartmentEmployeeGetOneRequest {
	private int employeeId;

	public DepartmentEmployeeGetOneRequest() {
		super();
	}

	public DepartmentEmployeeGetOneRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
