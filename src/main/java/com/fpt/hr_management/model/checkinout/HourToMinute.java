package com.fpt.hr_management.model.checkinout;

public class HourToMinute {
	private long totalMinute;

	public HourToMinute() {

	}

	public HourToMinute(long totalMinute) {
		this.totalMinute = totalMinute;
	}

	public long getTotalMinute() {
		return totalMinute;
	}

	public void setTotalMinute(long totalMinute) {
		this.totalMinute = totalMinute;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HourToMinute [totalMinute=").append(totalMinute).append("]");
		return builder.toString();
	}

}
