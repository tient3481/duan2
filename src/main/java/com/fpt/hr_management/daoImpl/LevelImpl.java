package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoLevel;
import com.fpt.hr_management.daoImpl.level.LevelAdd;
import com.fpt.hr_management.daoImpl.level.LevelDelete;
import com.fpt.hr_management.daoImpl.level.LevelListGetAll;
import com.fpt.hr_management.daoImpl.level.LevelListGetOne;
import com.fpt.hr_management.daoImpl.level.LevelUpdate;
import com.fpt.hr_management.listener.request.level.LevelAddRequest;
import com.fpt.hr_management.listener.request.level.LevelDeleteRequest;
import com.fpt.hr_management.listener.request.level.LevelListGetOneRequest;
import com.fpt.hr_management.listener.request.level.LevelUpdateRequest;
import com.fpt.hr_management.listener.response.level.LevelListGetAllResponse;
import com.fpt.hr_management.listener.response.level.LevelListGetOneResponse;

public class LevelImpl implements DaoLevel {

	public List<LevelListGetAllResponse> levelListGetAll() {
		LevelListGetAll service = new LevelListGetAll();
		return service.get();
	}

	public List<LevelListGetOneResponse> levelListGetOne(LevelListGetOneRequest request) {
		LevelListGetOne service = new LevelListGetOne();
		return service.getLevel(request);
	}

	public void levelAdd(LevelAddRequest request) {
		LevelAdd service = new LevelAdd();
		service.add(request);

	}

	public void levelUpdate(LevelUpdateRequest request) {
		LevelUpdate service = new LevelUpdate();
		service.update(request);
	}

	public void levelDelete(LevelDeleteRequest request) {
		LevelDelete service = new LevelDelete();
		service.delete(request);
	}

}
