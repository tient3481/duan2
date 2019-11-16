package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.position.PositionAddRequest;

public class PositionAdd {

	public void add(PositionAddRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO position (name, description,created_by,last_modifier_by) VALUES (?,?,?,?);";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setString(3, request.getCreated_by());
				pstm.setString(4, request.getLast_modifier_by());

				int countRecord = pstm.executeUpdate();
				if (countRecord > 0) {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		PositionAdd service = new PositionAdd();
//		PositionAddRequest request = new PositionAddRequest();
//		request.setName("fff");
//		request.setDescription("fff");
//		service.add(request);
//	}

}