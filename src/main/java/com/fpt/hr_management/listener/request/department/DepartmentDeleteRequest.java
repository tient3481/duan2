package com.fpt.hr_management.listener.request.department;

public class DepartmentDeleteRequest {
	private int id;

	public DepartmentDeleteRequest() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DepartmentDeleteRequest(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
