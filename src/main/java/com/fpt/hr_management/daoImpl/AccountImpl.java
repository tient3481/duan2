package com.fpt.hr_management.daoImpl;

import java.util.List;

import com.fpt.hr_management.dao.DaoAccount;
import com.fpt.hr_management.daoImpl.account.AccountAdd;
import com.fpt.hr_management.daoImpl.account.AccountDelete;
import com.fpt.hr_management.daoImpl.account.AccountGetOne;
import com.fpt.hr_management.daoImpl.account.AccountListGetAll;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.daoImpl.account.AccountRegisterEmployeeGet;
import com.fpt.hr_management.daoImpl.account.AccountRegisterRoleGet;
import com.fpt.hr_management.daoImpl.account.AccountResetPassword;
import com.fpt.hr_management.daoImpl.account.AccountUpdate;
import com.fpt.hr_management.listener.request.account.AccountAddRequest;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;
import com.fpt.hr_management.listener.request.account.AccountVerifyPasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountUpdateRequest;
import com.fpt.hr_management.listener.response.account.AccountInfoGetOneRespone;
import com.fpt.hr_management.listener.response.account.AccountRegisterEmployeeGetResponse;
import com.fpt.hr_management.listener.response.account.AccountRegisterRoleGetResponse;
import com.fpt.hr_management.model.account.Account;

public class AccountImpl implements DaoAccount {

	public void login(AccountLoginRequest request) {
		AccountLogin service = new AccountLogin();
		service.login(request);
	}

	public void accountAdd(AccountAddRequest request) {
		AccountAdd service = new AccountAdd();
		service.add(request);
	}

	public void accountUpdate(AccountUpdateRequest request) {
		AccountUpdate service = new AccountUpdate();
		service.update(request);
	}

	public void accountDelete(Integer accountId) {
		AccountDelete service = new AccountDelete();
		service.delete(accountId);
	}

	public List<Account> accountListGetAll() {
		AccountListGetAll service = new AccountListGetAll();
		return service.getListAccount();
	}

	public AccountInfoGetOneRespone accountGetOne(int employeeId) {
		AccountGetOne service = new AccountGetOne();
		return service.info(employeeId);
	}

	public List<AccountRegisterRoleGetResponse> getListRole() {
		AccountRegisterRoleGet service = new AccountRegisterRoleGet();
		return service.getListRole();
	}

	public List<AccountRegisterEmployeeGetResponse> getListEmployee() {
		AccountRegisterEmployeeGet service = new AccountRegisterEmployeeGet();
		return service.getListEmployee();
	}

	public void accountReset(AccountVerifyPasswordRequest request) {
		AccountResetPassword service = new AccountResetPassword();
		service.resetPasswordAccount(request);

	}

}