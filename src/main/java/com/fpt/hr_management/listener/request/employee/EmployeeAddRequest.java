package com.fpt.hr_management.listener.request.employee;

import java.sql.Date;

import com.fpt.hr_management.listener.response.BaseRequest;

public class EmployeeAddRequest extends BaseRequest {

	private String first_name;
	private String middle_name;
	private String last_name;
	private Date dob;
	private int sex;
	private String email;
	private String address;
	private String phone;
	private int employee_type;
	private String note;
	private String created_by;
	private int user_manager;

	public EmployeeAddRequest() {
		super();
	}

	public EmployeeAddRequest(String first_name, String middle_name, String last_name, Date dob, int sex, String email,
			String address, String phone, int employee_type, String note, String created_by, int user_manager) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.dob = dob;
		this.sex = sex;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.employee_type = employee_type;
		this.note = note;
		this.created_by = created_by;
		this.user_manager = user_manager;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(int employee_type) {
		this.employee_type = employee_type;
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
		return user_manager;
	}

	public void setManager_id(int manager_id) {
		this.user_manager = manager_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeAddRequest [first_name=").append(first_name).append(", middle_name=")
				.append(middle_name).append(", last_name=").append(last_name).append(", dob=").append(dob)
				.append(", sex=").append(sex).append(", email=").append(email).append(", address=").append(address)
				.append(", phone=").append(phone).append(", employee_type=").append(employee_type).append(", note=")
				.append(note).append(", created_by=").append(created_by).append(", user_manager=").append(user_manager)
				.append("]");
		return builder.toString();
	}

}