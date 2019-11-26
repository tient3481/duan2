package com.fpt.hr_management.daoImpl.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee.EmployeeDeleteRequest;

public class EmployeeDelete {

	public void delete(EmployeeDeleteRequest request) {
		String sql = "DELETE FROM employee where id = ?";
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = DbConnection.getConnection();
			pstm = con.prepareStatement(sql);
			if (con != null && pstm != null && sql != null) {
				pstm.setInt(1, request.getId());
				int count = pstm.executeUpdate();
				if (count > 0) {
					return;
				} else {
					throw new SQLException();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
	
}
