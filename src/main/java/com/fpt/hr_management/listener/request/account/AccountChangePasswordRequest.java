package com.fpt.hr_management.listener.request.account;

public class AccountChangePasswordRequest {
	private int user_role_id;
	private String password;

	public AccountChangePasswordRequest() {

	}

	public AccountChangePasswordRequest(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public AccountChangePasswordRequest(int user_role_id, String password) {
		this.user_role_id = user_role_id;
		this.password = password;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
