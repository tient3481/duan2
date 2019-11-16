package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckOutUpdateRequest;

public class CheckOutUpdate {

	private PreparedStatement pstm;
	private Connection con;

	public void checkOut(CheckOutUpdateRequest request) {
		String sql = "UPDATE check_in set check_out_time = NOW() where id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());

				pstm.executeUpdate();
			} else {
				System.out.println("checkOut không thể kết nối.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}

	}

//	public static void main(String[] args) {
//		CheckOutUpdate main = new CheckOutUpdate();
//		CheckOutUpdateRequest request = new CheckOutUpdateRequest();
//		request.setId(8);
//		main.checkOut(request);
//	}

}
