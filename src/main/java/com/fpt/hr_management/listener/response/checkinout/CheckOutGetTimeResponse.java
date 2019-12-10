package com.fpt.hr_management.listener.response.checkinout;

import java.sql.Time;
import java.util.Arrays;

public class CheckOutGetTimeResponse {

	private String check_in_time;
	private String check_out_time;

	private Time total_time;
	private String arrTime[];

	public CheckOutGetTimeResponse() {
		super();
	}

	public CheckOutGetTimeResponse(String check_in_time, String check_out_time, Time total_time) {
		super();
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
		this.total_time = total_time;
	}

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}

	public Time getTotal_time() {
		return total_time;
	}

	public void setTotal_time(Time total_time) {
		this.total_time = total_time;
	}

	public String[] getArrTime() {
		return arrTime;
	}

	public void setArrTime(String[] arrTime) {
		this.arrTime = arrTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckOutGetTimeResponse [total_time=").append(total_time).append(", arrTime=")
				.append(Arrays.toString(arrTime)).append("]");
		return builder.toString();
	}

}
