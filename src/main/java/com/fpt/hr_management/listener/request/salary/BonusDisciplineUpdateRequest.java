package com.fpt.hr_management.listener.request.salary;

public class BonusDisciplineUpdateRequest {
	private int employeeId;
	private int salary_bonus_id;
	private int salary_discipline_id;

	public BonusDisciplineUpdateRequest() {

	}

	public BonusDisciplineUpdateRequest(int employeeId, int salary_bonus_id, int salary_discipline_id) {
		this.employeeId = employeeId;
		this.salary_bonus_id = salary_bonus_id;
		this.salary_discipline_id = salary_discipline_id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSalary_bonus_id() {
		return salary_bonus_id;
	}

	public void setSalary_bonus_id(int salary_bonus_id) {
		this.salary_bonus_id = salary_bonus_id;
	}

	public int getSalary_discipline_id() {
		return salary_discipline_id;
	}

	public void setSalary_discipline_id(int salary_discipline_id) {
		this.salary_discipline_id = salary_discipline_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BonusDisciplineUpdateRequest [employeeId=").append(employeeId).append(", salary_bonus_id=")
				.append(salary_bonus_id).append(", salary_discipline_id=").append(salary_discipline_id).append("]");
		return builder.toString();
	}

}
