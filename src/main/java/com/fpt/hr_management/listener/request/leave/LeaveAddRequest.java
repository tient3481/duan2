package com.fpt.hr_management.listener.request.leave;

import java.sql.Date;
import java.sql.Time;

import com.fpt.hr_management.listener.response.BaseRequest;

public class LeaveAddRequest extends BaseRequest {
	private int employee_id;
	private int reason_id;
	private Date start_date;
	private Date end_date;
	private Time start_time;
	private Time end_time;
	private String note;

	public LeaveAddRequest() {

	}

	public LeaveAddRequest(int employee_id, int reason_id, Date start_date, Date end_date, Time start_time,
			Time end_time, String note, String created_by, String last_modifier_by) {
		super();
		this.employee_id = employee_id;
		this.reason_id = reason_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.note = note;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getReason_id() {
		return reason_id;
	}

	public void setReason_id(int reason_id) {
		this.reason_id = reason_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
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
		builder.append("LeaveAddRequest [employee_id=").append(employee_id).append(", reason_id=").append(reason_id)
				.append(", start_date=").append(start_date).append(", end_date=").append(end_date)
				.append(", start_time=").append(start_time).append(", end_time=").append(end_time).append(", note=")
				.append(note).append("]");
		return builder.toString();
	}

}