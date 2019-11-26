package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill.SkillDeleteRequest;

public class SkillDelete {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void delete(SkillDeleteRequest request) {
		String sql = "DELETE FROM skill where id =?;";
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
			DbConnection.close(con, pstm, null, null);
		}

	}
}
