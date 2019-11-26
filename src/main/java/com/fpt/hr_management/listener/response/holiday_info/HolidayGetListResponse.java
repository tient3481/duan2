package com.fpt.hr_management.listener.response.holiday_info;

import java.sql.Date;

public class HolidayGetListResponse {

	private int id;
	private int employee_id;
	private int total_holiday;
	private Date date;

	public HolidayGetListResponse() {

	}

	public HolidayGetListResponse(int id, int employee_id, int total_holiday, Date date) {
		this.id = id;
		this.employee_id = employee_id;
		this.total_holiday = total_holiday;
		this.date = date;
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

	public int getTotal_holiday() {
		return total_holiday;
	}

	public void setTotal_holiday(int total_holiday) {
		this.total_holiday = total_holiday;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HolidayAddRequest [id=").append(id).append(", employee_id=").append(employee_id)
				.append(", total_holiday=").append(total_holiday).append(", date=").append(date).append("]");
		return builder.toString();
	}
}