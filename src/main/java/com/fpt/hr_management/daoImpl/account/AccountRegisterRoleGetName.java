package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.account.AccountRegisterGetRoleResponse;

public class AccountRegisterRoleGetName {
	private ResultSet rs;
	private Statement stm;
	private Connection con;
	private List<AccountRegisterGetRoleResponse> listRole = new ArrayList<AccountRegisterGetRoleResponse>();

	public List<AccountRegisterGetRoleResponse> getListRole() {
		AccountRegisterGetRoleResponse role = null;
		String sql = "SELECT id, name from role";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					role = new AccountRegisterGetRoleResponse();
					role.setRoleId(rs.getInt("id"));
					role.setRoleName(rs.getString("name"));

					listRole.add(role);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, null);
		}

		return listRole;
	}

}
