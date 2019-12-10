package com.fpt.hr_management.listener.response.salary;

public class TotalSalaryInfoResponse {
	private String employeeName;
	private int employeeId;
	private long totalSalary;
	private int month;
	private long totalDay;
	private String allowanceName;
	private long totalSalaryAllowance;
	private String disciplineName;
	private long totalSalaryDiscipline;
	private String bonusName;
	private long totalSalaryBonus;

	public TotalSalaryInfoResponse() {

	}

	public TotalSalaryInfoResponse(String employeeName, int employeeId, long totalSalary, int month, long totalDay,
			String allowanceName, long totalSalaryAllowance, String disciplineName, long totalSalaryDiscipline,
			String bonusName, long totalSalaryBonus) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.totalSalary = totalSalary;
		this.month = month;
		this.totalDay = totalDay;
		this.allowanceName = allowanceName;
		this.totalSalaryAllowance = totalSalaryAllowance;
		this.disciplineName = disciplineName;
		this.totalSalaryDiscipline = totalSalaryDiscipline;
		this.bonusName = bonusName;
		this.totalSalaryBonus = totalSalaryBonus;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public long getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(long totalSalary) {
		this.totalSalary = totalSalary;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(long totalDay) {
		this.totalDay = totalDay;
	}

	public String getAllowanceName() {
		return allowanceName;
	}

	public void setAllowanceName(String allowanceName) {
		this.allowanceName = allowanceName;
	}

	public long getTotalSalaryAllowance() {
		return totalSalaryAllowance;
	}

	public void setTotalSalaryAllowance(long totalSalaryAllowance) {
		this.totalSalaryAllowance = totalSalaryAllowance;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public long getTotalSalaryDiscipline() {
		return totalSalaryDiscipline;
	}

	public void setTotalSalaryDiscipline(long totalSalaryDiscipline) {
		this.totalSalaryDiscipline = totalSalaryDiscipline;
	}

	public String getBonusName() {
		return bonusName;
	}

	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	public long getTotalSalaryBonus() {
		return totalSalaryBonus;
	}

	public void setTotalSalaryBonus(long totalSalaryBonus) {
		this.totalSalaryBonus = totalSalaryBonus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalSalaryInfo [employeeName=").append(employeeName).append(", employeeId=").append(employeeId)
				.append(", totalSalary=").append(totalSalary).append(", month=").append(month).append(", totalDay=")
				.append(totalDay).append(", allowanceName=").append(allowanceName).append(", totalSalaryAllowance=")
				.append(totalSalaryAllowance).append(", disciplineName=").append(disciplineName)
				.append(", totalSalaryDiscipline=").append(totalSalaryDiscipline).append(", bonusName=")
				.append(bonusName).append(", totalSalaryBonus=").append(totalSalaryBonus).append("]");
		return builder.toString();
	}

}
