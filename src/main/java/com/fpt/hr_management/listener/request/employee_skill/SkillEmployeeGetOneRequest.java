package com.fpt.hr_management.listener.request.employee_skill;

import com.fpt.hr_management.listener.response.BaseRequest;

public class SkillEmployeeGetOneRequest extends BaseRequest {
	private int optionId;

	public SkillEmployeeGetOneRequest() {
	}

	public SkillEmployeeGetOneRequest(int optionId) {
		this.optionId = optionId;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployeeGetOneRequest [optionId=").append(optionId).append("]");
		return builder.toString();
	}

}