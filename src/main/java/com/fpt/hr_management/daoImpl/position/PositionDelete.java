package com.fpt.hr_management.daoImpl.position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;

public class PositionDelete extends PositionValidator{
	
	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;

	public void delete(int positionId) {
		String sql = "DELETE FROM position where id =?;";
		int recordBegin = getSizeListPosition();
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, positionId);
				pstm.executeUpdate();

				int recordEnd = getSizeListPosition();
				if (recordEnd < recordBegin) {
					System.out.println("Delete success id: " + positionId);
					return;
				}

				System.out.println("Id: " + positionId + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

	}
}
