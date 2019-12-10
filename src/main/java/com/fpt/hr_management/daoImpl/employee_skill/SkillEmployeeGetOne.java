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

	public List<SkillEmployeeGetOneResponse> info(SkillEmployeeGetOneRequest request) {
		SkillEmployeeGetOneResponse skillInfo = null;
		List<SkillEmployeeGetOneResponse> list = new ArrayList<SkillEmployeeGetOneResponse>();
		String sql = "select e.full_name as employeeName, se.*, l.name as levelName, s.name as skillName from skill_employee se join employee e on e.id = se.employee_id join `level` l on l.id = se.level_id join skill s on s.id = se.skill_id where e.id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
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
				if (list.size() > 0) {
					System.out.println(skillInfo.toString());
				}
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
		request.setEmployeeId(99);
		main.info(request);
	}
}