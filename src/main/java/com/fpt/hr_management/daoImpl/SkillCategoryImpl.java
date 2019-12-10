package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoSkillCategory;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryAdd;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryDelete;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryListGetAll;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryListGetOne;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryUpdate;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryAddRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryDeleteRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryListGetOneRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryUpdateRequest;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetAllResponse;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetOneResponse;

public class SkillCategoryImpl implements DaoSkillCategory {

	public List<SkillCategoryListGetAllResponse> listSkillCategoryGetAll() {
		SkillCategoryListGetAll service = new SkillCategoryListGetAll();
		return service.get();
	}

	public List<SkillCategoryListGetOneResponse> listSkillCategoryGetOne(SkillCategoryListGetOneRequest request) {
		SkillCategoryListGetOne service = new SkillCategoryListGetOne();
		return service.get(request);
	}

	public void addSkillCategory(SkillCategoryAddRequest request) {
		SkillCategoryAdd service = new SkillCategoryAdd();
		service.add(request);

	}

	public void updateSkillCategory(SkillCategoryUpdateRequest request) {
		SkillCategoryUpdate service = new SkillCategoryUpdate();
		service.update(request);
	}

	public void deleteSkillCategory(SkillCategoryDeleteRequest request) {
		SkillCategoryDelete service = new SkillCategoryDelete();
		service.delete(request);
	}

}
