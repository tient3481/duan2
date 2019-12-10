package com.fpt.hr_management.daoImpl.skill_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryListGetOneRequest;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetOneResponse;

public class SkillCategoryListGetOne {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<SkillCategoryListGetOneResponse> listSkillCat;

	public List<SkillCategoryListGetOneResponse> get(SkillCategoryListGetOneRequest request) {
		SkillCategoryListGetOneResponse skillCatInfo = null;
		String sql = "select * from category_skill where id= ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listSkillCat = new ArrayList<SkillCategoryListGetOneResponse>();
				while (rs.next()) {
					skillCatInfo = new SkillCategoryListGetOneResponse();
					skillCatInfo.setId(rs.getInt("id"));
					skillCatInfo.setName(rs.getString("name"));
					skillCatInfo.setDescription(rs.getString("description"));

					listSkillCat.add(skillCatInfo);
				}

				System.out.println(listSkillCat.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listSkillCat;
	}
}
