package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.account.AccountChangePasswordRequest;

public class AccountChangePassword extends AuthenticationAccount {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public void changePassword(AccountChangePasswordRequest request) {
		String sql = "UPDATE user_role SET password =? ,last_modifier_by =?  WHERE id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getPassword());
				pstm.setString(2, userAuthen.getUsername());
				pstm.setInt(3, userAuthen.getUser_role_id());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

	public String getPasswordAccount(AccountChangePasswordRequest request) {
		String sql = "select password from user_role where id=?";
		String password = "";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getUser_role_id());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					password = rs.getString("password");
				}
				System.out.println(password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return password;
	}

	public boolean isPasswordAccount(String password) {
		String currentPassword = getPasswordAccount(new AccountChangePasswordRequest(userAuthen.getUser_role_id()));
		if (currentPassword.equalsIgnoreCase(password)) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		AccountChangePassword main = new AccountChangePassword();
		main.getPasswordAccount(new AccountChangePasswordRequest(23));
	}
}
