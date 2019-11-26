package com.fpt.hr_management.listener.response.skill;

public class SkillListGetAllResponse{
	private int id;
	private String name;
	private String description;
	private int category_id;

	public SkillListGetAllResponse() {

	}

	public SkillListGetAllResponse(int id, String name, String description, int category_id) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillGetAll [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", category_id=").append(category_id).append("]");
		return builder.toString();
	}

}