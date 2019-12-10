package com.fpt.hr_management.daoImpl.allowances;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.allowances.AllowanceUpdateRequest;

public class AllowanceUpdate {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(AllowanceUpdateRequest request) {
		String sql = "UPDATE `hr_management`.`salary_allowance` SET `salary_allowance_type_id` = ?, `total_salary` = ?, `last_modifier_by` = ? WHERE `id` = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getSaTypeId());
				pstm.setLong(2, request.getSaTotalSalary());
				pstm.setString(3, request.getLast_modifier_by());
				pstm.setInt(4, request.getId());
				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
