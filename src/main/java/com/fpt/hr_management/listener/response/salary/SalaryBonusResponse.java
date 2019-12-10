package com.fpt.hr_management.listener.response.salary;

import java.sql.Date;

public class SalaryBonusResponse {
	private int id;
	private int employeeId;
	private String employeeName;
	private String bonusName;
	private String bonusDescription;
	private long bonusSalary;
	private Date date;

	public SalaryBonusResponse() {

	}

	public SalaryBonusResponse(int id, int employeeId, String employeeName, String bonusName, String bonusDescription,
			long bonusSalary, Date date) {
		this.id = id;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.bonusName = bonusName;
		this.bonusDescription = bonusDescription;
		this.bonusSalary = bonusSalary;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBonusName() {
		return bonusName;
	}

	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	public String getBonusDescription() {
		return bonusDescription;
	}

	public void setBonusDescription(String bonusDescription) {
		this.bonusDescription = bonusDescription;
	}

	public long getBonusSalary() {
		return bonusSalary;
	}

	public void setBonusSalary(long bonusSalary) {
		this.bonusSalary = bonusSalary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryBonusResponse [id=").append(id).append(", employeeId=").append(employeeId)
				.append(", employeeName=").append(employeeName).append(", bonusName=").append(bonusName)
				.append(", bonusDescription=").append(bonusDescription).append(", bonusSalary=").append(bonusSalary)
				.append(", date=").append(date).append("]");
		return builder.toString();
	}

}
