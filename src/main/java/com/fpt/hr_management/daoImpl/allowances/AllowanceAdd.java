package com.fpt.hr_management.daoImpl.allowances;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.allowances.AllowanceAddRequest;

public class AllowanceAdd {
	private Connection con;
	private PreparedStatement pstm;

	public void add(AllowanceAddRequest request) {
		String sql = "INSERT INTO `hr_management`.`salary_allowance`(`salary_allowance_type_id`, `total_salary`, `created_by`, `last_modifier_by`, `employee_id`) VALUES (?,?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getSalary_allowance_type_id());
				pstm.setLong(2, request.getTotal_salary());
				pstm.setString(3, request.getCreated_by());
				pstm.setString(4, request.getLast_modifier_by());
				pstm.setInt(5, request.getEmployee_id());
				
				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
