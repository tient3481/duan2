package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoCategoryLeave;
import com.fpt.hr_management.daoImpl.leave_type.LeaveTypeAdd;
import com.fpt.hr_management.daoImpl.leave_type.LeaveTypeDelete;
import com.fpt.hr_management.daoImpl.leave_type.LeaveTypeListGetAll;
import com.fpt.hr_management.daoImpl.leave_type.LeaveTypeListGetOne;
import com.fpt.hr_management.daoImpl.leave_type.LeaveTypeUpdate;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeAddRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeDeleteRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeListGetOneRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeUpdateRequest;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetAllResponse;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetOneResponse;

public class LeaveTypeImpl implements DaoCategoryLeave {

	public List<LeaveTypeListGetAllResponse> leaveTypeListGetAll() {
		return new LeaveTypeListGetAll().get();
	}

	public List<LeaveTypeListGetOneResponse> getOne(LeaveTypeListGetOneRequest request) {
		LeaveTypeListGetOne service = new LeaveTypeListGetOne();
		return service.get(request);
	}

	public void leaveTypeAdd(LeaveTypeAddRequest request) {
		LeaveTypeAdd service = new LeaveTypeAdd();
		service.add(request);
	}

	public void leaveTypeUpdate(LeaveTypeUpdateRequest request) {
		LeaveTypeUpdate service = new LeaveTypeUpdate();
		service.update(request);
	}

	public void leaveTypeDelete(LeaveTypeDeleteRequest request) {
		LeaveTypeDelete service = new LeaveTypeDelete();
		service.delete(request);
	}

}
