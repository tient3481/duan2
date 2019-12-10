package com.fpt.hr_management.listener.response.salary;

public class SalaryDetail {
	private int employeeId;
	private String employeeName;
	private long actualWorkDay;
	private long baseSalary;
	private long lunchMoney;
	private long phoneMoney;
	private long gasolineMoney;
	private long actualSalary;

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

	public long getActualWorkDay() {
		return actualWorkDay;
	}

	public void setActualWorkDay(long actualWorkDay) {
		this.actualWorkDay = actualWorkDay;
	}

	public long getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(long baseSalary) {
		this.baseSalary = baseSalary;
	}

	public long getLunchMoney() {
		return lunchMoney;
	}

	public void setLunchMoney(long lunchMoney) {
		this.lunchMoney = lunchMoney;
	}

	public long getPhoneMoney() {
		return phoneMoney;
	}

	public void setPhoneMoney(long phoneMoney) {
		this.phoneMoney = phoneMoney;
	}

	public long getGasolineMoney() {
		return gasolineMoney;
	}

	public void setGasolineMoney(long gasolineMoney) {
		this.gasolineMoney = gasolineMoney;
	}

	public long getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(long actualSalary) {
		this.actualSalary = actualSalary;
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
