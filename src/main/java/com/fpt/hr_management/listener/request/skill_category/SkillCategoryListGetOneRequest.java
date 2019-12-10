package com.fpt.hr_management.listener.request.skill_category;

public class SkillCategoryListGetOneRequest {
	private int id;

	public SkillCategoryListGetOneRequest() {
	}

	public SkillCategoryListGetOneRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillCategoryListGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}
}