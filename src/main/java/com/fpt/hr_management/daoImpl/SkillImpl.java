package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoSkill;
import com.fpt.hr_management.daoImpl.skill.SkillAdd;
import com.fpt.hr_management.daoImpl.skill.SkillDelete;
import com.fpt.hr_management.daoImpl.skill.SkillListGetAll;
import com.fpt.hr_management.daoImpl.skill.SkillListGetOne;
import com.fpt.hr_management.daoImpl.skill.SkillUpdate;
import com.fpt.hr_management.listener.request.skill.SkillAddRequest;
import com.fpt.hr_management.listener.request.skill.SkillDeleteRequest;
import com.fpt.hr_management.listener.request.skill.SkillListGetOneRequest;
import com.fpt.hr_management.listener.request.skill.SkillUpdateRequest;
import com.fpt.hr_management.listener.response.skill.SkillCategoryListGetAllResponse;
import com.fpt.hr_management.listener.response.skill.SkillListGetOneResponse;

public class SkillImpl implements DaoSkill {

	public List<SkillCategoryListGetAllResponse> listSkillGetAll() {
		SkillListGetAll service = new SkillListGetAll();
		return service.getCategorySkill();
	}

	public List<SkillListGetOneResponse> listSkillGetOne(SkillListGetOneRequest request) {
		SkillListGetOne service = new SkillListGetOne();
		return service.get(request);
	}

	public void addSkill(SkillAddRequest request) {
		SkillAdd service = new SkillAdd();
		service.add(request);
	}

	public void updateSkill(SkillUpdateRequest request) {
		SkillUpdate service = new SkillUpdate();
		service.update(request);
	}

	public void deleteSkill(SkillDeleteRequest request) {
		SkillDelete service = new SkillDelete();
		service.delete(request);
	}

}
