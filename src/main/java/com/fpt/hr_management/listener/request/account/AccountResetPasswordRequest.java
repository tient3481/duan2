package com.fpt.hr_management.listener.request.account;

import com.fpt.hr_management.listener.response.BaseRequest;

public class AccountResetPasswordRequest extends BaseRequest {
	private String email;
	private String password;

	public AccountResetPasswordRequest() {
		super();
	}

	public AccountResetPasswordRequest(String email, String password, String last_modifier_by) {
		super();
		this.email = email;
		this.password = password;
		this.last_modifier_by = last_modifier_by;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountResetPasswordRequest [email=").append(email).append(", password=").append(password)
				.append("]");
		return builder.toString();
	}

}
