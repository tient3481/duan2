package com.fpt.hr_management.daoImpl.employee_department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentDeleteRequest;

public class DeleteEmployeeDepartment {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public void delete(EmployeeDepartmentDeleteRequest request) {
		String sql = "DELETE FROM employee_department where id =?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}
	}
}
