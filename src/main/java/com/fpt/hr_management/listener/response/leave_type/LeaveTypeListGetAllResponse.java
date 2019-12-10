package com.fpt.hr_management.listener.response.leave_type;

import com.fpt.hr_management.model.BaseEntity;

public class LeaveTypeListGetAllResponse extends BaseEntity {

	private int id;
	private String name;
	private String note;

	public LeaveTypeListGetAllResponse() {
		super();
	}

	public LeaveTypeListGetAllResponse(int id, String name, String note, String created_date, String created_by,
			String last_modifier_date, String last_modifier_by) {
		super(created_date, created_by, last_modifier_date, last_modifier_by);
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
		builder.append("LeaveTypeListGetAllResponse [id=").append(id).append(", name=").append(name).append(", note=")
				.append(note).append(", created_date=").append(created_date).append(", created_by=").append(created_by)
				.append(", last_modifier_date=").append(last_modifier_date).append(", last_modifier_by=")
				.append(last_modifier_by).append("]");
		return builder.toString();
	}
}