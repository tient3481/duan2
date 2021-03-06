package com.fpt.hr_management.listener.request.skill_category;

public class SkillCategoryAddRequest {
	private String name;
	private String description;
	private String created_by;
	private String last_modifier_by;

	public SkillCategoryAddRequest() {

	}

	public SkillCategoryAddRequest(String name, String description, String created_by, String last_modifier_by) {
		this.name = name;
		this.description = description;
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
		builder.append("SkillCategoryAddRequest [name=").append(name).append(", description=").append(description)
				.append(", created_by=").append(created_by).append(", last_modifier_by=").append(last_modifier_by)
				.append("]");
		return builder.toString();
	}

}
