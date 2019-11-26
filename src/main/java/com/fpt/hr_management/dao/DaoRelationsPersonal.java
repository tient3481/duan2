package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.relations_personnal.RPAddRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPDeleteRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPGetOneRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPUpdateRequest;
import com.fpt.hr_management.listener.response.relations_personal.RPListGetOneResponse;

public interface DaoRelationsPersonal {
	public List<RPListGetOneResponse> listRP(RPGetOneRequest request);

	public void RPAdd(RPAddRequest request);

	public void RPDelete(RPDeleteRequest request);

	public void RPUpdate(RPUpdateRequest request);
}
