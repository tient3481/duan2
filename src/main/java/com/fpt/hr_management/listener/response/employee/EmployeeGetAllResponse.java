package com.fpt.hr_management.listener.response.employee;

public class EmployeeGetAllResponse {

	private int id;
	private String full_name;
	private String phone;
	private String email;
	private String dob;
	private String address;
	private int sex;
	private String start_date;
	private String employee_date;
	private boolean status;

	private String sexName;

	public EmployeeGetAllResponse() {
		super();
	}

	public EmployeeGetAllResponse(int id, String full_name, String phone, String email, String dob, String address,
			int sex, String start_date, String employee_date, boolean status) {
		super();
		this.full_name = full_name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.sex = sex;
		this.start_date = start_date;
		this.employee_date = employee_date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeGetAllResponse [id=").append(id).append(", full_name=").append(full_name)
				.append(", phone=").append(phone).append(", email=").append(email).append(", dob=").append(dob)
				.append(", address=").append(address).append(", sex=").append(sex).append(", start_date=")
				.append(start_date).append(", employee_date=").append(employee_date).append(", status=").append(status)
				.append(", sexName=").append(sexName).append("]");
		return builder.toString();
	}

}