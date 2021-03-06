package com.fpt.hr_management.listener.response.skill;

import com.fpt.hr_management.model.BaseEntity;

public class SkillListGetOneResponse extends BaseEntity {
	private int id;
	private String name;
	private String description;
	private int category_id;

	private String categoryName;

	public SkillListGetOneResponse() {

	}

	public SkillListGetOneResponse(int id, String name, String description, int category_id, String created_date,
			String created_by, String last_modifier_date, String last_modifier_by) {
		super(created_date, created_by, last_modifier_date, last_modifier_by);
		this.id = id;
		this.name = name;
		this.description = description;
		this.category_id = category_id;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillListGetOneResponse [id=").append(id).append(", name=").append(name)
				.append(", description=").append(description).append(", category_id=").append(category_id)
				.append(", categoryName=").append(categoryName).append("]");
		return builder.toString();
	}

}
