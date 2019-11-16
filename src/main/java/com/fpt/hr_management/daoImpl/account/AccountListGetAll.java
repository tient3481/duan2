package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.model.account.Account;

public class AccountListGetAll extends AccountLogin {
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public List<Account> getListAccount() {
		List<Account> listAccount = null;
		String sql = "SELECT * FROM user_role; ";
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listAccount = new ArrayList<Account>();
				if (rs != null) {
					Account objAcc = null;
					while (rs.next()) {
						objAcc = new Account();
						objAcc.setId(rs.getInt("id"));
						objAcc.setRole_id(rs.getInt("role_id"));
						objAcc.setEmployee_id(rs.getInt("employee_id"));
						objAcc.setUsername(rs.getString("username"));
						objAcc.setPassword(rs.getString("password"));
						objAcc.setCreated_date(rs.getString("created_date"));
						objAcc.setCreated_by(rs.getString("created_by"));
						objAcc.setLast_modifier_date(rs.getString("last_modifier_date"));
						objAcc.setLast_modifier_by(rs.getString("last_modifier_by"));

						listAccount.add(objAcc);
					}
					System.out.println(listAccount.size());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}

		return listAccount;
	}

}
