package com.fpt.hr_management.listener.request.employee;

public class EmployeeDeleteRequest {
	private int id;

	public EmployeeDeleteRequest() {

	}

	public EmployeeDeleteRequest(int id) {
		super();
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
		builder.append("EmployeeDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
