package com.fpt.hr_management.listener.request.skill_category;

public class SkillCategoryDeleteRequest {
	private int id;

	public SkillCategoryDeleteRequest() {

	}

	public SkillCategoryDeleteRequest(int id) {
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
		builder.append("SkillCategoryDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
