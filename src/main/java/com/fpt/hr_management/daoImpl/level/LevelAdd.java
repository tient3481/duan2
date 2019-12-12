package com.fpt.hr_management.daoImpl.level;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.level.LevelAddRequest;

public class LevelAdd {

	public void add(LevelAddRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO level (name, note) VALUES (?,?);";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getNote());

				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
