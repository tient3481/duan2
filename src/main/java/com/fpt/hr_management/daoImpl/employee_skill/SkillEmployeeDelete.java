package com.fpt.hr_management.daoImpl.employee_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeDeleteRequest;

public class SkillEmployeeDelete {
	public void delete(SkillEmployeeDeleteRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "DELETE FROM skill_employee WHERE id = ?;";

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
