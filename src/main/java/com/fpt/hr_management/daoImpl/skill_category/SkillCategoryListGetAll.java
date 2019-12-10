package com.fpt.hr_management.daoImpl.skill_category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetAllResponse;

public class SkillCategoryListGetAll {
	private List<SkillCategoryListGetAllResponse> listSkillCategory;
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public List<SkillCategoryListGetAllResponse> get() {
		String sql = "select * from category_skill;";
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listSkillCategory = new ArrayList<SkillCategoryListGetAllResponse>();
				if (rs != null) {
					SkillCategoryListGetAllResponse skillCatInfo = null;
					while (rs.next()) {
						skillCatInfo = new SkillCategoryListGetAllResponse();
						skillCatInfo.setId(rs.getInt("id"));
						skillCatInfo.setName(rs.getString("name"));
						skillCatInfo.setDescription(rs.getString("description"));
						skillCatInfo.setCreated_by(rs.getString("created_by"));
						skillCatInfo.setCreated_date(rs.getString("created_date"));
						skillCatInfo.setLast_modifier_by(rs.getString("last_modifier_by"));
						skillCatInfo.setLast_modifier_date(rs.getString("last_modifier_date"));
						listSkillCategory.add(skillCatInfo);
					}

					System.out.println(listSkillCategory.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listSkillCategory;
	}

	public static void main(String[] args) {
		SkillCategoryListGetAll main = new SkillCategoryListGetAll();
		main.get();
	}
}
