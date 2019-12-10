package com.fpt.hr_management.daoImpl.leave_type;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeDeleteRequest;

public class LeaveTypeDelete {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void delete(LeaveTypeDeleteRequest request) {
		String sql = "DELETE FROM leave_reason_type where id =?;";
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
			DbConnection.close(con, pstm, null, null);
		}

	}
}
