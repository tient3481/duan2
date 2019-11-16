package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.account.AccountInfoGetOneRespone;

public class AccountGetOne {

	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;

	public AccountInfoGetOneRespone info(Integer employeeId) {
		AccountInfoGetOneRespone accountInfo = null;
		String sql = "SELECT e.full_name as employee_name, r.`name` as role_name from employee e LEFT JOIN user_role ur ON e.id = ur.employee_id LEFT JOIN role r ON r.id = ur.role_id WHERE e.id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employeeId);
				ResultSet rs = pstm.executeQuery();

				while (rs.next()) {
					accountInfo = new AccountInfoGetOneRespone();
					accountInfo.setEmployee_name(rs.getString("employee_name"));
					accountInfo.setRole_name(rs.getString("role_name"));
//					System.out.println(accountInfo.getEmployee_name() + " \t role: " + accountInfo.getRole_name());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return accountInfo;
	}

}
