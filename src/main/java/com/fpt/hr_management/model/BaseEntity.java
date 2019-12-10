package com.fpt.hr_management.model;

public abstract class BaseEntity {

	public String created_date;
	public String created_by;
	public String last_modifier_date;
	public String last_modifier_by;

	public BaseEntity() {
		super();
	}

	public BaseEntity(String created_date, String created_by, String last_modifier_date, String last_modifier_by) {
		super();
		this.created_date = created_date;
		this.created_by = created_by;
		this.last_modifier_date = last_modifier_date;
		this.last_modifier_by = last_modifier_by;
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

}
