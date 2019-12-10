package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.skill_category.SkillCategoryAddRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryDeleteRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryListGetOneRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryUpdateRequest;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetAllResponse;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetOneResponse;

public interface DaoSkillCategory {

	public List<SkillCategoryListGetAllResponse> listSkillCategoryGetAll();

	public List<SkillCategoryListGetOneResponse> listSkillCategoryGetOne(SkillCategoryListGetOneRequest request);

	public void addSkillCategory(SkillCategoryAddRequest request);

	public void updateSkillCategory(SkillCategoryUpdateRequest request);

	public void deleteSkillCategory(SkillCategoryDeleteRequest request);
}
