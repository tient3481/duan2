package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.skill.SkillListGetOneRequest;
import com.fpt.hr_management.listener.response.skill.SkillListGetOneResponse;

public class SkillListGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<SkillListGetOneResponse> listSkillGetOne;

	public List<SkillListGetOneResponse> get(SkillListGetOneRequest request) {
		SkillListGetOneResponse skillInfo = null;
		String sql = "select s.*, cs.name as categoryName from skill s left join category_skill cs on s.category_id = cs.id where s.id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listSkillGetOne = new ArrayList<SkillListGetOneResponse>();
				while (rs.next()) {
					skillInfo = new SkillListGetOneResponse();
					skillInfo.setId(rs.getInt("id"));
					skillInfo.setName(rs.getString("name"));
					skillInfo.setDescription(rs.getString("description"));
					skillInfo.setCategory_id(rs.getInt("category_id"));
					skillInfo.setCategoryName(rs.getString("categoryName"));

					listSkillGetOne.add(skillInfo);
				}
				
				System.out.println(listSkillGetOne.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listSkillGetOne;
	}
	
//	public static void main(String[] args) {
//		SkillListGetOne main = new SkillListGetOne();
//		main.get(new SkillListGetOneRequest(2));
//	}
}
