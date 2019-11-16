package com.fpt.hr_management.listener.request.position;

import com.fpt.hr_management.listener.response.BaseRequest;

public class PositionUpdateRequest extends BaseRequest {
	private int id;
	private String name;
	private String description;
	private String last_modifier_by;

	public PositionUpdateRequest() {
		super();
	}

	public PositionUpdateRequest(int id, String name, String description, String last_modifier_by) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.last_modifier_by = last_modifier_by;
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

	public String getLast_modifier_by() {
		return last_modifier_by;
	}

	public void setLast_modifier_by(String last_modifier_by) {
		this.last_modifier_by = last_modifier_by;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PositionUpdateRequest [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
