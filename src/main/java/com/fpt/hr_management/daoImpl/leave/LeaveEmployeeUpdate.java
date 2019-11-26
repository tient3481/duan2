package com.fpt.hr_management.daoImpl.leave;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave.LeaveUpdateRequest;

public class LeaveEmployeeUpdate {

	public void update(LeaveUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "update employee_leave set employee_accept = ?, accept_status = ?, last_modifier_by = ? where id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getEmployee_accept());
				pstm.setInt(2, request.getAccept_status());
				pstm.setString(3, request.getLast_modifier_by());
				pstm.setInt(4, request.getIdRecord());
				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		LeaveEmployeeUpdate main = new LeaveEmployeeUpdate();
//		LeaveUpdateRequest request = new LeaveUpdateRequest();
//		request.setIdRecord(11);
//		request.setAccept_status(0);
//		main.update(request);
//	}
}
