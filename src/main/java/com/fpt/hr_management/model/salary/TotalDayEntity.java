package com.fpt.hr_management.model.salary;

public class TotalDayEntity {
	private int month;
	private int year;
	private int day;

	public TotalDayEntity() {
	}

	public TotalDayEntity(int month, int year, int day) {
		this.month = month;
		this.year = year;
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalDayEntity [month=").append(month).append(", year=").append(year).append(", day=")
				.append(day).append("]");
		return builder.toString();
	}

}
