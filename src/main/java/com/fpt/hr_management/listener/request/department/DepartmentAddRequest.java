package com.fpt.hr_management.listener.request.department;

public class DepartmentAddRequest {

	private int id;
	private String name;
	private String phone;
	private String location;
	private String created_by;
	private String last_modifier_date;
	private String last_modifier_by;

	public DepartmentAddRequest() {
		super();
	}

	public DepartmentAddRequest(int id, String name, String phone, String location, String created_by,
			String last_modifier_date, String last_modifier_by) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getLast_modifier_date() {
		return last_modifier_date;
	}

	public void setLast_modifier_date(String last_modifier_date) {
		this.last_modifier_date = last_modifier_date;
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
		builder.append("DepartmentAdd [name=").append(name).append(", phone=").append(phone).append(", location=")
				.append(location).append(", created_by=").append(created_by).append(", last_modifier_date=")
				.append(last_modifier_date).append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
