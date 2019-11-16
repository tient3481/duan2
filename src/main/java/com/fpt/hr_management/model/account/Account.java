package com.fpt.hr_management.model.account;

import com.fpt.hr_management.model.BaseEntity;

public class Account extends BaseEntity {

	private int id;
	private int role_id;
	private int employee_id;
	private String username;
	private String password;

	public Account() {

	}

	public Account(int role_id, int employee_id, String username, String password) {
		super();
		this.role_id = role_id;
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
	}

	public Account(int role_id, int employee_id, String username, String password, String created_by,
			String last_modifier_by) {
		super();
		this.role_id = role_id;
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
	}

	public Account(int id, int role_id, int employee_id, String username, String password, String created_by,
			String last_modifier_by) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
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
		builder.append("Account [role_id=").append(role_id).append(", employee_id=").append(employee_id)
				.append(", username=").append(username).append(", password=").append(password).append(", created_by=")
				.append(created_by).append(", last_modifier_date=").append(last_modifier_date)
				.append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
