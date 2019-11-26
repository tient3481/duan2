package com.fpt.hr_management.daoImpl.employee_department;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentUpdateRequest;

public class UpdateEmployeeDepartment {
	private Connection con = null;
	private PreparedStatement pstm = null;

	public void update(EmployeeDepartmentUpdateRequest request) {
		String sql = "update employee_department set employee_id = ?, employee_type_id = ?, department_id =?, position_id = ?, end_date = ?, last_modifier_by=? where id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setInt(2, request.getEmployee_type_id());
				pstm.setInt(3, request.getDepartment_id());
				pstm.setInt(4, request.getPosition_id());
				pstm.setDate(5, request.getEnd_date());
				pstm.setString(6, request.getLast_modifier_by());
				pstm.setInt(7, request.getId());
				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
