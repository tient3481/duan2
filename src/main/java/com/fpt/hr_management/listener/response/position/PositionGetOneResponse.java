package com.fpt.hr_management.listener.response.position;

import com.fpt.hr_management.model.BaseEntity;

public class PositionGetOneResponse extends BaseEntity {

	private int id;
	private String name;
	private String description;

	public PositionGetOneResponse() {

	}

	public PositionGetOneResponse(int id, String name, String description, String created_date, String created_by,
			String last_modifier_date, String last_modifier_by) {
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		builder.append("PositionGetOneResponse [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}

}