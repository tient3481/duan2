package com.fpt.hr_management.listener.request.skill;

public class SkillListGetOneRequest {
	private int id;

	public SkillListGetOneRequest() {
	}

	public SkillListGetOneRequest(int id) {
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
		builder.append("SkillListGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
