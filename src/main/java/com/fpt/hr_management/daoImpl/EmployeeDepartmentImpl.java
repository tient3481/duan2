package com.fpt.hr_management.daoImpl;

import com.fpt.hr_management.dao.DaoEmployeeDepartment;
import com.fpt.hr_management.daoImpl.employee_department.AddEmployeeDepartment;
import com.fpt.hr_management.daoImpl.employee_department.DeleteEmployeeDepartment;
import com.fpt.hr_management.daoImpl.employee_department.UpdateEmployeeDepartment;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentAddRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentDeleteRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentUpdateRequest;

public class EmployeeDepartmentImpl implements DaoEmployeeDepartment {

	public void addEmployeeDepartment(EmployeeDepartmentAddRequest request) {
		AddEmployeeDepartment service = new AddEmployeeDepartment();
		service.add(request);
	}

	public void updateEmployeeDepartment(EmployeeDepartmentUpdateRequest request) {
		UpdateEmployeeDepartment service = new UpdateEmployeeDepartment();
		service.update(request);
	}

	public void deleteEmployeeDepartment(EmployeeDepartmentDeleteRequest request) {
		DeleteEmployeeDepartment service = new DeleteEmployeeDepartment();
		service.delete(request);
	}

}
