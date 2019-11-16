package com.fpt.hr_management.model.department;

import com.fpt.hr_management.model.BaseEntity;

public class Department extends BaseEntity {

	private int id;
	private String name;
	private String phone;
	private String location;

	public Department() {

	}

	public Department(int id, String name, String phone, String location, String created_date, String created_by,
			String last_modifier_date, String last_modifier_by) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.created_date = created_date;
		this.created_by = created_by;
		this.last_modifier_date = last_modifier_date;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=").append(id).append(", name=").append(name).append(", phone=").append(phone)
				.append(", location=").append(location).append("]");
		return builder.toString();
	}

}