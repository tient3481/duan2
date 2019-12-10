package com.fpt.hr_management.daoImpl.leave_type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetAllResponse;

public class LeaveTypeListGetAll {

	private List<LeaveTypeListGetAllResponse> listLeaveType;

	public List<LeaveTypeListGetAllResponse> get() {
		String sql = "select * from leave_reason_type;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listLeaveType = new ArrayList<LeaveTypeListGetAllResponse>();
				if (rs != null) {
					LeaveTypeListGetAllResponse leaveTypeInfo = null;
					while (rs.next()) {
						leaveTypeInfo = new LeaveTypeListGetAllResponse();
						leaveTypeInfo.setId(rs.getInt("id"));
						leaveTypeInfo.setName(rs.getString("name"));
						leaveTypeInfo.setNote(rs.getString("note"));
						leaveTypeInfo.setCreated_date(rs.getString("created_date"));
						leaveTypeInfo.setCreated_by(rs.getString("created_by"));
						leaveTypeInfo.setLast_modifier_date(rs.getString("last_modifier_date"));
						leaveTypeInfo.setLast_modifier_by(rs.getString("last_modifier_by"));

						listLeaveType.add(leaveTypeInfo);
					}

					System.out.println(listLeaveType.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listLeaveType;
	}

}