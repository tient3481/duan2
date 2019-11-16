package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;

public class DepartmentUpdate {

	public void update(DepartmentUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE department SET name =? , phone = ?, location =? ,last_modifier_by =? WHERE id = ?;";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getName());
				pstm.setString(2, request.getPhone());
				pstm.setString(3, request.getLocation());
				pstm.setString(4, request.getLast_modifier_by());
				pstm.setInt(5, request.getId());

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
//		DepartmentUpdate main = new DepartmentUpdate();
//		DepartmentUpdateRequest request = new DepartmentUpdateRequest();
//		request.setName("test department update");
//		request.setId(2525);
//		main.update(request);
//	}
}
