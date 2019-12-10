package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationEntity;
import com.fpt.hr_management.daoImpl.authentication.BasePermission;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;

public class AccountLogin extends BasePermission {

	public static AuthenticationEntity userAuthen = new AuthenticationEntity();
	public static HashMap<Integer, AuthenticationEntity> hmAccountPermission = new HashMap<Integer, AuthenticationEntity>();

	public boolean login(AccountLoginRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select ur.id, e.id as user_id, r.id as role_id, r.name as role_name, ur.username, ur.`password` from employee e JOIN user_role ur on ur.employee_id = e.id JOIN role r on r.id = ur.role_id where username =? and password = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getUsername());
				pstm.setString(2, request.getPassword());
				rs = pstm.executeQuery();
				while (rs.next()) {
					userAuthen.setUser_role_id(rs.getInt("id"));
					userAuthen.setUser_id(rs.getInt("user_id"));
					userAuthen.setRoleId(rs.getInt("role_id"));
					userAuthen.setRoleName(rs.getString("role_name"));
					userAuthen.setUsername(rs.getString("username"));
					userAuthen.setPassword(rs.getString("password"));
					return true;
				}

			} else {
				System.out.println("AccountLogin can't connect to MySQL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return false;
	}

	public AuthenticationEntity authenAccount() {
		return userAuthen;
	}

}
