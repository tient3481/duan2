package com.fpt.hr_management.daoImpl.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EmployeeValidator {

	/**
	 * @param year
	 * @return true if getyear >= 18
	 */
	public boolean dob(int year) {
		Calendar c1 = Calendar.getInstance();
		int getYear = c1.get(Calendar.YEAR) - year;
		if (getYear >= 18) {
			return true;
		}

		return false;
	}

	/**
	 * @return true if employeeDate param > date now
	 * @throws ParseException
	 */
	public boolean employeeDate(String employeeDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date dateNow = new Date();
		Date dateEmployee = formatter.parse(employeeDate);

		System.out.println(formatter.format(dateNow));
		System.out.println(formatter.format(dateEmployee));
		int compare = dateEmployee.compareTo(dateNow);

		if (compare >= 0) {
			return true;
		}

		return false;
	}
	
	public int getYear(Date date) {
		int year = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		year = calendar.get(Calendar.YEAR);
		return year;
	}

//	public static boolean endDate(String endDate) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		Calendar c1 = Calendar.getInstance();// today
//		Calendar c2 = Calendar.getInstance();// endDate
//
//		Date dateC = null;
//		if (endDate.length() > 0) {
//			dateC = sdf.parse(endDate);
//			c2.setTime(dateC);
//		} else {
//			endDate = null;
//		}
//
//	}

}
