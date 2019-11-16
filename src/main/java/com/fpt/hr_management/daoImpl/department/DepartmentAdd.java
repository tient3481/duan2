package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;

public class DepartmentAdd extends DepartmentValidator {

	public int ranIdDepartment() {
		return new Random().nextInt(9000);
	}

	public void add(DepartmentAddRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO department (id, name, phone, location, created_by, last_modifier_by) VALUES (?,?,?,?,?,?);";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, ranIdDepartment());
				pstm.setString(2, request.getName());
				pstm.setString(3, request.getPhone());
				pstm.setString(4, request.getLocation());
				pstm.setString(5, request.getCreated_by());
				pstm.setString(6, request.getLast_modifier_by());
				int countRecord = pstm.executeUpdate();
				if (countRecord > 0) {
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//
//		DepartmentAddRequest request = new DepartmentAddRequest();
//		request.setName("XTEL");
//		add(request);
//	}
}
