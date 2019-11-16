package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.account.AccountRegisterEmployeeGetResponse;

public class AccountRegisterEmployeeGet {

	private ResultSet rs;
	private Statement stm;
	private Connection con;
	private List<AccountRegisterEmployeeGetResponse> listEmployee = new ArrayList<AccountRegisterEmployeeGetResponse>();

	public List<AccountRegisterEmployeeGetResponse> getListEmployee() {
		AccountRegisterEmployeeGetResponse employee = null;
		String sql = "SELECT id, full_name from employee";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					employee = new AccountRegisterEmployeeGetResponse();
					employee.setEmployeeId(rs.getInt("id"));
					employee.setEmployeeName(rs.getString("full_name"));

					listEmployee.add(employee);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, null);
		}

		return listEmployee;
	}

}
