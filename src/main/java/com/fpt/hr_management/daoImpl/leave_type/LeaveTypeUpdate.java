package com.fpt.hr_management.daoImpl.leave_type;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeUpdateRequest;

public class LeaveTypeUpdate {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(LeaveTypeUpdateRequest request) {
		String sql = "UPDATE `hr_management`.`leave_reason_type` SET `name` = ?, `note` = ?, `last_modifier_by` = ? WHERE `id` = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getNote());
				pstm.setString(3, request.getLast_modifier_by());
				pstm.setInt(4, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
