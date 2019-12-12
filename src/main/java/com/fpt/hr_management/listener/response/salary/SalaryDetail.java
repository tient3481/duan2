package com.fpt.hr_management.listener.response.salary;

import java.text.NumberFormat;

public class SalaryDetail {
	private int employeeId;
	private String employeeName;
	private long actualWorkDay;
	private long baseSalary;
	private long lunchMoney;
	private long phoneMoney;
	private long gasolineMoney;
	private long actualSalary;

	private String fromDate;
	private String toDate;

	public SalaryDetail() {

	}

	public SalaryDetail(int employeeId, String employeeName, long actualWorkDay, long baseSalary, long lunchMoney,
			long phoneMoney, long gasolineMoney, long actualSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.actualWorkDay = actualWorkDay;
		this.baseSalary = baseSalary;
		this.lunchMoney = lunchMoney;
		this.phoneMoney = phoneMoney;
		this.gasolineMoney = gasolineMoney;
		this.actualSalary = actualSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getActualWorkDay() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(actualWorkDay);
	}

	public void setActualWorkDay(long actualWorkDay) {
		this.actualWorkDay = actualWorkDay;
	}

	public String getBaseSalary() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(baseSalary);
	}

	public void setBaseSalary(long baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getLunchMoney() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(lunchMoney);
	}

	public void setLunchMoney(long lunchMoney) {
		this.lunchMoney = lunchMoney;
	}

	public String getPhoneMoney() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(phoneMoney);
	}

	public void setPhoneMoney(long phoneMoney) {
		this.phoneMoney = phoneMoney;
	}

	public String getGasolineMoney() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(gasolineMoney);
	}

	public void setGasolineMoney(long gasolineMoney) {
		this.gasolineMoney = gasolineMoney;
	}

	public String getActualSalary() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(actualSalary);
	}

	public void setActualSalary(long actualSalary) {
		this.actualSalary = actualSalary;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryDetail [employeeId=").append(employeeId).append(", employeeName=").append(employeeName)
				.append(", actualWorkDay=").append(actualWorkDay).append(", baseSalary=").append(baseSalary)
				.append(", lunchMoney=").append(lunchMoney).append(", phoneMoney=").append(phoneMoney)
				.append(", gasolineMoney=").append(gasolineMoney).append(", actualSalary=").append(actualSalary)
				.append("]");
		return builder.toString();
	}

}
