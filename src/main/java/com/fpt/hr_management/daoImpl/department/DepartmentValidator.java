package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fpt.hr_management.connection.DbConnection;

public class DepartmentValidator {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public boolean checkDepartmentName(String name) {
		String sql = "SELECT * FROM department where name = ?; ";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, name);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return false;
	}

	public int getSizeListDepartment() {
		String sql = "SELECT COUNT(id) FROM department; ";
		int countRecord = 0;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					countRecord = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countRecord;
	}

}
