package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoAllowances;
import com.fpt.hr_management.daoImpl.allowances.AllowanceAdd;
import com.fpt.hr_management.daoImpl.allowances.AllowanceGetAll;
import com.fpt.hr_management.daoImpl.allowances.AllowanceGetOneByEmployee;
import com.fpt.hr_management.daoImpl.allowances.AllowanceUpdate;
import com.fpt.hr_management.listener.request.allowances.AllowanceAddRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceGetOneByEmployeeRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceUpdateRequest;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetAllResponse;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetOneByEmployeeResponse;

public class AllowancesImpl implements DaoAllowances {

	public List<AllowanceGetAllResponse> allowancesGetAll() {
		return new AllowanceGetAll().getName();
	}
	
	public List<AllowanceGetOneByEmployeeResponse> allowancesGetOne(AllowanceGetOneByEmployeeRequest request) {
		return new AllowanceGetOneByEmployee().getOne(request);
	}

	public void allowancesAdd(AllowanceAddRequest request) {
		AllowanceAdd service = new AllowanceAdd();
		service.add(request);
	}

	public void allowancesUpdate(AllowanceUpdateRequest request) {
		AllowanceUpdate service = new AllowanceUpdate();
		service.update(request);
	}

}