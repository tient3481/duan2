package com.fpt.hr_management.daoImpl.skill_category;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryDeleteRequest;

public class SkillCategoryDelete {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void delete(SkillCategoryDeleteRequest request) {
		String sql = "DELETE FROM category_skill where id =?;";
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
