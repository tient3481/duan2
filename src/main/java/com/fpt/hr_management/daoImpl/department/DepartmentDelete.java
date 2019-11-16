package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;

public class DepartmentDelete extends DepartmentValidator {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public void delete(int departmentId) {
		String sql = "DELETE FROM department where id =?;";
		int recordBegin = getSizeListDepartment();
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, departmentId);
				pstm.executeUpdate();

				int recordEnd = getSizeListDepartment();
				if (recordEnd < recordBegin) {
					System.out.println("Delete success id: " + departmentId);
					return;
				}

				System.out.println("Id: " + departmentId + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

	}

}
