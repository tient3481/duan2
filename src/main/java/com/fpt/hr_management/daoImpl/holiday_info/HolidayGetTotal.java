package com.fpt.hr_management.daoImpl.holiday_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;

public class HolidayGetTotal {

	private Connection con;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private java.sql.Statement stm = null;

	/**
	 * @param fromDate
	 * @param toDate
	 * @param total_holiday_type: 0 is not accept and 1 is accept leave employee
	 * @param employee_id
	 * @return total holiday by holiday_type
	 */
	public int holidayGetTotal(String fromDate, String toDate, int total_holiday_type, int employee_id) {
		String sql = "select count(hi.total_holiday) as totalHoliday from holiday_info hi where hi.total_holiday = ? and hi.employee_id = ? and hi.date between '"
				+ fromDate + "' " + "AND " + "'" + toDate + "';";
		int count = 0;

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, total_holiday_type);
				pstm.setInt(2, employee_id);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					count = rs.getInt("totalHoliday");
				}

				System.out.println("count: " + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		System.out.println(sql);
		return count;
	}

	public String getMinDateHoliday(int employee_id) {
		String sql = "select min(hi.date) as minDate from holiday_info hi where hi.employee_id = ?";
		String dateMin = null;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employee_id);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					dateMin = rs.getString("minDate");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return dateMin;
	}

	public String getMaxDateHoliday(int employee_id) {
		String sql = "select max(hi.date) as maxDate from holiday_info hi where hi.employee_id = ?";
		String dateMax = null;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employee_id);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					dateMax = rs.getString("maxDate");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return dateMax;
	}

	public int getTotalLunch() {
		String sql = "SELECT count(lunch) as lunch from holiday_info where lunch = 1;";
		int totalLunch = 0;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					totalLunch = rs.getInt("lunch");
				}
				System.out.println(totalLunch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}
		return totalLunch;
	}

	public static void main(String[] args) {
		HolidayGetTotal main = new HolidayGetTotal();
//		main.holidayGetTotal("2019-12-09", "2019-12-09", 1, 1);

		main.getTotalLunch();
	}
}
