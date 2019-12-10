package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.leave_type.LeaveTypeAddRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeDeleteRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeListGetOneRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeUpdateRequest;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetAllResponse;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetOneResponse;

public interface DaoCategoryLeave {

	public List<LeaveTypeListGetAllResponse> leaveTypeListGetAll();

	public List<LeaveTypeListGetOneResponse> getOne(LeaveTypeListGetOneRequest request);

	public void leaveTypeAdd(LeaveTypeAddRequest request);

	public void leaveTypeUpdate(LeaveTypeUpdateRequest request);

	public void leaveTypeDelete(LeaveTypeDeleteRequest request);

}
