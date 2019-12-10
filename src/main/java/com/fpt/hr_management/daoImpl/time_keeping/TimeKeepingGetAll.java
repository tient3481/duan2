package com.fpt.hr_management.daoImpl.time_keeping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.TimeKeeping.TimeKeepingGetAllRequest;
import com.fpt.hr_management.listener.response.time_keeping.TimeKeepingGetAllResponse;

public class TimeKeepingGetAll {
	private Connection con;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	private int keyGenerte = 0;
	private List<TimeKeepingGetAllResponse> listCheck;

	public boolean timeKeeping(TimeKeepingGetAllRequest request) {

		String sql = "select e.id as employeeId, e.full_name as employeeName,"
				+ " MIN(ci.check_in_time) as checkInFirst,"
				+ " MAX(ci.check_out_time) as checkOutLast, ci.date as date " + " from check_in_history ci"
				+ " LEFT JOIN employee e on e.id = ci.user_id" + " where user_id = ?" + " and ci.date = ?"
				+ " group by e.full_name;";
		TimeKeepingGetAllResponse checkInOut = null;
		String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				pstm.setString(2, dateNow);
				rs = pstm.executeQuery();
				listCheck = new ArrayList<TimeKeepingGetAllResponse>();
				while (rs.next()) {
					checkInOut = new TimeKeepingGetAllResponse();
					checkInOut.setEmployeeId(rs.getInt("employeeId"));
					checkInOut.setEmployeeName(rs.getString("employeeName"));
					checkInOut.setCheckInFirst(rs.getString("checkInFirst"));
					checkInOut.setCheckOutLast(rs.getString("checkOutLast"));
					checkInOut.setDate(rs.getString("date"));

					listCheck.add(checkInOut);
					if (!isChecked()) {
						addTimeKeeping(); // generate key from database
						getTotalTime();// using: keyGenerate from addTimeKeeping function
						updateTotalTime();
						updateLunch(1, getDateNow());
						return true;
					} else {
						updateLunch(0, getDateNow());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return false;
	}

	public String getDateNow() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = sdf.format(date);
		return dateNow;
	}

	public void updateLunch(int approved, String date) throws Exception {
		String sql = "UPDATE `hr_management`.`holiday_info` SET `lunch` = ? where `date` = '" + date + "';";

		if (approved == 1) {
			try {
				con = DbConnection.getConnection();
				if (con != null) {
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, 1);

					pstm.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbConnection.close(con, pstm, null, rs);
			}
		}

		if (approved == 0) {
			try {
				con = DbConnection.getConnection();
				if (con != null) {
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, 0);

					pstm.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbConnection.close(con, pstm, null, rs);
			}
		}
	}

	public void addTimeKeeping() {
		for (int i = 0; i < listCheck.size(); i++) {
			String sqlAdd = "INSERT INTO `hr_management`.`last_checkin`(`check_in_first`, `check_out_last`, `employee_id`, `date`) VALUES (?,?,?,?);";
			try {
				pstm = con.prepareStatement(sqlAdd, Statement.RETURN_GENERATED_KEYS);
				pstm.setString(1, listCheck.get(i).getCheckInFirst());
				pstm.setString(2, listCheck.get(i).getCheckOutLast());
				pstm.setInt(3, listCheck.get(i).getEmployeeId());
				pstm.setString(4, listCheck.get(i).getDate());
				pstm.executeUpdate();

				ResultSet rs = pstm.getGeneratedKeys();
				while (rs.next()) {
					keyGenerte = rs.getInt(1);
				}

				getTotalTime();
				updateTotalTime();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getTotalTime() {
		String total_time = "";
		String sql = "SELECT SUBTIME(lc.check_out_last, lc.check_in_first) as total_time from last_checkin lc WHERE lc.id = "
				+ keyGenerte;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					total_time = rs.getString("total_time");
				}

				System.out.println(total_time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("total_time: " + total_time);
		return total_time;
	}

	public void updateTotalTime() {
		String sql = "UPDATE `hr_management`.`last_checkin` SET `total_time` = ? WHERE `id` = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, getTotalTime());
				pstm.setInt(2, keyGenerte);

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

	public List<TimeKeepingGetAllResponse> getInfoLastCheckIn(TimeKeepingGetAllRequest request) {
		List<TimeKeepingGetAllResponse> listTimeKeepingInfo = null;
		String sql = "select e.id as employeeId, e.full_name as employeeName,"
				+ " lc.check_in_first as checkInFirst, lc.check_out_last as checkOutLast,"
				+ " lc.total_time as totalTime, lc.date as date" + " from employee e"
				+ " left join last_checkin lc on lc.employee_id = e.id" + " where lc.employee_id = ?;";
		TimeKeepingGetAllResponse infoTimeKeepingRes;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				rs = pstm.executeQuery();
				listTimeKeepingInfo = new ArrayList<TimeKeepingGetAllResponse>();
				while (rs.next()) {
					infoTimeKeepingRes = new TimeKeepingGetAllResponse();
					infoTimeKeepingRes.setEmployeeId(rs.getInt("employeeId"));
					infoTimeKeepingRes.setEmployeeName(rs.getString("employeeName"));
					infoTimeKeepingRes.setCheckInFirst(rs.getString("checkInFirst"));
					infoTimeKeepingRes.setCheckOutLast(rs.getString("checkOutLast"));
					infoTimeKeepingRes.setTotalTime(rs.getString("totalTime"));
					infoTimeKeepingRes.setDate(rs.getString("date"));

					listTimeKeepingInfo.add(infoTimeKeepingRes);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listTimeKeepingInfo;
	}

	public boolean isChecked() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = formatter.format(date);
		String sql = "SELECT * FROM last_checkin where date = '" + dateFormat + "';";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean isLastDate(int dateConfig) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (cal.get(Calendar.HOUR_OF_DAY) == dateConfig) {
			return true;
		}
		return false;
	}

}
