package com.fpt.hr_management.listener.request.department;

import com.fpt.hr_management.listener.response.BaseRequest;

public class DepartmentUpdateRequest extends BaseRequest {
	private int id;
	private String name;
	private String phone;
	private String location;

	public DepartmentUpdateRequest() {
		super();
	}

	public DepartmentUpdateRequest(int id, String name, String phone, String location, String last_modifier_by) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.last_modifier_by = last_modifier_by;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLast_modifier_by() {
		return last_modifier_by;
	}

	public void setLast_modifier_by(String last_modifier_by) {
		this.last_modifier_by = last_modifier_by;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentUpdateRequest [id=").append(id).append(", name=").append(name).append(", phone=")
				.append(phone).append(", location=").append(location).append(", last_modifier_by=")
				.append(last_modifier_by).append("]");
		return builder.toString();
	}

}
