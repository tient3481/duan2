package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.account.AccountAddRequest;

public class AccountAdd {

	public void add(AccountAddRequest account) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO user_role (role_id, employee_id,username,password,created_by,last_modifier_by) VALUES (?,?,?,?,?,?);";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, account.getRole_id());
				pstm.setInt(2, account.getEmployee_id());
				pstm.setString(3, account.getUsername());
				pstm.setString(4, account.getPassword());
				pstm.setString(5, account.getCreated_by());
				pstm.setString(6, account.getLast_modifier_by());

				int countRecord = pstm.executeUpdate();
				if (countRecord > 0) {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		AddAccount account = new AddAccount();
//		account.add(new Account(1, 1, "khiemnh", "admin", "anbv", "anbv"));
//	}
}
