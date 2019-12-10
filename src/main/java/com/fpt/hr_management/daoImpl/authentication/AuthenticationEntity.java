package com.fpt.hr_management.daoImpl.authentication;

public class AuthenticationEntity {

	protected int user_role_id;
	protected int user_id;
	protected String username;
	protected String password;
	protected int roleId;
	protected String roleName;

	public AuthenticationEntity() {

	}

	public AuthenticationEntity(String username, String password, int roleId, String roleName) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public AuthenticationEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthenticationEntity [user_role_id=").append(user_role_id).append(", user_id=").append(user_id)
				.append(", username=").append(username).append(", password=").append(password).append(", roleId=")
				.append(roleId).append(", roleName=").append(roleName).append("]");
		return builder.toString();
	}

}