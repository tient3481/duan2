package com.fpt.hr_management.model.checkinout;

public class CheckInTime {
	private long hour;
	private long minute;
	private long second;

	private long totalMinute;

	public CheckInTime() {

	}

	public CheckInTime(long hour, long minute, long second, long totalMinute) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.totalMinute = totalMinute;
	}

	public CheckInTime(long hour, long minute, long second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public long getMinute() {
		return minute;
	}

	public void setMinute(long minute) {
		this.minute = minute;
	}

	public long getSecond() {
		return second;
	}

	public void setSecond(long second) {
		this.second = second;
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
		builder.append("CheckInTime [hour=").append(hour).append(", minute=").append(minute).append(", second=")
				.append(second).append(", totalMinute=").append(totalMinute).append("]");
		return builder.toString();
	}

}
