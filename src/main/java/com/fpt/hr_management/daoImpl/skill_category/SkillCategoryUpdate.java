package com.fpt.hr_management.daoImpl.skill_category;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryUpdateRequest;

public class SkillCategoryUpdate {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(SkillCategoryUpdateRequest request) {
		String sql = "UPDATE category_skill SET name= ?, description= ?, last_modifier_by =? WHERE id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setString(3, request.getLast_modifier_by());
				pstm.setInt(4, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
