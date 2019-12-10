package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckOutGetTimeRequest;
import com.fpt.hr_management.listener.request.checkin.CheckOutUpdateRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckOutGetTimeResponse;

public class CheckOutUpdate {

	private static PreparedStatement pstm;
	private static Connection con;
	private static ResultSet rs = null;
	private static CheckOutGetTimeResponse responseTime;
	private static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public void checkOut(CheckOutUpdateRequest request) {
		String sql = "UPDATE check_in_history set check_out_time = NOW() where id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				pstm.executeUpdate();
				getTimeCheckOut(new CheckOutGetTimeRequest(request.getId()));
			} else {
				System.out.println("checkOut không thể kết nối.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}

	}

	private static CheckOutGetTimeResponse getTimeCheckOut(CheckOutGetTimeRequest request) {
		String sql = "select * from check_in_history where id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					responseTime = new CheckOutGetTimeResponse();
					responseTime.setCheck_in_time(rs.getString("check_in_time"));
					responseTime.setCheck_out_time(rs.getString("check_out_time"));
				}

				System.out.println(responseTime.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return responseTime;
	}

	public static java.sql.Time getCurrentJavaSqlTime() {
		java.util.Date date = new java.util.Date();
		return new java.sql.Time(date.getTime());
	}

	public void checkOutUpdateTotalTime(CheckOutGetTimeRequest request) {
		Date timeCheckIn = null;
		Date timeCheckOut = null;
		String checkIn = responseTime.getCheck_in_time();
		String checkOut = responseTime.getCheck_out_time();
		try {
			timeCheckIn = dateFormat.parse(checkIn);
			timeCheckOut = dateFormat.parse(checkOut);
			dateFormat.parse(checkIn);
			dateFormat.parse(checkOut);

		} catch (Exception e) {
			e.printStackTrace();
		}
		long diff = timeCheckOut.getTime() - timeCheckIn.getTime();
		long second = diff / 1000;
		long minute = diff / (60 * 1000);
		long hour = diff / (60 * 60 * 1000);

		@SuppressWarnings("deprecation")
		Time totalTime = new Time((int) (long) hour, (int) (long) minute, (int) (long) second);
		try {
			String sql = "UPDATE check_in_history set total_time = ? where id = ?;";
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setTime(1, totalTime);
				pstm.setInt(2, request.getId());
				pstm.executeUpdate();
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

}
