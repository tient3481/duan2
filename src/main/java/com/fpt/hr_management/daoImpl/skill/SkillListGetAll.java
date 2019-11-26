package com.fpt.hr_management.daoImpl.skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.skill.SkillListGetAllResponse;

public class SkillListGetAll {
	private List<SkillListGetAllResponse> listSkill;

	public List<SkillListGetAllResponse> get() {
		String sql = "SELECT * FROM skill;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listSkill = new ArrayList<SkillListGetAllResponse>();
				if (rs != null) {
					SkillListGetAllResponse objSki = null;
					while (rs.next()) {
						objSki = new SkillListGetAllResponse();
						objSki.setId(rs.getInt("id"));
						objSki.setName(rs.getString("name"));
						objSki.setDescription(rs.getString("description"));
						objSki.setCategory_id(rs.getInt("category_id"));

						listSkill.add(objSki);
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