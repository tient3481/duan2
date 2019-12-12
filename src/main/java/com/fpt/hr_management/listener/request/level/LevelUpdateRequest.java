package com.fpt.hr_management.listener.request.level;

public class LevelUpdateRequest {
	private int id;
	private String name;
	private String note;

	public LevelUpdateRequest() {

	}

	public LevelUpdateRequest(int id, String name, String note) {
		this.id = id;
		this.name = name;
		this.note = note;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LevelUpdateRequest [id=").append(id).append(", name=").append(name).append(", note=")
				.append(note).append("]");
		return builder.toString();
	}

}
