package com.fpt.hr_management.listener.request.allowances;

import com.fpt.hr_management.listener.response.BaseRequest;

public class AllowanceAddRequest extends BaseRequest {
	private int salary_allowance_type_id;
	private long total_salary;
	private int employee_id;

	public AllowanceAddRequest() {

	}

	public AllowanceAddRequest(int salary_allowance_type_id, long total_salary, String created_by,
			String last_modifier_by, int employee_id) {

		this.salary_allowance_type_id = salary_allowance_type_id;
		this.total_salary = total_salary;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
		this.employee_id = employee_id;
	}

	public int getSalary_allowance_type_id() {
		return salary_allowance_type_id;
	}

	public void setSalary_allowance_type_id(int salary_allowance_type_id) {
		this.salary_allowance_type_id = salary_allowance_type_id;
	}

	public long getTotal_salary() {
		return total_salary;
	}

	public void setTotal_salary(long total_salary) {
		this.total_salary = total_salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AllowancesAddRequest [salary_allowance_type_id=").append(salary_allowance_type_id)
				.append(", total_salary=").append(total_salary).append(", employee_id=").append(employee_id)
				.append(", created_by=").append(created_by).append(", last_modifier_by=").append(last_modifier_by)
				.append("]");
		return builder.toString();
	}

}
