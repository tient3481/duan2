package com.fpt.hr_management.listener.request.relations_personnal;

public class RPDeleteRequest {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RPDeleteRequest [id=").append(id).append("]");
		return builder.toString();
	}

}
