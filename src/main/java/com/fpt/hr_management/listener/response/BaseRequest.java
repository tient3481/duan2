package com.fpt.hr_management.listener.response;

public class BaseRequest {
	protected String created_by;
	protected String created_date;
	protected String last_modifier_date;
	protected String last_modifier_by;

	public BaseRequest() {

	}

	public BaseRequest(String created_by, String created_date, String last_modifier_date, String last_modifier_by) {
		this.created_by = created_by;
		this.created_date = created_date;
		this.last_modifier_date = last_modifier_date;
		this.last_modifier_by = last_modifier_by;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
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

}
