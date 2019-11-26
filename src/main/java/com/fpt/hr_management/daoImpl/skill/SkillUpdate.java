package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill.SkillUpdateRequest;

public class SkillUpdate {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(SkillUpdateRequest request) {
		String sql = "UPDATE skill SET name= ?, description= ?, category_id= ?, last_modifier_by =? WHERE id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setInt(3, request.getCategory_id());
				pstm.setString(4, request.getLast_modifier_by());
				pstm.setInt(5, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
