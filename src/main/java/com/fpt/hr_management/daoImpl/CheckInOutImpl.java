package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoCheckInOut;
import com.fpt.hr_management.daoImpl.checkinout.CheckInAdd;
import com.fpt.hr_management.daoImpl.checkinout.CheckInDelete;
import com.fpt.hr_management.daoImpl.checkinout.CheckInOutList;
import com.fpt.hr_management.daoImpl.checkinout.CheckOutUpdate;
import com.fpt.hr_management.listener.request.checkin.CheckInAddRequest;
import com.fpt.hr_management.listener.request.checkin.CheckInDeleteRequest;
import com.fpt.hr_management.listener.request.checkin.CheckInUserRequest;
import com.fpt.hr_management.listener.request.checkin.CheckOutGetTimeRequest;
import com.fpt.hr_management.listener.request.checkin.CheckOutUpdateRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckInGetAllResponse;

public class CheckInOutImpl implements DaoCheckInOut {

	public List<CheckInGetAllResponse> listCheckIn(CheckInUserRequest request) {
		CheckInOutList service = new CheckInOutList();
		return service.listCheck(request);
	}

	public void addCheckIn(CheckInAddRequest request) {
		CheckInAdd service = new CheckInAdd();
		service.addCheckIn(request);
	}

	public void deleteCheckIn(CheckInDeleteRequest request) {
		CheckInDelete service = new CheckInDelete();
		service.delete(request);
	}

	public void updateCheckIn(CheckOutUpdateRequest request) {
		CheckOutUpdate service = new CheckOutUpdate();
		service.checkOut(request);
		service.checkOutUpdateTotalTime(new CheckOutGetTimeRequest(request.getId()));
	}

}
