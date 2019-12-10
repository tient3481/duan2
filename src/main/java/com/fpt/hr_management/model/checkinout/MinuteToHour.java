package com.fpt.hr_management.model.checkinout;

public class MinuteToHour {
	private long hour;
	private long minute;
	private long second;

	private long totalMinute;
	private MinuteToHour totalTime;

	public MinuteToHour() {

	}

	public MinuteToHour(MinuteToHour totalTime, long hour, long minute, long second) {
		this.totalTime = totalTime;
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

	public MinuteToHour getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(MinuteToHour totalTime) {
		this.totalTime = totalTime;
	}

	public String toString(long hour, long minute, long second) {
		MinuteToHour minuteToHour = new MinuteToHour();
		StringBuilder sb = new StringBuilder();
		sb.append(hour == 0 ? "00" : hour < 10 ? String.valueOf("0" + hour) : String.valueOf(hour));
		minuteToHour.setHour(hour);
		sb.append(":");
		sb.append(minute == 0 ? "00" : minute < 10 ? String.valueOf("0" + minute) : String.valueOf(minute));
		minuteToHour.setMinute(minute);
		sb.append(":");
		sb.append(second == 0 ? "00" : second < 10 ? String.valueOf("0" + second) : String.valueOf(second));
		minuteToHour.setSecond(second);
		return sb.toString();
	}
}
