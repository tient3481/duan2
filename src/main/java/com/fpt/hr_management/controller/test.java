package com.fpt.hr_management.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.DATE) + " "
				+ calendar.get(Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH)));
		
		
	}
}
