package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fpt.hr_management.connection.DbConnection;

public class PositionValidator {
	private Connection con = null;
	private Statement stm = null;

	public int getSizeListPosition() {
		String sql = "SELECT COUNT(id) FROM position; ";
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
