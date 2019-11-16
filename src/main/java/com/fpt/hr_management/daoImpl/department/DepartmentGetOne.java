package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.department.DepartmentGetOneResponse;

public class DepartmentGetOne {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public DepartmentGetOneResponse info(int departmentId) {
		DepartmentGetOneResponse departmentInfo = null;
		String sql = "SELECT * FROM department WHERE id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, departmentId);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					departmentInfo = new DepartmentGetOneResponse();
					departmentInfo.setName(rs.getString("name"));
					departmentInfo.setPhone(rs.getString("phone"));
					departmentInfo.setLocation(rs.getString("location"));
				}
				System.out.println(departmentInfo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return departmentInfo;
	}

	public static void main(String[] args) {
		DepartmentGetOne main = new DepartmentGetOne();
		main.info(2525);
	}
}
