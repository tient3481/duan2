package com.fpt.hr_management.listener.response.employee;

public class EmployeeGetOneResponse {
	private int id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phone;
	private String email;
	private String dob;
	private String address;
	private String employee_date;
	private String end_date;
	private long base_salary;
	private String note;

	private int status;
	private int employee_type_id;
	private int user_manager;
	private int sex;

	private String type_name;
	private String status_name;
	private String user_manager_name;
	private String gender_name;

	public EmployeeGetOneResponse() {
		super();
	}

	public EmployeeGetOneResponse(int id, String first_name, String middle_name, String last_name, String phone,
			String email, String dob, String address, String gender_name, String employee_date, String end_date,
			String type_name, String status_name, long base_salary, String user_manager_name, String note) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.gender_name = gender_name;
		this.employee_date = employee_date;
		this.end_date = end_date;
		this.type_name = type_name;
		this.status_name = status_name;
		this.base_salary = base_salary;
		this.user_manager_name = user_manager_name;
		this.note = note;
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

	public String getGender_name() {
		return gender_name;
	}

	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
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

	public long getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(long base_salary) {
		this.base_salary = base_salary;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getUser_manager_name() {
		return user_manager_name;
	}

	public void setUser_manager_name(String user_manager_name) {
		this.user_manager_name = user_manager_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmployee_type_id() {
		return employee_type_id;
	}

	public void setEmployee_type_id(int employee_type_id) {
		this.employee_type_id = employee_type_id;
	}

	public int getUser_manager() {
		return user_manager;
	}

	public void setUser_manager(int user_manager) {
		this.user_manager = user_manager;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeGetOneResponse [id=").append(id).append(", first_name=").append(first_name)
				.append(", middle_name=").append(middle_name).append(", last_name=").append(last_name)
				.append(", phone=").append(phone).append(", email=").append(email).append(", dob=").append(dob)
				.append(", address=").append(address).append(", employee_date=").append(employee_date)
				.append(", end_date=").append(end_date).append(", base_salary=").append(base_salary).append(", note=")
				.append(note).append(", type_name=").append(type_name).append(", status_name=").append(status_name)
				.append(", user_manager_name=").append(user_manager_name).append(", gender_name=").append(gender_name)
				.append("]");
		return builder.toString();
	}

}
