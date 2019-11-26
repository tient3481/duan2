package com.fpt.hr_management.listener.response.employee_type;

public class EmployeeTypeResponse {
	private int id;
	private String name;
	private String description;

	public EmployeeTypeResponse() {
		super();
	}

	public EmployeeTypeResponse(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeTypeResponse [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}

}