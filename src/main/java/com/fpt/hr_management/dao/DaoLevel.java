package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.level.LevelAddRequest;
import com.fpt.hr_management.listener.request.level.LevelDeleteRequest;
import com.fpt.hr_management.listener.request.level.LevelListGetOneRequest;
import com.fpt.hr_management.listener.request.level.LevelUpdateRequest;
import com.fpt.hr_management.listener.response.level.LevelListGetAllResponse;
import com.fpt.hr_management.listener.response.level.LevelListGetOneResponse;

public interface DaoLevel {

	public List<LevelListGetAllResponse> levelListGetAll();

	public List<LevelListGetOneResponse> levelListGetOne(LevelListGetOneRequest request);

	public void levelAdd(LevelAddRequest request);

	public void levelUpdate(LevelUpdateRequest request);

	public void levelDelete(LevelDeleteRequest request);
}
