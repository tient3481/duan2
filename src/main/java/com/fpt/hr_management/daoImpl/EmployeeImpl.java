package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoEmployee;
import com.fpt.hr_management.daoImpl.employee.EmployeeAdd;
import com.fpt.hr_management.daoImpl.employee.EmployeeDelete;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.daoImpl.employee.EmployeeListGetAll;
import com.fpt.hr_management.daoImpl.employee.EmployeeUpdate;
import com.fpt.hr_management.listener.request.employee.EmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeUpdateRequest;
import com.fpt.hr_management.listener.response.employee.EmployeeGetAllResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;

public class EmployeeImpl implements DaoEmployee {

	public void employeeAdd(EmployeeAddRequest request) {
		EmployeeAdd service = new EmployeeAdd();
		service.add(request);
	}

	public List<EmployeeGetAllResponse> employeeListGetAll() {
		EmployeeListGetAll service = new EmployeeListGetAll();
		return service.list();
	}

	public void employeeDelete(EmployeeDeleteRequest request) {
		EmployeeDelete service = new EmployeeDelete();
		service.delete(request);
	}

	public void employeeUpdate(EmployeeUpdateRequest request) {
		EmployeeUpdate service = new EmployeeUpdate();
		service.update(request);
	}

	public List<EmployeeGetOneResponse> employeeGetOne(EmployeeGetOneRequest request) {
		EmployeeGetOne service = new EmployeeGetOne();
		return service.getInfoEmployee(request);
	}

}
