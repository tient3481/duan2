package com.fpt.hr_management.listener.request.skill;

public class SkillAddRequest {
	private String name;
	private String description;
	private int category_id;
	private String created_by;
	private String last_modifier_by;

	public SkillAddRequest() {

	}

	public SkillAddRequest(String name, String description, int category_id, String created_by,
			String last_modifier_by) {
		super();
		this.name = name;
		this.description = description;
		this.category_id = category_id;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
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
		builder.append("SkillAddRequest [name=").append(name).append(", description=").append(description)
				.append(", category_id=").append(category_id).append(", created_by=").append(created_by)
				.append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}