package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.model.department.Department;

public class DepartmentListGetAll {

	public List<Department> get() {
		String sql = "SELECT * FROM department;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		List<Department> listDepartment = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listDepartment = new ArrayList<Department>();
				if (rs != null) {
					Department objDpm = null;
					while (rs.next()) {
						objDpm = new Department();
						objDpm.setId(rs.getInt("id"));
						objDpm.setName(rs.getString("name"));
						objDpm.setPhone(rs.getString("phone"));
						objDpm.setLocation(rs.getString("location"));
						objDpm.setCreated_date(rs.getString("created_date"));
						objDpm.setCreated_by(rs.getString("created_by"));
						objDpm.setLast_modifier_date(rs.getString("last_modifier_date"));
						objDpm.setLast_modifier_by(rs.getString("last_modifier_by"));

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