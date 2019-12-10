package com.fpt.hr_management.daoImpl.checkinout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fpt.hr_management.listener.response.checkinout.CheckInGetAllResponse;
import com.fpt.hr_management.model.checkinout.CheckInTime;
import com.fpt.hr_management.model.checkinout.MinuteToHour;
import com.fpt.hr_management.model.salary.SalaryInfo;

public class CheckInService {
	private static CheckInTime infoCheckIn;
	private static SalaryInfo salaryInfo;
	private static final int DAY_FOR_SALARY = 10;

	public CheckInTime hourWorkOneDay(CheckInGetAllResponse data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		java.util.Date time1 = null;
		java.util.Date time2 = null;
		try {
			java.util.Date date = new java.util.Date(sdf.parse(data.getDate()).getTime());
			time1 = dateFormat.parse(data.getCheck_in_time());
			time2 = dateFormat.parse(data.getCheck_out_time());
			Calendar calendarDate = Calendar.getInstance();
			Calendar calendarTime1 = Calendar.getInstance();
			Calendar calendarTime2 = Calendar.getInstance();
			calendarDate.setTime(date);
			calendarTime1.setTime(time1);
			calendarTime2.setTime(time2);
			if (time2 != null && time1 != null) {
				long diff = time2.getTime() - time1.getTime();
				long second = diff / 1000 % 60;
				long minute = diff / (60 * 1000) % 60;
				long hour = diff / (60 * 60 * 1000) % 24;

				long totalMinute = hourToMinute(hour, minute, second);
				infoCheckIn = new CheckInTime(hour, minute, second, totalMinute);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoCheckIn;
	}

	public MinuteToHour hourWorkOneMonth(CheckInTime data) {
		MinuteToHour totalTime = null;

		if (data != null) {
			long hour = data.getHour();
			long minute = data.getMinute();
			long second = data.getSecond();
			long totalMinute = hourToMinute(hour, minute, second);

			long hh = (totalMinute / 60);
			long mm = (totalMinute % 60);
			long ss = (second % (60));
			totalTime = new MinuteToHour(minuteToHour(infoCheckIn.getTotalMinute() * 26), hh, mm, ss);

			System.out.println(totalTime.toString(hh, mm, ss));
		} else {
			return null;
		}

		return totalTime;
	}

	public static long workingDayActualOneMonth(long totalMinutes) {
		long totalDay = totalMinutes / (8 * 60);
		return totalDay;
	}

	public boolean compareDateForSalary() {
		java.util.Date date = new java.util.Date();

		Calendar calendarDateNow = Calendar.getInstance();
		calendarDateNow.setTime(date);
		calendarDateNow.add(Calendar.MONTH, +1);

		Calendar calendarStartSalary = Calendar.getInstance();
		calendarStartSalary.setTime(date);

		Calendar calendarEndSalary = Calendar.getInstance();
		calendarEndSalary.setTime(date);
		calendarEndSalary.add(Calendar.MONTH, +1);

		System.out.println("calendarDateNow: " + calendarDateNow.getTime());
		System.out.println("calendarEndSalary: " + calendarEndSalary.getTime());

		salaryInfo = new SalaryInfo();
		salaryInfo.setStart_date_salary(new SimpleDateFormat("yyyy-MM-dd").format(calendarStartSalary.getTime()));
		salaryInfo.setEnd_date_salary(new SimpleDateFormat("yyyy-MM-dd").format(calendarEndSalary.getTime()));
		System.out.println(salaryInfo.toString());

		if (calendarDateNow.get(Calendar.DAY_OF_MONTH) == DAY_FOR_SALARY) {
			return true;
		}
		return false;
	}

//	public long totalSalaryOneMonth() {
//		CheckInService serviceDFS = new CheckInService();
//		if (serviceDFS.compareDateForSalary()) {
//			String start = salaryInfo.getStart_date_salary();
//			String end = salaryInfo.getEnd_date_salary();
//
//			System.out.println("Salary your account is: \n");
//			
//		} else {
//			System.out.println("Waitting for salary on: " + salaryInfo.getEnd_date_salary());
//		}
//
//	}

	public long hourToMinute(long hour, long minute, long second) {
		long totalMinute = (hour * 60) + minute + (second / 60);
		System.out.println("hourToMinute function run: " + hour + ":" + minute + ":" + second);
		System.out.println("result totalMinute: " + totalMinute + "\n");
		return totalMinute;
	}

	public static MinuteToHour minuteToHour(long totalMinute) {
		MinuteToHour minuteToHour = new MinuteToHour();
		if (totalMinute != 0) {
			long hour = (totalMinute / 60);
			long minute = (totalMinute / (60 * 60));
			long second = (totalMinute % 60);

			minuteToHour.setHour(hour);
			minuteToHour.setMinute(minute);
			minuteToHour.setSecond(second);
			System.out.println(minuteToHour.toString(hour, minute, second));
		} else {
			System.out.println("minuteToHour is null");
			return null;
		}

		return minuteToHour;
	}

	public static void main(String[] args) {
//		CheckInGetAllResponse rs = new CheckInGetAllResponse();
//		rs.setCheck_in_time("08:30:00");
//		rs.setCheck_out_time("16:30:00");
//		rs.setDate("2019-12-09");
//		System.out.println(hourWorkOneDay(rs));
//		if (infoCheckIn.getHour() >= 8) {
//			System.out.println("30k an trua");
//		} else {
//			System.out.println("chua du thoi gian");
//		}

	}
}
