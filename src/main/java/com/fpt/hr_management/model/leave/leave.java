package com.fpt.hr_management.model.leave;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.fpt.hr_management.model.BaseEntity;

public class leave extends BaseEntity {
	private int id;
	private int employee_id;
	private int reason_id;
	private Date start_date;
	private Date end_date;
	private Time start_time;
	private Time end_time;
	private Time created_time;
	private String employee_accept;
	private Timestamp accept_time;
	private int accept_status;;
	private String note;

	public leave() {
		super();
	}

	public leave(int id, int employee_id, int reason_id, Date start_date, Date end_date, Time start_time, Time end_time,
			Time created_time, String employee_accept, Timestamp accept_time, int accept_status, String note) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.reason_id = reason_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.created_time = created_time;
		this.employee_accept = employee_accept;
		this.accept_time = accept_time;
		this.accept_status = accept_status;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Time getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Time created_time) {
		this.created_time = created_time;
	}

	public String getEmployee_accept() {
		return employee_accept;
	}

	public void setEmployee_accept(String employee_accept) {
		this.employee_accept = employee_accept;
	}

	public Timestamp getAccept_time() {
		return accept_time;
	}

	public void setAccept_time(Timestamp accept_time) {
		this.accept_time = accept_time;
	}

	public int getAccept_status() {
		return accept_status;
	}

	public void setAccept_status(int accept_status) {
		this.accept_status = accept_status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
