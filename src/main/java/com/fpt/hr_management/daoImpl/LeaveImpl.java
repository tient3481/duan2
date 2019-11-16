package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoLeave;
import com.fpt.hr_management.daoImpl.leave.LeaveAdd;
import com.fpt.hr_management.daoImpl.leave.LeaveListGetAll;
import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;
import com.fpt.hr_management.listener.request.leave.LeaveUpdateRequest;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

public class LeaveImpl implements DaoLeave {

	public void leaveAdd(LeaveAddRequest request) {
		LeaveAdd service = new LeaveAdd();
		service.add(request);
	}

	public void leaveUpdate(LeaveUpdateRequest request) {

	}

	public List<LeaveListGetAllResponse> leaveListGetAll() {
		LeaveListGetAll service = new LeaveListGetAll();
		return service.get();
	}

	public List<LeaveListGetAllResponse> getReasonName() {
		LeaveListGetAll service = new LeaveListGetAll();
		return service.getName();
	}

}
