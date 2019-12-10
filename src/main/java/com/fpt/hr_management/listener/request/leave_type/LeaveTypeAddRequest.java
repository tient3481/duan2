package com.fpt.hr_management.listener.request.leave_type;

public class LeaveTypeAddRequest {
	private String name;
	private String note;
	private String created_by;
	private String last_modifier_by;

	public LeaveTypeAddRequest() {

	}

	public LeaveTypeAddRequest(String name, String note, String created_by, String last_modifier_by) {
		this.name = name;
		this.note = note;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
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
		builder.append("LeaveTypeAddRequest [name=").append(name).append(", note=").append(note).append(", created_by=")
				.append(created_by).append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
