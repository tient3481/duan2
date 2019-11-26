package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.department.DepartmentListGetAllResponse;

public class DepartmentListGetAll {

	private List<DepartmentListGetAllResponse> listDepartment;

	public List<DepartmentListGetAllResponse> get() {
		String sql = "SELECT * FROM department;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listDepartment = new ArrayList<DepartmentListGetAllResponse>();
				if (rs != null) {
					DepartmentListGetAllResponse objDpm = null;
					while (rs.next()) {
						objDpm = new DepartmentListGetAllResponse();
						objDpm.setId(rs.getInt("id"));
						objDpm.setName(rs.getString("name"));
						objDpm.setPhone(rs.getString("phone"));
						objDpm.setLocation(rs.getString("location"));

						listDepartment.add(objDpm);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listDepartment;
	}
}