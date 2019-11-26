package com.fpt.hr_management.daoImpl;

import com.fpt.hr_management.model.salary.TotalDayEntity;

public class TotalDayOfMonth {

	@SuppressWarnings("unused")
	private int start_date = 10;

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static TotalDayEntity getDayOfMonth(TotalDayEntity object) {
		int month = object.getMonth();
		int year = object.getYear();

		int arrMonth31[] = { 1, 3, 5, 7, 8, 10, 12 };
		for (int i = 0; i < arrMonth31.length; i++) {
			if (arrMonth31[i] == object.getMonth()) {
				object.setDay(31);
				break;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				object.setDay(30);
				break;
			}

			TotalDayOfMonth totalDay = new TotalDayOfMonth();
			if (month == 2 && totalDay.isLeapYear(year)) {
				object.setDay(29);
				break;
			} else {
				object.setDay(28);
			}

		}

		object.setMonth(month);
		object.setYear(year);

		System.out.println(object.toString());
		return object;

	}

	public static void main(String[] args) {
		TotalDayEntity object = new TotalDayEntity();
		object.setMonth(2);
		object.setYear(2000);

		getDayOfMonth(object);
	}
}
