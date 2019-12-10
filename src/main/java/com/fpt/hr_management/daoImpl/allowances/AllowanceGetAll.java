package com.fpt.hr_management.daoImpl.allowances;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetAllResponse;

public class AllowanceGetAll {

	private Connection con;
	private Statement stm;
	private ResultSet rs;

	public List<AllowanceGetAllResponse> getName() {
		String sql = "select sat.id as satId, sat.name as satName from salary_allowance_type sat;";
		List<AllowanceGetAllResponse> allowanceInfo = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				allowanceInfo = new ArrayList<AllowanceGetAllResponse>();
				if (rs != null) {
					AllowanceGetAllResponse objSat = null;
					while (rs.next()) {
						objSat = new AllowanceGetAllResponse();
						objSat.setSatId(rs.getInt("satId"));
						objSat.setSatName(rs.getString("satName"));
						allowanceInfo.add(objSat);
					}

					System.out.println(allowanceInfo.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return allowanceInfo;
	}

	public static void main(String[] args) {
		AllowanceGetAll main = new AllowanceGetAll();
		main.getName();
	}
}
