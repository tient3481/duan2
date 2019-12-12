package com.fpt.hr_management.listener.request.level;

public class LevelDeleteRequest {
	private int id;

	public LevelDeleteRequest() {
	}

	public LevelDeleteRequest(int id) {
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
		builder.append("LevelDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}
}
