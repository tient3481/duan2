package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoLeave;
import com.fpt.hr_management.daoImpl.leave.LeaveEmployeeAdd;
import com.fpt.hr_management.daoImpl.leave.LeaveEmployeeListGetAll;
import com.fpt.hr_management.daoImpl.leave.LeaveEmployeeUpdate;
import com.fpt.hr_management.daoImpl.leave.LeaveListGetOne;
import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;
import com.fpt.hr_management.listener.request.leave.LeaveGetOneRequest;
import com.fpt.hr_management.listener.request.leave.LeaveUpdateRequest;
import com.fpt.hr_management.listener.response.leave.LeaveEmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

public class LeaveImpl implements DaoLeave {

	public void leaveAdd(LeaveAddRequest request) {
		LeaveEmployeeAdd service = new LeaveEmployeeAdd();
		service.add(request);
	}

	public void leaveUpdate(LeaveUpdateRequest request) {
		LeaveEmployeeUpdate service = new LeaveEmployeeUpdate();
		service.update(request);
	}

	public List<LeaveListGetAllResponse> leaveListGetAll() {
		LeaveEmployeeListGetAll service = new LeaveEmployeeListGetAll();
		return service.get();
	}

	public List<LeaveListGetAllResponse> getReasonName() {
		LeaveEmployeeListGetAll service = new LeaveEmployeeListGetAll();
		return service.getName();
	}

	public List<LeaveEmployeeGetOneResponse> getOne(LeaveGetOneRequest request) {
		LeaveListGetOne service = new LeaveListGetOne();
		return service.info(request);
	}

}
