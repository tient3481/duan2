package com.fpt.hr_management.listener.response.account;

public class AccountInfoGetOneRespone {
	private String employee_name;
	private String role_name;
	
	public AccountInfoGetOneRespone() {

	}

	public AccountInfoGetOneRespone(String employee_name, String role_name) {
		this.employee_name = employee_name;
		this.role_name = role_name;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountInfo [employee_name=").append(employee_name).append(", role_name=").append(role_name)
				.append("]");
		return builder.toString();
	}

}
