package com.fpt.hr_management.listener.response.skill_category;

import com.fpt.hr_management.model.BaseEntity;

public class SkillCategoryListGetAllResponse extends BaseEntity {
	private int id;
	private String name;
	private String description;

	public SkillCategoryListGetAllResponse() {
		super();
	}

	public SkillCategoryListGetAllResponse(int id, String name, String description, String created_date,
			String created_by, String last_modifier_date, String last_modifier_by) {
		super(created_date, created_by, last_modifier_date, last_modifier_by);
		this.id = id;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillCategoryListGetAllResponse [id=").append(id).append(", name=").append(name)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}