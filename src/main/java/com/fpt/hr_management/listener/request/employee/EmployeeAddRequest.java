package com.fpt.hr_management.listener.request.employee;

import java.sql.Date;

import com.fpt.hr_management.listener.response.BaseRequest;

public class EmployeeAddRequest extends BaseRequest {
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phone;
	private String email;
	private Date dob;
	private String address;
	private int sex;
	private int employee_type_id;
	private String note;
	private String created_by;
	private int manager_id;

	public EmployeeAddRequest() {

	}

	public EmployeeAddRequest(String first_name, String middle_name, String last_name, String phone, String email,
			Date dob, String address, int sex, int employee_type_id, String note, String created_by, int manager_id) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.sex = sex;
		this.employee_type_id = employee_type_id;
		this.note = note;
		this.created_by = created_by;
		this.manager_id = manager_id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public int getEmployee_type_id() {
		return employee_type_id;
	}

	public void setEmployee_type_id(int employee_type_id) {
		this.employee_type_id = employee_type_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeAddRequest [first_name=").append(first_name).append(", middle_name=")
				.append(middle_name).append(", last_name=").append(last_name).append(", phone=").append(phone)
				.append(", email=").append(email).append(", dob=").append(dob).append(", address=").append(address)
				.append(", sex=").append(sex).append(", employee_type_id=").append(employee_type_id).append(", note=")
				.append(note).append(", created_by=").append(created_by).append(", manager_id=").append(manager_id)
				.append("]");
		return builder.toString();
	}

}