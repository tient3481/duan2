package com.fpt.hr_management.dao;

import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeUpdateRequest;

public interface DaoEmployeeSkill {

	public void employeeSkillAdd(SkillEmployeeAddRequest request);

	public void employeeSkillUpdate(SkillEmployeeUpdateRequest request);

	public void employeeSkillDelete(SkillEmployeeDeleteRequest request);
}
