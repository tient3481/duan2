package com.fpt.hr_management.listener.request.employee;

import java.sql.Date;

import com.fpt.hr_management.listener.response.BaseRequest;

public class EmployeeUpdateRequest extends BaseRequest {

	private int id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phone;
	private String email;
	private Date dob;
	private String address;
	private int sex;
	private Date employee_date;
	private Date end_date;
	private int employee_type_id;
	private int status;
	private String note;
	private long base_salary;

	public EmployeeUpdateRequest() {

	}

	public EmployeeUpdateRequest(int id, String first_name, String middle_name, String last_name, String phone,
			String email, Date dob, String address, int sex, Date employee_date, Date end_date, int employee_type_id,
			int status, String note, long base_salary, String last_modifier_by) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.sex = sex;
		this.employee_date = employee_date;
		this.end_date = end_date;
		this.employee_type_id = employee_type_id;
		this.status = status;
		this.note = note;
		this.base_salary = base_salary;
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

	public Date getEmployee_date() {
		return employee_date;
	}

	public void setEmployee_date(Date employee_date) {
		this.employee_date = employee_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getEmployee_type_id() {
		return employee_type_id;
	}

	public void setEmployee_type_id(int employee_type_id) {
		this.employee_type_id = employee_type_id;
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

	public long getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(long base_salary) {
		this.base_salary = base_salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeUpdateRequest [id=").append(id).append(", first_name=").append(first_name)
				.append(", middle_name=").append(middle_name).append(", last_name=").append(last_name)
				.append(", phone=").append(phone).append(", email=").append(email).append(", dob=").append(dob)
				.append(", address=").append(address).append(", sex=").append(sex).append(", employee_date=")
				.append(employee_date).append(", end_date=").append(end_date).append(", employee_type_id=")
				.append(employee_type_id).append(", status=").append(status).append(", note=").append(note)
				.append(", base_salary=").append(base_salary).append("]");
		return builder.toString();
	}

}
