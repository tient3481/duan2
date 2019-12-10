package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckInDeleteRequest;

public class CheckInDelete {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public void delete(CheckInDeleteRequest request) {
		String sql = "DELETE FROM check_in_history where id =?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}
	}

//	public static void main(String[] args) {
//		CheckInDelete main = new CheckInDelete();
//		CheckInDeleteRequest request = new CheckInDeleteRequest();
//		main.delete(request);
//	}
}
