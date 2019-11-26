package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoEmployeeType;
import com.fpt.hr_management.daoImpl.employee_type.GetEmployeeType;
import com.fpt.hr_management.listener.response.employee_type.EmployeeTypeResponse;

public class EmployeeTypeImpl implements DaoEmployeeType{

	public List<EmployeeTypeResponse> listEmployeeType() {
		GetEmployeeType service = new GetEmployeeType();
		return service.getListEmployeeType();
	}

	public void addEmployeeType() {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployeeType() {
		// TODO Auto-generated method stub
		
	}
	
}