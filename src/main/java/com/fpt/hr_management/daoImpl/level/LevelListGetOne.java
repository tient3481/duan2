package com.fpt.hr_management.daoImpl.level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.level.LevelListGetOneRequest;
import com.fpt.hr_management.listener.response.level.LevelListGetOneResponse;

public class LevelListGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<LevelListGetOneResponse> listLevel;

	public List<LevelListGetOneResponse> getLevel(LevelListGetOneRequest request) {
		LevelListGetOneResponse levelInfo = null;
		String sql = "SELECT * FROM level WHERE id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listLevel = new ArrayList<LevelListGetOneResponse>();
				while (rs.next()) {
					levelInfo = new LevelListGetOneResponse();
					levelInfo.setId(rs.getInt("id"));
					levelInfo.setName(rs.getString("name"));
					levelInfo.setNote(rs.getString("note"));

					listLevel.add(levelInfo);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listLevel;
	}
}
