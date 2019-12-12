package com.fpt.hr_management.daoImpl.employee_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeUpdateRequest;

public class SkillEmployeeUpdate {

	public void update(SkillEmployeeUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE skill_employee SET skill_id =? , skill_start = ?, skill_end =? ,level_id = ?, last_modifier_by =? WHERE id = ?;";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getSkill_id());
				pstm.setInt(2, request.getSkill_start());
				pstm.setInt(3, request.getSkill_end());
				pstm.setInt(4, request.getLevel_id());
				pstm.setString(5, request.getLast_modifier_by());
				pstm.setInt(6, request.getId());
				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
