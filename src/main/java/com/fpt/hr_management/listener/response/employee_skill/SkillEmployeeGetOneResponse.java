package com.fpt.hr_management.listener.response.employee_skill;

public class SkillEmployeeGetOneResponse {

	private int id;
	private String employeeName;
	private int employee_id;
	private int skill_id;
	private int skill_start;
	private int skill_end;
	private int level_id;
	private String levelName;
	private String skillName;

	private String skillEndName;
	private String skillStartName;

	public SkillEmployeeGetOneResponse() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillEndName() {
		return skillEndName;
	}

	public void setSkillEndName(String skillEndName) {
		this.skillEndName = skillEndName;
	}

	public String getSkillStartName() {
		return skillStartName;
	}

	public void setSkillStartName(String skillStartName) {
		this.skillStartName = skillStartName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillEmployeeGetOneResponse [id=").append(id).append(", employeeName=").append(employeeName)
				.append(", employee_id=").append(employee_id).append(", skill_id=").append(skill_id)
				.append(", skill_start=").append(skill_start).append(", skill_end=").append(skill_end)
				.append(", level_id=").append(level_id).append(", levelName=").append(levelName).append(", skillName=")
				.append(skillName).append(", skillEndName=").append(skillEndName).append(", skillStartName=")
				.append(skillStartName).append("]");
		return builder.toString();
	}

}