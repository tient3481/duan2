package com.fpt.hr_management.model.skillemployee;

import com.fpt.hr_management.model.BaseEntity;

public class SkillEmployee extends BaseEntity {
	private int id;
	private int employee_id;
	private int skill_id;
	private String skill_main;
	private int skill_start;
	private int skill_end;
	private int level_id;

	public SkillEmployee() {
		super();
	}

	public SkillEmployee(int id, int employee_id, int skill_id, String skill_main, int skill_start, int skill_end,
			int level_id) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.skill_id = skill_id;
		this.skill_main = skill_main;
		this.skill_start = skill_start;
		this.skill_end = skill_end;
		this.level_id = level_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_main() {
		return skill_main;
	}

	public void setSkill_main(String skill_main) {
		this.skill_main = skill_main;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployee [id=").append(id).append(", employee_id=").append(employee_id)
				.append(", skill_id=").append(skill_id).append(", skill_main=").append(skill_main)
				.append(", skill_start=").append(skill_start).append(", skill_end=").append(skill_end)
				.append(", level_id=").append(level_id).append("]");
		return builder.toString();
	}

}