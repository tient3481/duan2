package com.fpt.hr_management.listener.request.relations_personnal;

public class RPAddRequest {

	private int employee_id;
	private String dad_name;
	private String mother_name;
	private String dad_job;
	private String mother_job;
	private String dad_phone;
	private String mother_phone;
	private String address;
	private String address_more;
	private String bs_name;
	private String bs_phone;
	private String bs_address;
	private String description;

	public RPAddRequest() {

	}

	public RPAddRequest(int employee_id, String dad_name, String mother_name, String dad_job, String mother_job,
			String dad_phone, String mother_phone, String address, String address_more, String bs_name, String bs_phone,
			String bs_address, String description) {
		this.employee_id = employee_id;
		this.dad_name = dad_name;
		this.mother_name = mother_name;
		this.dad_job = dad_job;
		this.mother_job = mother_job;
		this.dad_phone = dad_phone;
		this.mother_phone = mother_phone;
		this.address = address;
		this.address_more = address_more;
		this.bs_name = bs_name;
		this.bs_phone = bs_phone;
		this.bs_address = bs_address;
		this.description = description;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getDad_name() {
		return dad_name;
	}

	public void setDad_name(String dad_name) {
		this.dad_name = dad_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getDad_job() {
		return dad_job;
	}

	public void setDad_job(String dad_job) {
		this.dad_job = dad_job;
	}

	public String getMother_job() {
		return mother_job;
	}

	public void setMother_job(String mother_job) {
		this.mother_job = mother_job;
	}

	public String getDad_phone() {
		return dad_phone;
	}

	public void setDad_phone(String dad_phone) {
		this.dad_phone = dad_phone;
	}

	public String getMother_phone() {
		return mother_phone;
	}

	public void setMother_phone(String mother_phone) {
		this.mother_phone = mother_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_more() {
		return address_more;
	}

	public void setAddress_more(String address_more) {
		this.address_more = address_more;
	}

	public String getBs_name() {
		return bs_name;
	}

	public void setBs_name(String bs_name) {
		this.bs_name = bs_name;
	}

	public String getBs_phone() {
		return bs_phone;
	}

	public void setBs_phone(String bs_phone) {
		this.bs_phone = bs_phone;
	}

	public String getBs_address() {
		return bs_address;
	}

	public void setBs_address(String bs_address) {
		this.bs_address = bs_address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RPAddRequest [employee_id=").append(employee_id).append(", dad_name=").append(dad_name)
				.append(", mother_name=").append(mother_name).append(", dad_job=").append(dad_job)
				.append(", mother_job=").append(mother_job).append(", dad_phone=").append(dad_phone)
				.append(", mother_phone=").append(mother_phone).append(", address=").append(address)
				.append(", address_more=").append(address_more).append(", bs_name=").append(bs_name)
				.append(", bs_phone=").append(bs_phone).append(", bs_address=").append(bs_address)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}
}
