package com.fpt.hr_management.model.checkinout;

public class CheckInTime {
	private int hour;
	private int minute;
	private int second;

	public CheckInTime() {

	}

	public CheckInTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoCheckIn [hour=").append(hour).append(", minute=").append(minute).append(", second=")
				.append(second).append("]");
		return builder.toString();
	}

}
