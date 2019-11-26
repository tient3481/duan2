package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoDepartment;
import com.fpt.hr_management.daoImpl.department.DepartmentAdd;
import com.fpt.hr_management.daoImpl.department.DepartmentDelete;
import com.fpt.hr_management.daoImpl.department.DepartmentGetOne;
import com.fpt.hr_management.daoImpl.department.DepartmentListGetAll;
import com.fpt.hr_management.daoImpl.department.DepartmentUpdate;
import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;
import com.fpt.hr_management.listener.request.department.DepartmentGetOneRequest;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;
import com.fpt.hr_management.listener.response.department.DepartmentGetOneResponse;
import com.fpt.hr_management.listener.response.department.DepartmentListGetAllResponse;

public class DepartmentImpl implements DaoDepartment {

	public List<DepartmentListGetAllResponse> departmentListGetAll() {
		DepartmentListGetAll service = new DepartmentListGetAll();
		return service.get();
	}

	public List<DepartmentGetOneResponse> departmentGetOne(DepartmentGetOneRequest request) {
		DepartmentGetOne service = new DepartmentGetOne();
		return service.getDepartment(request);
	}

	public void departmentAdd(DepartmentAddRequest request, int id) {
		DepartmentAdd service = new DepartmentAdd();
		service.add(request, id);
	}

	public void departmentUpdate(DepartmentUpdateRequest request) {
		DepartmentUpdate service = new DepartmentUpdate();
		service.update(request);
	}

	public void departmentDelete(int departmentId) {
		DepartmentDelete service = new DepartmentDelete();
		service.delete(departmentId);
	}

}
