package com.fpt.hr_management.listener.request.employee_department;

public class EmployeeDepartmentDeleteRequest {
	private int id;

	public EmployeeDepartmentDeleteRequest() {
		
	}

	public EmployeeDepartmentDeleteRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDepartmentDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
