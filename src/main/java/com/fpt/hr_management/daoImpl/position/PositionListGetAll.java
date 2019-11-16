package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.model.position.Position;

public class PositionListGetAll {

	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public List<Position> get() {
		String sql = "SELECT * FROM position; ";

		List<Position> listPosition = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listPosition = new ArrayList<Position>();
				if (rs != null) {
					Position objPos = null;
					while (rs.next()) {
						objPos = new Position();
						objPos.setId(rs.getInt("id"));
						objPos.setName(rs.getString("name"));
						objPos.setDescription(rs.getString("description"));
						listPosition.add(objPos);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listPosition;
	}

}
