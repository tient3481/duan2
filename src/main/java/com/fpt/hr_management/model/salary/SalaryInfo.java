package com.fpt.hr_management.model.salary;

public class SalaryInfo {
	private String start_date_salary;
	private String end_date_salary;

	public SalaryInfo() {
	
	}

	public SalaryInfo(String start_date_salary, String end_date_salary) {
		this.start_date_salary = start_date_salary;
		this.end_date_salary = end_date_salary;
	}

	public String getStart_date_salary() {
		return start_date_salary;
	}

	public void setStart_date_salary(String start_date_salary) {
		this.start_date_salary = start_date_salary;
	}

	public String getEnd_date_salary() {
		return end_date_salary;
	}

	public void setEnd_date_salary(String end_date_salary) {
		this.end_date_salary = end_date_salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryInfo [start_date_salary=").append(start_date_salary).append(", end_date_salary=")
				.append(end_date_salary).append("]");
		return builder.toString();
	}

}
