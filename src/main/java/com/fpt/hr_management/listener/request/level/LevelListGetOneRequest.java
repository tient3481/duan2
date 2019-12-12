package com.fpt.hr_management.listener.request.level;

public class LevelListGetOneRequest {
	private int id;

	public LevelListGetOneRequest() {
	}

	public LevelListGetOneRequest(int id) {
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
		builder.append("LevelListGetOneRequest [id=").append(id).append("]");
		return builder.toString();
	}
}
