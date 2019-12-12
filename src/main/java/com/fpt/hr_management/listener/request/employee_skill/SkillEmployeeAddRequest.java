package com.fpt.hr_management.listener.request.employee_skill;

import com.fpt.hr_management.listener.response.BaseRequest;

public class SkillEmployeeAddRequest extends BaseRequest {
	private int employee_id;
	private int skill_id;
	private int skill_start;
	private int skill_end;
	private int level_id;
	

	public SkillEmployeeAddRequest() {

	}

	public SkillEmployeeAddRequest(int employee_id, int skill_id, int skill_start, int skill_end, int level_id,
			String created_by, String last_modifier_by) {
		this.employee_id = employee_id;
		this.skill_id = skill_id;
		this.skill_start = skill_start;
		this.skill_end = skill_end;
		this.level_id = level_id;
		this.created_by = created_by;
		this.last_modifier_by = last_modifier_by;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public int getSkill_start() {
		return skill_start;
	}

	public int getSkill_end() {
		return skill_end;
	}

	public int getLevel_id() {
		return level_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployeeAddRequest [employee_id=").append(employee_id).append(", skill_id=")
				.append(skill_id).append(", skill_start=").append(skill_start).append(", skill_end=").append(skill_end)
				.append(", level_id=").append(level_id).append("]");
		return builder.toString();
	}

}
