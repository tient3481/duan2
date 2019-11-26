package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.skill.SkillAddRequest;
import com.fpt.hr_management.listener.request.skill.SkillDeleteRequest;
import com.fpt.hr_management.listener.request.skill.SkillListGetOneRequest;
import com.fpt.hr_management.listener.request.skill.SkillUpdateRequest;
import com.fpt.hr_management.listener.response.skill.SkillListGetAllResponse;
import com.fpt.hr_management.listener.response.skill.SkillListGetOneResponse;

public interface DaoSkill {
	public List<SkillListGetAllResponse> listSkillGetAll();

	public List<SkillListGetOneResponse> listSkillGetOne(SkillListGetOneRequest request);

	public void addSkill(SkillAddRequest request);

	public void updateSkill(SkillUpdateRequest request);

	public void deleteSkill(SkillDeleteRequest request);
}
