package com.fpt.hr_management.daoImpl.allowances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.allowances.AllowanceGetOneRequest;
import com.fpt.hr_management.listener.response.allowances.AllowanceTypeGetOneResponse;

public class AllowanceGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public List<AllowanceTypeGetOneResponse> getOne(AllowanceGetOneRequest request) {
		List<AllowanceTypeGetOneResponse> list = new ArrayList<AllowanceTypeGetOneResponse>();
		String sql = "select sat.id as satId, sat.name as satName from salary_allowance_type sat where sat.id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				rs = pstm.executeQuery();
				AllowanceTypeGetOneResponse employeeAllowance = null;
				while (rs.next()) {
					employeeAllowance = new AllowanceTypeGetOneResponse();
					employeeAllowance.setSatId(rs.getInt("satId"));
					employeeAllowance.setSatName(rs.getString("satName"));
					list.add(employeeAllowance);
				}

				System.out.println(list.size());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return list;
	}

}
