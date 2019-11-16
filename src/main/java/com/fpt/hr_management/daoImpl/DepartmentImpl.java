package com.fpt.hr_management.daoImpl;

import com.fpt.hr_management.dao.DaoDepartment;
import com.fpt.hr_management.daoImpl.department.DepartmentAdd;
import com.fpt.hr_management.daoImpl.department.DepartmentDelete;
import com.fpt.hr_management.daoImpl.department.DepartmentGetOne;
import com.fpt.hr_management.daoImpl.department.DepartmentListGetAll;
import com.fpt.hr_management.daoImpl.department.DepartmentUpdate;
import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;

public class DepartmentImpl implements DaoDepartment {

	public void departmentListGetAll() {
		DepartmentListGetAll service = new DepartmentListGetAll();
		service.get();
	}

	public void departmentGetOne(int departmentId) {
		DepartmentGetOne service = new DepartmentGetOne();
		service.info(departmentId);
	}

	public void departmentAdd(DepartmentAddRequest request) {
		DepartmentAdd service = new DepartmentAdd();
		service.add(request);
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
