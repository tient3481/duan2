package com.fpt.hr_management.dao;

import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;

public interface DaoDepartment {

	public void departmentListGetAll();

	public void departmentGetOne(int departmentId);

	public void departmentAdd(DepartmentAddRequest request);

	public void departmentUpdate(DepartmentUpdateRequest request);

	public void departmentDelete(int departmentId);

}
