package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.checkin.CheckInAddRequest;
import com.fpt.hr_management.listener.request.checkin.CheckInDeleteRequest;
import com.fpt.hr_management.listener.request.checkin.CheckInUserRequest;
import com.fpt.hr_management.listener.request.checkin.CheckOutUpdateRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckInGetAllResponse;

public interface DaoCheckInOut {
	public List<CheckInGetAllResponse> listCheckIn(CheckInUserRequest request);

	public void addCheckIn(CheckInAddRequest request);

	public void deleteCheckIn(CheckInDeleteRequest request);

	public void updateCheckIn(CheckOutUpdateRequest request);
}
