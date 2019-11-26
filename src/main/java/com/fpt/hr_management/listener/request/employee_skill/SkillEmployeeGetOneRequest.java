package com.fpt.hr_management.listener.request.employee_skill;

import com.fpt.hr_management.listener.response.BaseRequest;

public class SkillEmployeeGetOneRequest extends BaseRequest {
	private int employeeId;

	public SkillEmployeeGetOneRequest() {
	}

	public SkillEmployeeGetOneRequest(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployeeGetOneRequest [employeeId=").append(employeeId).append("]");
		return builder.toString();
	}

}