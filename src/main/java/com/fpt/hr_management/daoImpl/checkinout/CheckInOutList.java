package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckInUserRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckInGetAllResponse;

public class CheckInOutList {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<CheckInGetAllResponse> listCheck = new ArrayList<CheckInGetAllResponse>();

	public List<CheckInGetAllResponse> listCheck(CheckInUserRequest request) {
		String sql = "select c.id, c.user_id, e.full_name as employee_name, c.check_in_time, c.check_out_time, c.date, c.total_time from employee e join check_in_history c on c.user_id = e.id where e.id =?;";
		CheckInGetAllResponse checkInOut;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				rs = pstm.executeQuery();
				while (rs.next()) {
					checkInOut = new CheckInGetAllResponse();
					checkInOut.setId(rs.getInt("id"));
					checkInOut.setUser_id(rs.getInt("user_id"));
					checkInOut.setEmployee_name(rs.getString("employee_name"));
					checkInOut.setCheck_in_time(rs.getString("check_in_time"));
					checkInOut.setCheck_out_time(rs.getString("check_out_time"));
					checkInOut.setTotal_time(rs.getString("total_time"));
					checkInOut.setDate(rs.getString("date"));

					listCheck.add(checkInOut);
				}

				System.out.println(listCheck.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listCheck;
	}

	public static void main(String[] args) {
		CheckInOutList main = new CheckInOutList();
		CheckInUserRequest request = new CheckInUserRequest();
		request.setId(1);
		main.listCheck(request);
	}
}
