package com.fpt.hr_management.listener.response.allowances;

import java.text.NumberFormat;

public class AllowanceGetOneByEmployeeResponse {
	private int employeeId;
	private String employeeName;
	private int satId;
	private String satName;
	private String satDescription;
	private int saId;
	private long saTotalSalary;
	private int saTypeId;

	public AllowanceGetOneByEmployeeResponse() {

	}

	public AllowanceGetOneByEmployeeResponse(int employeeId, String employeeName, int satId, String satName,
			String satDescription, int saId, long saTotalSalary, int saTypeId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.satId = satId;
		this.satName = satName;
		this.satDescription = satDescription;
		this.saId = saId;
		this.saTotalSalary = saTotalSalary;
		this.saTypeId = saTypeId;
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

	public int getSatId() {
		return satId;
	}

	public void setSatId(int satId) {
		this.satId = satId;
	}

	public String getSatName() {
		return satName;
	}

	public void setSatName(String satName) {
		this.satName = satName;
	}

	public String getSatDescription() {
		return satDescription;
	}

	public void setSatDescription(String satDescription) {
		this.satDescription = satDescription;
	}

	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}

	public String getSaTotalSalary() {
		NumberFormat currentLocale = NumberFormat.getInstance();
		return currentLocale.format(saTotalSalary);
	}

	public void setSaTotalSalary(long saTotalSalary) {
		this.saTotalSalary = saTotalSalary;
	}

	public int getSaTypeId() {
		return saTypeId;
	}

	public void setSaTypeId(int saTypeId) {
		this.saTypeId = saTypeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AllowancesGetOneResponse [employeeId=").append(employeeId).append(", employeeName=")
				.append(employeeName).append(", satId=").append(satId).append(", satName=").append(satName)
				.append(", satDescription=").append(satDescription).append(", saId=").append(saId)
				.append(", saTotalSalary=").append(saTotalSalary).append(", saTypeId=").append(saTypeId).append("]");
		return builder.toString();
	}

}