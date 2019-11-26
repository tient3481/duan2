package com.fpt.hr_management.listener.response.relations_personal;

public class RPListGetOneResponse {
	private int id;
	private int employee_id;
	private String dad_or_mother_name;
	private String dad_or_mother_job;
	private String dad_or_mother_phone;
	private String dad_or_mother_address;
	private String bs_name;
	private String bs_phone;
	private String bs_address;
	private String description;

	public RPListGetOneResponse() {

	}

	public RPListGetOneResponse(int id, int employee_id, String dad_or_mother_name, String dad_or_mother_job,
			String dad_or_mother_phone, String dad_or_mother_address, String bs_name, String bs_phone,
			String bs_address, String description) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.dad_or_mother_name = dad_or_mother_name;
		this.dad_or_mother_job = dad_or_mother_job;
		this.dad_or_mother_phone = dad_or_mother_phone;
		this.dad_or_mother_address = dad_or_mother_address;
		this.bs_name = bs_name;
		this.bs_phone = bs_phone;
		this.bs_address = bs_address;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getDad_or_mother_name() {
		return dad_or_mother_name;
	}

	public void setDad_or_mother_name(String dad_or_mother_name) {
		this.dad_or_mother_name = dad_or_mother_name;
	}

	public String getDad_or_mother_job() {
		return dad_or_mother_job;
	}

	public void setDad_or_mother_job(String dad_or_mother_job) {
		this.dad_or_mother_job = dad_or_mother_job;
	}

	public String getDad_or_mother_phone() {
		return dad_or_mother_phone;
	}

	public void setDad_or_mother_phone(String dad_or_mother_phone) {
		this.dad_or_mother_phone = dad_or_mother_phone;
	}

	public String getDad_or_mother_address() {
		return dad_or_mother_address;
	}

	public void setDad_or_mother_address(String dad_or_mother_address) {
		this.dad_or_mother_address = dad_or_mother_address;
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
		builder.append("RPListGetOneResponse [id=").append(id).append(", employee_id=").append(employee_id)
				.append(", dad_or_mother_name=").append(dad_or_mother_name).append(", dad_or_mother_job=")
				.append(dad_or_mother_job).append(", dad_or_mother_phone=").append(dad_or_mother_phone)
				.append(", dad_or_mother_address=").append(dad_or_mother_address).append(", bs_name=").append(bs_name)
				.append(", bs_phone=").append(bs_phone).append(", bs_address=").append(bs_address)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}