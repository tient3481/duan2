package com.fpt.hr_management.listener.request.department;

public class DepartmentGetOneRequest {
	private int id;

	public DepartmentGetOneRequest() {
		super();
	}

	public DepartmentGetOneRequest(int id) {
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
		builder.append("DepartmentGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
