package com.fpt.hr_management.daoImpl.holiday_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.holiday_info.HolidayAddRequest;
import com.fpt.hr_management.listener.response.holiday_info.HolidayGetListResponse;

public class HolidayInfoAdd {

	private Connection con;
	private PreparedStatement pstm;
	private List<HolidayGetListResponse> listHoliday = new ArrayList<HolidayGetListResponse>();

	public void add(HolidayAddRequest request) {
		String sql = "INSERT INTO holiday_info(employee_id, total_holiday, date) VALUES (?,?,NOW());";
		try {
			con = DbConnection.getConnection();
			HolidayGetListResponse responseHoliday;
			if (con != null) {
				responseHoliday = new HolidayGetListResponse();
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setInt(2, request.getTotal_holiday());
				pstm.executeUpdate();

				responseHoliday.setEmployee_id(request.getEmployee_id());
				responseHoliday.setTotal_holiday(request.getTotal_holiday());
				listHoliday.add(responseHoliday);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

	public static void main(String[] args) {
		HolidayAddRequest request = new HolidayAddRequest();
		request.setEmployee_id(1);
		request.setTotal_holiday(1);
		HolidayInfoAdd main = new HolidayInfoAdd();
		main.add(request);
	}
}