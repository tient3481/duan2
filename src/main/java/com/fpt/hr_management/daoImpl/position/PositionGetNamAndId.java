package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.position.PositionGetNamAndIdResponse;

public class PositionGetNamAndId {
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private List<PositionGetNamAndIdResponse> listPosition;

	public List<PositionGetNamAndIdResponse> getListPosition() {
		PositionGetNamAndIdResponse positionInfo = null;
		String sql = "SELECT id, name FROM position";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				listPosition = new ArrayList<PositionGetNamAndIdResponse>();
				while (rs.next()) {
					positionInfo = new PositionGetNamAndIdResponse();
					positionInfo.setId(rs.getInt("id"));
					positionInfo.setName(rs.getString("name"));
					listPosition.add(positionInfo);
				}
				System.out.println(listPosition.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}

		return listPosition;
	}

	public static void main(String[] args) {
		PositionGetNamAndId main = new PositionGetNamAndId();
		main.getListPosition();
	}
}
