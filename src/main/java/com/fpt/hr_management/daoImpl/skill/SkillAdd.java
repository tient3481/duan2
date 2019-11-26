package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill.SkillAddRequest;

public class SkillAdd {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void add(SkillAddRequest request) {
		String sql = "INSERT INTO skill (name, description,category_id,created_by,last_modifier_by) VALUES (?,?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getDescription());
				pstm.setInt(3, request.getCategory_id());
				pstm.setString(4, request.getCreated_by());
				pstm.setString(5, request.getLast_modifier_by());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

}
