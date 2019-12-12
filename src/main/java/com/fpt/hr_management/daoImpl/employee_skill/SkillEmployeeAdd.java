package com.fpt.hr_management.daoImpl.employee_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeAddRequest;

public class SkillEmployeeAdd {
	private static Connection con;
	private static PreparedStatement pstm;

	public void add(SkillEmployeeAddRequest request) {
		String sql = "INSERT INTO `hr_management`.`skill_employee`(`employee_id`, `skill_id`, `skill_start`, `skill_end`, `level_id`, `created_by`, `last_modifier_by`) VALUES (?,?,?,?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setInt(2, request.getSkill_id());
				pstm.setInt(3, request.getSkill_start());
				pstm.setInt(4, request.getSkill_end());
				pstm.setInt(5, request.getLevel_id());
				pstm.setString(6, request.getCreated_by());
				pstm.setString(7, request.getLast_modifier_by());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
