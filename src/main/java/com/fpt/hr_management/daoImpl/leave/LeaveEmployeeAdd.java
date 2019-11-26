package com.fpt.hr_management.daoImpl.leave;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;

public class LeaveEmployeeAdd {

	private Connection con;
	private PreparedStatement pstm;

	public void add(LeaveAddRequest request) {
		String sql = "INSERT INTO employee_leave(employee_id, reason_id, start_date, end_date, start_time, end_time, accept_status, note, created_by, last_modifier_by) VALUES (?,?,?,?,?,?,?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setInt(2, request.getReason_id());
				pstm.setDate(3, request.getStart_date());
				pstm.setDate(4, request.getEnd_date());
				pstm.setTime(5, request.getStart_time());
				pstm.setTime(6, request.getEnd_time());
				pstm.setInt(7, 0);
				pstm.setString(8, request.getNote());
				pstm.setString(9, request.getCreated_by());
				pstm.setString(10, request.getLast_modifier_by());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

	public static void main(String[] args) {
		LeaveEmployeeAdd main = new LeaveEmployeeAdd();
		LeaveAddRequest request = new LeaveAddRequest();
		request.setEmployee_id(1);
		request.setReason_id(2);
		request.setStart_date(Date.valueOf("2019-05-05"));
		request.setReason_id(1);
		main.add(request);
	}
}