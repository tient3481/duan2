package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.department.DepartmentGetNameAndIdResponse;

public class DepartmentGetNameAndId {
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private List<DepartmentGetNameAndIdResponse> listDepartment;

	public List<DepartmentGetNameAndIdResponse> listDepartment() {
		DepartmentGetNameAndIdResponse departmentInfo = null;
		String sql = "SELECT id, name FROM department";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				listDepartment = new ArrayList<DepartmentGetNameAndIdResponse>();
				while (rs.next()) {
					departmentInfo = new DepartmentGetNameAndIdResponse();
					departmentInfo.setId(rs.getInt("id"));
					departmentInfo.setName(rs.getString("name"));
					listDepartment.add(departmentInfo);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}

		return listDepartment;
	}

	public static void main(String[] args) {
		DepartmentGetNameAndId main = new DepartmentGetNameAndId();
		main.listDepartment();
	}
}
