package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.employee.EmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeUpdateRequest;
import com.fpt.hr_management.listener.response.employee.EmployeeGetAllResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;

public interface DaoEmployee {

	public void employeeAdd(EmployeeAddRequest request);

	public List<EmployeeGetAllResponse> employeeListGetAll();

	public void employeeDelete(EmployeeDeleteRequest employeeId);

	public void employeeUpdate(EmployeeUpdateRequest employee);

	public List<EmployeeGetOneResponse> employeeGetOne(EmployeeGetOneRequest request);

}