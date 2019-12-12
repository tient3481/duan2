package com.fpt.hr_management.daoImpl.level;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.level.LevelUpdateRequest;

public class LevelUpdate {

	public void update(LevelUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE level SET name =? , note = ? WHERE id = ?;";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getNote());
				pstm.setInt(3, request.getId());

				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
