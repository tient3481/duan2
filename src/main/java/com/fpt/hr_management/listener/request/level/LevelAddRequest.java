package com.fpt.hr_management.listener.request.level;

public class LevelAddRequest {
	private String name;
	private String note;

	public LevelAddRequest() {

	}

	public LevelAddRequest(String name, String note) {
		this.name = name;
		this.note = note;
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
		builder.append("LevelAddRequest [name=").append(name).append(", note=").append(note).append("]");
		return builder.toString();
	}
}
