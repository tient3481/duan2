package com.fpt.hr_management.daoImpl.authentication;

public class AccountResetEntity {
	private String email;
	private int code;

	public AccountResetEntity() {

	}

	public AccountResetEntity(String email, int code) {
		this.email = email;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String getEmail() {
		return email;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResetPasswordAccount [email=").append(email).append(", code=").append(code).append("]");
		return builder.toString();
	}

}
