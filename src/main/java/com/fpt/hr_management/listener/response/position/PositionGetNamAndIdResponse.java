package com.fpt.hr_management.listener.response.position;

public class PositionGetNamAndIdResponse {
	private int id;
	private String name;

	public PositionGetNamAndIdResponse() {
		
	}

	public PositionGetNamAndIdResponse(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PositionGetNamAndIdResponse [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
