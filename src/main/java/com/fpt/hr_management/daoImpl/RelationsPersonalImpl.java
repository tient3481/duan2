package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoRelationsPersonal;
import com.fpt.hr_management.daoImpl.relations_personal.RPAdd;
import com.fpt.hr_management.daoImpl.relations_personal.RPDelete;
import com.fpt.hr_management.daoImpl.relations_personal.RPListGetOne;
import com.fpt.hr_management.daoImpl.relations_personal.RPUpdate;
import com.fpt.hr_management.listener.request.relations_personnal.RPAddRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPDeleteRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPGetOneRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPUpdateRequest;
import com.fpt.hr_management.listener.response.relations_personal.RPListGetOneResponse;

public class RelationsPersonalImpl implements DaoRelationsPersonal {

	public List<RPListGetOneResponse> listRP(RPGetOneRequest request) {
		RPListGetOne service = new RPListGetOne();
		return service.getInfoRPEmployee(request);
	}

	public void RPAdd(RPAddRequest request) {
		RPAdd service = new RPAdd();
		service.add(request);
	}

	public void RPDelete(RPDeleteRequest request) {
		RPDelete service = new RPDelete();
		service.delete(request);
	}

	public void RPUpdate(RPUpdateRequest request) {
		RPUpdate service = new RPUpdate();
		service.update(request);

	}

}