package com.fpt.hr_management.daoImpl.level;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.level.LevelListGetAllResponse;

public class LevelListGetAll {
	private List<LevelListGetAllResponse> listLevel;

	public List<LevelListGetAllResponse> get() {
		String sql = "SELECT * FROM level;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listLevel = new ArrayList<LevelListGetAllResponse>();
				if (rs != null) {
					LevelListGetAllResponse objLevel = null;
					while (rs.next()) {
						objLevel = new LevelListGetAllResponse();
						objLevel.setId(rs.getInt("id"));
						objLevel.setName(rs.getString("name"));
						objLevel.setNote(rs.getString("note"));

						listLevel.add(objLevel);
					}

					System.out.println(listLevel.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listLevel;
	}
}
