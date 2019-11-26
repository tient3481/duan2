package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.response.employee_type.EmployeeTypeResponse;

public interface DaoEmployeeType {
	public List<EmployeeTypeResponse> listEmployeeType();

	public void addEmployeeType();

	public void updateEmployeeType();
}
