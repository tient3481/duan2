package com.fpt.hr_management.listener.request.employee_skill;

import com.fpt.hr_management.listener.response.BaseRequest;

public class SkillEmployeeUpdateRequest extends BaseRequest {
	private int id;
	private int skill_id;
	private int skill_start;
	private int skill_end;
	private int level_id;

	public SkillEmployeeUpdateRequest() {

	}

	public SkillEmployeeUpdateRequest(int id, int skill_id, int skill_start, int skill_end,
			int level_id, String last_modifier_by) {
		this.id = id;
		this.skill_id = skill_id;
		this.skill_start = skill_start;
		this.skill_end = skill_end;
		this.level_id = level_id;
		this.last_modifier_by = last_modifier_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public int getSkill_start() {
		return skill_start;
	}

	public void setSkill_start(int skill_start) {
		this.skill_start = skill_start;
	}

	public int getSkill_end() {
		return skill_end;
	}

	public void setSkill_end(int skill_end) {
		this.skill_end = skill_end;
	}

	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public String getLast_modifier_by() {
		return last_modifier_by;
	}

	public void setLast_modifier_by(String last_modifier_by) {
		this.last_modifier_by = last_modifier_by;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployeeUpdateRequest [id=").append(id).append(", skill_id=").append(skill_id)
				.append(", skill_start=").append(skill_start).append(", skill_end=").append(skill_end)
				.append(", level_id=").append(level_id).append("]");
		return builder.toString();
	}

}
