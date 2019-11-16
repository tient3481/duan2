package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.account.AccountResetPasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountUpdateRequest;

public class AccountUpdate {

	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(AccountUpdateRequest account) {
		String sql = "UPDATE user_role SET role_id =? , employee_id = ?, password =? ,last_modifier_by =?  WHERE id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, account.getRole_id());
				pstm.setInt(2, account.getEmployee_id());
				pstm.setString(3, account.getPassword());
				pstm.setString(4, account.getLast_modifier_by());
				pstm.setInt(5, account.getId());

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

	public void updatePasswordByEmail(AccountResetPasswordRequest request) {
		String sql = "UPDATE user_role ur, employee e SET ur.password = ?, ur.last_modifier_by = ? where e.id = ur.employee_id and e.email = ? ";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getPassword());
				pstm.setString(2, request.getLast_modifier_by());
				pstm.setString(3, request.getEmail());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		AccountUpdate main = new AccountUpdate();
//		AccountResetPasswordRequest request = new AccountResetPasswordRequest();
//		request.setEmail("anbvph06661@fpt.edu.vn");
//		request.setPassword("deptrai");
//		request.setLast_modifier_by("anbv");
//		main.updatePasswordByEmail(request);
//	}

}
