package com.fpt.hr_management.listener.request.employee;

public class EmployeeGetOneRequest {
	private int id;

	public EmployeeGetOneRequest() {
		super();
	}

	public EmployeeGetOneRequest(int id) {
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
		builder.append("EmployeeGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
