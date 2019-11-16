package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;
import com.fpt.hr_management.listener.request.leave.LeaveUpdateRequest;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

public interface DaoLeave {
	
	public List<LeaveListGetAllResponse> leaveListGetAll();
	
	public void leaveAdd(LeaveAddRequest request);

	public void leaveUpdate(LeaveUpdateRequest request);
	
	public List<LeaveListGetAllResponse> getReasonName();
}
