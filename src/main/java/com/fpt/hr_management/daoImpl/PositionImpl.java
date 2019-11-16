package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoPosition;
import com.fpt.hr_management.daoImpl.department.DepartmentEmployeeGetOne;
import com.fpt.hr_management.daoImpl.position.PositionAdd;
import com.fpt.hr_management.daoImpl.position.PositionDelete;
import com.fpt.hr_management.daoImpl.position.PositionGetOne;
import com.fpt.hr_management.daoImpl.position.PositionListGetAll;
import com.fpt.hr_management.daoImpl.position.PositionUpdate;
import com.fpt.hr_management.listener.request.department.DepartmentEmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.position.PositionAddRequest;
import com.fpt.hr_management.listener.request.position.PositionUpdateRequest;
import com.fpt.hr_management.listener.response.department.DepartmentEmployeeGetOneResponse;
import com.fpt.hr_management.model.position.Position;

public class PositionImpl implements DaoPosition {

	public List<Position> positionListGetAll() {
		return new PositionListGetAll().get();
	}

	public void positionAdd(PositionAddRequest request) {
		PositionAdd service = new PositionAdd();
		service.add(request);
	}

	public void positionUpdate(PositionUpdateRequest request) {
		PositionUpdate service = new PositionUpdate();
		service.update(request);
	}

	public void positionDelete(int positionId) {
		PositionDelete service = new PositionDelete();
		service.delete(positionId);
	}

	public void positionInfoGetOne(int positionId) {
		PositionGetOne service = new PositionGetOne();
		service.info(positionId);
	}

	public List<DepartmentEmployeeGetOneResponse> departmentEmployeeGetOneResponse(
			DepartmentEmployeeGetOneRequest request) {
		DepartmentEmployeeGetOne service = new DepartmentEmployeeGetOne();
		return service.employeeDepartmentInfo(request);
	}

}
