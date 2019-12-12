package com.fpt.hr_management.daoImpl;

import com.fpt.hr_management.dao.DaoEmployeeSkill;
import com.fpt.hr_management.daoImpl.employee_skill.SkillEmployeeAdd;
import com.fpt.hr_management.daoImpl.employee_skill.SkillEmployeeDelete;
import com.fpt.hr_management.daoImpl.employee_skill.SkillEmployeeUpdate;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeUpdateRequest;

public class EmployeeSkillImpl implements DaoEmployeeSkill {

	public void employeeSkillAdd(SkillEmployeeAddRequest request) {
		SkillEmployeeAdd service = new SkillEmployeeAdd();
		service.add(request);
	}

	public void employeeSkillUpdate(SkillEmployeeUpdateRequest request) {
		SkillEmployeeUpdate service = new SkillEmployeeUpdate();
		service.update(request);
	}

	public void employeeSkillDelete(SkillEmployeeDeleteRequest request) {
		SkillEmployeeDelete service = new SkillEmployeeDelete();
		service.delete(request);
	}

}
