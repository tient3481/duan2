package com.fpt.hr_management.listener.response.salary;

import java.sql.Date;

public class SalaryDisciplineResponse {
	private int id;
	private int employeeId;
	private String employeeName;
	private String disciplineName;
	private String disciplineDescription;
	private long disciplineSalary;
	private Date date;

	public SalaryDisciplineResponse() {

	}

	public SalaryDisciplineResponse(int id, int employeeId, String employeeName, String disciplineName,
			String disciplineDescription, long disciplineSalary, Date date) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.disciplineName = disciplineName;
		this.disciplineDescription = disciplineDescription;
		this.disciplineSalary = disciplineSalary;
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

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getDisciplineDescription() {
		return disciplineDescription;
	}

	public void setDisciplineDescription(String disciplineDescription) {
		this.disciplineDescription = disciplineDescription;
	}

	public long getDisciplineSalary() {
		return disciplineSalary;
	}

	public void setDisciplineSalary(long disciplineSalary) {
		this.disciplineSalary = disciplineSalary;
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
		builder.append("SalaryDisciplineResponse [id=").append(id).append(", employeeId=").append(employeeId)
				.append(", employeeName=").append(employeeName).append(", disciplineName=").append(disciplineName)
				.append(", disciplineDescription=").append(disciplineDescription).append(", disciplineSalary=")
				.append(disciplineSalary).append(", date=").append(date).append("]");
		return builder.toString();
	}

}
