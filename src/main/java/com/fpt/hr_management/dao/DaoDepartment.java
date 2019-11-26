package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;
import com.fpt.hr_management.listener.request.department.DepartmentGetOneRequest;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;
import com.fpt.hr_management.listener.response.department.DepartmentGetOneResponse;
import com.fpt.hr_management.listener.response.department.DepartmentListGetAllResponse;

public interface DaoDepartment {

	public List<DepartmentListGetAllResponse> departmentListGetAll();

	public List<DepartmentGetOneResponse> departmentGetOne(DepartmentGetOneRequest request);

	public void departmentAdd(DepartmentAddRequest request, int id);

	public void departmentUpdate(DepartmentUpdateRequest request);

	public void departmentDelete(int departmentId);

}
