package com.fpt.hr_management.listener.request.account;

public class AccountPasswordGetRequest {
	private int user_role_id;
	private String current_password;

	public AccountPasswordGetRequest() {

	}

	public AccountPasswordGetRequest(int user_role_id, String current_password) {
		this.user_role_id = user_role_id;
		this.current_password = current_password;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getCurrent_password() {
		return current_password;
	}

	public void setCurrent_password(String current_password) {
		this.current_password = current_password;
	}

}
