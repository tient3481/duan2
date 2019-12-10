package com.fpt.hr_management.daoImpl.leave_type;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeAddRequest;

public class LeaveTypeAdd {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void add(LeaveTypeAddRequest request) {
		String sql = "INSERT INTO leave_reason_type (name, note,created_by,last_modifier_by) VALUES (?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getNote());
				pstm.setString(3, request.getCreated_by());
				pstm.setString(4, request.getLast_modifier_by());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
