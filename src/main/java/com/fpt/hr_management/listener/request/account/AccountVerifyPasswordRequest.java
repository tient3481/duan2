package com.fpt.hr_management.listener.request.account;

public class AccountVerifyPasswordRequest {
	private String password;
	private String verifyPassword;

	public AccountVerifyPasswordRequest() {
		super();
	}

	public AccountVerifyPasswordRequest(String password, String verifyPassword) {
		super();
		this.password = password;
		this.verifyPassword = verifyPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountReset [password=").append(password).append(", verifyPassword=").append(verifyPassword)
				.append("]");
		return builder.toString();
	}

}
