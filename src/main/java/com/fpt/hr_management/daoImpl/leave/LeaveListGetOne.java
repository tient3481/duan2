package com.fpt.hr_management.daoImpl.leave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.leave.LeaveGetOneRequest;
import com.fpt.hr_management.listener.response.leave.LeaveEmployeeGetOneResponse;

public class LeaveListGetOne {
	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;

	/**
	 * @param request
	 * @param if      optionId == 1902 -> result idTable else result employee_id
	 *                param query
	 * @return
	 */
	public List<LeaveEmployeeGetOneResponse> info(LeaveGetOneRequest request, int optionId) {
		List<LeaveEmployeeGetOneResponse> list = new ArrayList<LeaveEmployeeGetOneResponse>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM employee_leave WHERE ");
		if (optionId == 1902) {
			sql.append("id = ?;");
		} else {
			sql.append("employee_id = ?");
		}
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql.toString());
				pstm.setInt(1, request.getIdRecord());
				ResultSet rs = pstm.executeQuery();
				LeaveEmployeeGetOneResponse employeeLeaveInfo = null;
				while (rs.next()) {
					employeeLeaveInfo = new LeaveEmployeeGetOneResponse();
					employeeLeaveInfo.setId(rs.getInt("id"));
					employeeLeaveInfo.setCreated_time(rs.getTimestamp("created_time"));
					employeeLeaveInfo.setEmployee_accept(rs.getString("employee_accept"));
					if (rs.getString("employee_accept") == null || rs.getString("employee_accept").length() == 0) {
						employeeLeaveInfo.setEmployee_accept("Đang chờ");
					}
					employeeLeaveInfo.setAccept_time(rs.getTimestamp("accept_time"));
					list.add(employeeLeaveInfo);
				}

				System.out.println(list.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return list;
	}

}
