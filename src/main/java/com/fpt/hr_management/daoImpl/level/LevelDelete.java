package com.fpt.hr_management.daoImpl.level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.level.LevelDeleteRequest;

public class LevelDelete {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public void delete(LevelDeleteRequest request) {
		String sql = "DELETE FROM level where id =?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

	}
}
