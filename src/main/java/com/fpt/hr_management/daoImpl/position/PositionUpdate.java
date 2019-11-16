package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.position.PositionUpdateRequest;

public class PositionUpdate {

	public void update(PositionUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE position SET name =? , description = ?, last_modifier_by =? WHERE id = ?;";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setString(3, request.getLast_modifier_by());
				pstm.setInt(4, request.getId());

				int countRecord = pstm.executeUpdate();
				if (countRecord > 0) {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
	
	
}
