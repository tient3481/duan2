package com.fpt.hr_management.listener.request.employee_department;

import com.fpt.hr_management.listener.response.BaseRequest;

public class EmployeeDepartmentAddRequest extends BaseRequest {
	private int employee_id;
	private int employee_type_id;
	private int department_id;
	private int position_id;

	public EmployeeDepartmentAddRequest() {

	}

	public EmployeeDepartmentAddRequest(int employee_id, int employee_type_id, int department_id, int position_id) {
		super();
		this.employee_id = employee_id;
		this.employee_type_id = employee_type_id;
		this.department_id = department_id;
		this.position_id = position_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getEmployee_type_id() {
		return employee_type_id;
	}

	public void setEmployee_type_id(int employee_type_id) {
		this.employee_type_id = employee_type_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDepartmentAddRequest [employee_id=").append(employee_id).append(", employee_type_id=")
				.append(employee_type_id).append(", department_id=").append(department_id).append(", position_id=")
				.append(position_id).append("]");
		return builder.toString();
	}

}