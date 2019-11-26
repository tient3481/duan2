package com.fpt.hr_management.dao;

import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentAddRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentDeleteRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentUpdateRequest;

public interface DaoEmployeeDepartment {
	public void addEmployeeDepartment(EmployeeDepartmentAddRequest request);

	public void updateEmployeeDepartment(EmployeeDepartmentUpdateRequest request);

	public void deleteEmployeeDepartment(EmployeeDepartmentDeleteRequest request);
}
