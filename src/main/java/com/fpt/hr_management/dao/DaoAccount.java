package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.account.AccountAddRequest;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;
import com.fpt.hr_management.listener.request.account.AccountVerifyPasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountUpdateRequest;
import com.fpt.hr_management.listener.response.account.AccountInfoGetOneRespone;
import com.fpt.hr_management.listener.response.account.AccountRegisterEmployeeGetResponse;
import com.fpt.hr_management.listener.response.account.AccountRegisterRoleGetResponse;
import com.fpt.hr_management.model.account.Account;

public interface DaoAccount {

	public void login(AccountLoginRequest request);

	public void accountReset(AccountVerifyPasswordRequest request);

	public List<Account> accountListGetAll();

	public void accountAdd(AccountAddRequest request);

	public void accountUpdate(AccountUpdateRequest request);

	public void accountDelete(Integer accountId);

	public AccountInfoGetOneRespone accountGetOne(int employee_id);

	public List<AccountRegisterRoleGetResponse> getListRole();

	public List<AccountRegisterEmployeeGetResponse> getListEmployee();
}
