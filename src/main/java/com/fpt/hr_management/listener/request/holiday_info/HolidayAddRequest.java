package com.fpt.hr_management.listener.request.holiday_info;

import java.sql.Date;

public class HolidayAddRequest {
	private int employee_id;
	private int total_holiday;
	private Date date;

	public HolidayAddRequest() {

	}

	public HolidayAddRequest(int employee_id, int total_holiday) {
		this.employee_id = employee_id;
		this.total_holiday = total_holiday;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HolidayAddRequest [employee_id=").append(employee_id).append(", total_holiday=")
				.append(total_holiday).append(", date=").append(date).append("]");
		return builder.toString();
	}

}