package com.fpt.hr_management.listener.response.account;

public class AccountRegisterRoleGetResponse {

	private int roleId;
	private String roleName;

	public AccountRegisterRoleGetResponse() {
	}

	public AccountRegisterRoleGetResponse(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountRegisterRoleGetResponse [roleId=").append(roleId).append(", roleName=").append(roleName)
				.append("]");
		return builder.toString();
	}

}
