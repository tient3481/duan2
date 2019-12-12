package com.fpt.hr_management.daoImpl.employee_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeGetOneRequest;
import com.fpt.hr_management.listener.response.employee_skill.SkillEmployeeGetOneResponse;

public class SkillEmployeeGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	/**
	 * @param request if request.getOptionId = 1902 -> results employeeId else
	 *                results idTable
	 * @return
	 */
	public List<SkillEmployeeGetOneResponse> info(SkillEmployeeGetOneRequest request, int optionId) {
		SkillEmployeeGetOneResponse skillInfo = null;
		List<SkillEmployeeGetOneResponse> list = new ArrayList<SkillEmployeeGetOneResponse>();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select e.full_name as employeeName, se.*, l.name as levelName, s.name as skillName from skill_employee se join employee e on e.id = se.employee_id join `level` l on l.id = se.level_id join skill s on s.id = se.skill_id where ");
		if (optionId == 1902) {
			sql.append("e.id = ?");
		} else {
			sql.append("se.id = ?");
		}
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql.toString());
				pstm.setInt(1, request.getOptionId());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					skillInfo = new SkillEmployeeGetOneResponse();
					skillInfo.setEmployeeName(rs.getString("employeeName"));
					skillInfo.setId(rs.getInt("id"));
					skillInfo.setEmployee_id(rs.getInt("employee_id"));
					skillInfo.setSkill_id(rs.getInt("skill_id"));
					skillInfo.setSkill_start(rs.getInt("skill_start"));
					if (rs.getInt("skill_end") == 0) {
						skillInfo.setSkillEndName("Không xác định");
					} else {
						skillInfo.setSkill_end(rs.getInt("skill_end"));
					}

					skillInfo.setLevel_id(rs.getInt("level_id"));
					skillInfo.setLevelName(rs.getString("levelName"));
					skillInfo.setSkillName(rs.getString("skillName"));
					list.add(skillInfo);
				}

				System.out.println(list.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return list;
	}

	public static void main(String[] args) {
		SkillEmployeeGetOne main = new SkillEmployeeGetOne();
		SkillEmployeeGetOneRequest request = new SkillEmployeeGetOneRequest();
		request.setOptionId(56);

		main.info(request, 0);
	}
}