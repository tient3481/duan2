package com.fpt.hr_management.listener.request.skill;

public class SkillDeleteRequest {
	private int id;

	public SkillDeleteRequest() {
		super();
	}

	public SkillDeleteRequest(int id) {
		super();
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
		builder.append("SkillDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
