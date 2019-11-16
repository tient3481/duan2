package com.fpt.hr_management.model.employee;

import com.fpt.hr_management.model.BaseEntity;

public class Employee extends BaseEntity {

	private int id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String full_name;
	private String phone;
	private String email;
	private String dob;
	private String address;
	private int sex;
	private String start_date;
	private String employee_date;
	private String end_date;
	private int status;
	private String note;

	public Employee() {

	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(int id, String first_name, String middle_name, String last_name, String full_name, String phone,
			String email, String dob, String address, int sex, String start_date, String employee_date, String end_date,
			int status, String note, String created_date, String created_by, String last_modifier_date,
			String last_modifier_by) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.full_name = full_name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.sex = sex;
		this.start_date = start_date;
		this.employee_date = employee_date;
		this.end_date = end_date;
		this.status = status;
		this.note = note;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEmployee_date() {
		return employee_date;
	}

	public void setEmployee_date(String employee_date) {
		this.employee_date = employee_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		builder.append("Employee [id=").append(id).append(", first_name=").append(first_name).append(", middle_name=")
				.append(middle_name).append(", last_name=").append(last_name).append(", full_name=").append(full_name)
				.append(", phone=").append(phone).append(", email=").append(email).append(", dob=").append(dob)
				.append(", address=").append(address).append(", sex=").append(sex).append(", start_date=")
				.append(start_date).append(", employee_date=").append(employee_date).append(", end_date=")
				.append(end_date).append(", status=").append(status).append(", note=").append(note).append("]");
		return builder.toString();
	}

}
