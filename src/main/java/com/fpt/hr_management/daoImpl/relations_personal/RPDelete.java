package com.fpt.hr_management.daoImpl.relations_personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.relations_personnal.RPDeleteRequest;

public class RPDelete {
	public void delete(RPDeleteRequest request) {
		String sql = "DELETE FROM relations_personal where id = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = DbConnection.getConnection();
			pstm = con.prepareStatement(sql);
			if (con != null && pstm != null && sql != null) {
				pstm.setInt(1, request.getId());
				int count = pstm.executeUpdate();
				if (count > 0) {
					return;
				} else {
					throw new SQLException();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

}
