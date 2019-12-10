package com.fpt.hr_management.daoImpl.skill_category;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryAddRequest;

public class SkillCategoryAdd {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void add(SkillCategoryAddRequest request) {
		String sql = "INSERT INTO category_skill (name, description,created_by,last_modifier_by) VALUES (?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setString(3, request.getCreated_by());
				pstm.setString(4, request.getLast_modifier_by());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
