package com.fpt.hr_management.daoImpl.leave_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeListGetOneRequest;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetOneResponse;

public class LeaveTypeListGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<LeaveTypeListGetOneResponse> listLevType;

	public List<LeaveTypeListGetOneResponse> get(LeaveTypeListGetOneRequest request) {
		LeaveTypeListGetOneResponse leaveTypeInfo = null;
		String sql = "select * from leave_reason_type where id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listLevType = new ArrayList<LeaveTypeListGetOneResponse>();
				while (rs.next()) {
					leaveTypeInfo = new LeaveTypeListGetOneResponse();
					leaveTypeInfo.setId(rs.getInt("id"));
					leaveTypeInfo.setName(rs.getString("name"));
					leaveTypeInfo.setCreated_date(rs.getString("created_date"));
					leaveTypeInfo.setCreated_by(rs.getString("created_by"));
					leaveTypeInfo.setLast_modifier_date(rs.getString("last_modifier_date"));
					leaveTypeInfo.setLast_modifier_by(rs.getString("last_modifier_by"));

					listLevType.add(leaveTypeInfo);
				}

				System.out.println(listLevType.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listLevType;
	}

	public static void main(String[] args) {
		LeaveTypeListGetOne main = new LeaveTypeListGetOne();
		main.get(new LeaveTypeListGetOneRequest(1));
	}
}
