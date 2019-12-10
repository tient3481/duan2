package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.allowances.AllowanceAddRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceGetOneByEmployeeRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceUpdateRequest;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetAllResponse;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetOneByEmployeeResponse;

public interface DaoAllowances {

	public List<AllowanceGetAllResponse> allowancesGetAll();

	public List<AllowanceGetOneByEmployeeResponse> allowancesGetOne(AllowanceGetOneByEmployeeRequest request);

	public void allowancesAdd(AllowanceAddRequest request);

	public void allowancesUpdate(AllowanceUpdateRequest request);

}
