package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.skill.SkillCategoryListGetAllResponse;
import com.fpt.hr_management.listener.response.skill.SkillListGetAllResponse;

public class SkillListGetAll {
	private List<SkillCategoryListGetAllResponse> listSkillCat;
	private List<SkillListGetAllResponse> listSkill;
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public List<SkillCategoryListGetAllResponse> getCategorySkill() {
		String sql = "select s.*, cs.name as categoryName from skill s left join category_skill cs on s.category_id = cs.id;";
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listSkillCat = new ArrayList<SkillCategoryListGetAllResponse>();
				if (rs != null) {
					SkillCategoryListGetAllResponse skillInfo = null;
					while (rs.next()) {
						skillInfo = new SkillCategoryListGetAllResponse();
						skillInfo.setId(rs.getInt("id"));
						skillInfo.setName(rs.getString("name"));
						skillInfo.setCategory_id(rs.getInt("category_id"));
						skillInfo.setCategoryName(rs.getString("categoryName"));
						skillInfo.setDescription(rs.getString("description"));
						skillInfo.setCreated_by(rs.getString("created_by"));
						skillInfo.setCreated_date(rs.getString("created_date"));
						skillInfo.setLast_modifier_by(rs.getString("last_modifier_by"));
						skillInfo.setLast_modifier_date(rs.getString("last_modifier_date"));
						listSkillCat.add(skillInfo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listSkillCat;
	}

	public List<SkillListGetAllResponse> getSkill() {
		String sql = "select * from skill;";
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listSkill = new ArrayList<SkillListGetAllResponse>();
				if (rs != null) {
					SkillListGetAllResponse skillInfo = null;
					while (rs.next()) {
						skillInfo = new SkillListGetAllResponse();
						skillInfo.setId(rs.getInt("id"));
						skillInfo.setName(rs.getString("name"));
						skillInfo.setDescription(rs.getString("description"));
						listSkill.add(skillInfo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listSkill;
	}
}