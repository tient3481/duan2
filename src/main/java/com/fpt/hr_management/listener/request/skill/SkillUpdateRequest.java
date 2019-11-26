package com.fpt.hr_management.listener.request.skill;

public class SkillUpdateRequest {
	private int id;
	private String name;
	private String description;
	private int category_id;
	private String last_modifier_by;

	public SkillUpdateRequest() {
		super();
	}

	public SkillUpdateRequest(int id, String name, String description, int category_id, String last_modifier_by) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category_id = category_id;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
		builder.append("SkillUpdateRequest [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", category_id=").append(category_id).append(", last_modifier_by=")
				.append(last_modifier_by).append("]");
		return builder.toString();
	}

}
