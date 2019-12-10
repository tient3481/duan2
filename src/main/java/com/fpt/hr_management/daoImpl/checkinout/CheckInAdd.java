package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckInAddRequest;

public class CheckInAdd {

	private Connection con;
	private PreparedStatement pstm;
	public static InfoCheckIn inCheckIn = new InfoCheckIn();

	public void addCheckIn(CheckInAddRequest request) {
		String sql = "INSERT INTO check_in_history(user_id, check_in_time, date) VALUES (?,NOW(),NOW());";
		try {
			con = DbConnection.getConnection();
			ResultSet rs = null;
			if (con != null) {
				pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstm.setInt(1, request.getUser_id());
				pstm.executeUpdate();

				rs = pstm.getGeneratedKeys();
				if (rs.next()) {
					inCheckIn.setKeyGenerate(rs.getInt(1));
					inCheckIn.setUser_id(request.getUser_id());
					System.out.println("Auto Generated Primary Key " + rs.getInt(1));
				}

				System.out.println(rs.getInt(1));
			} else {
				System.out.println("CheckInAdd không thể kết nối.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		CheckInAdd main = new CheckInAdd();
//		CheckInAddRequest request = new CheckInAddRequest();
//		request.setUser_id(1);
//		main.addCheckIn(request);
//		System.out.println(inCheckIn.getKeyGenerate());
//	}
}
