package com.fpt.hr_management.listener.request.leave_type;

public class LeaveTypeUpdateRequest {
	private int id;
	private String name;
	private String note;
	private String last_modifier_by;

	public LeaveTypeUpdateRequest() {

	}

	public LeaveTypeUpdateRequest(int id, String name, String note, String last_modifier_by) {
		this.id = id;
		this.name = name;
		this.note = note;
		this.last_modifier_by = last_modifier_by;
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

	public String getLast_modifier_by() {
		return last_modifier_by;
	}

	public void setLast_modifier_by(String last_modifier_by) {
		this.last_modifier_by = last_modifier_by;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveTypeUpdateRequest [id=").append(id).append(", name=").append(name).append(", note=")
				.append(note).append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
