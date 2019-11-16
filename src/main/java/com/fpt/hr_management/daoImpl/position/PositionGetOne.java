package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.position.PositionGetOneResponse;

public class PositionGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public PositionGetOneResponse info(int positionId) {
		PositionGetOneResponse positionInfo = null;
		String sql = "SELECT * FROM position WHERE id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, positionId);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					positionInfo = new PositionGetOneResponse();
					positionInfo.setName(rs.getString("name"));
					positionInfo.setDescription(rs.getString("description"));
					positionInfo.setCreated_date(rs.getString("created_date"));
					positionInfo.setCreated_by(rs.getString("created_by"));
					positionInfo.setLast_modifier_date(rs.getString("last_modifier_date"));
					positionInfo.setLast_modifier_by(rs.getString("last_modifier_by"));

				}
				System.out.println(positionInfo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return positionInfo;
	}

	public static void main(String[] args) {
		PositionGetOne main = new PositionGetOne();
		main.info(3);
	}
}
