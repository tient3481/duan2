package com.fpt.hr_management.daoImpl.employee_department;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentAddRequest;

public class AddEmployeeDepartment {

	public void add(EmployeeDepartmentAddRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO employee_department (employee_id,employee_type_id,department_id,position_id,start_date,created_by,last_modifier_by) VALUES (?,?,?,?,NOW(),?,?);";

		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setInt(2, request.getEmployee_type_id());
				pstm.setInt(3, request.getDepartment_id());
				pstm.setInt(4, request.getPosition_id());
				pstm.setString(5, request.getCreated_by());
				pstm.setString(6, request.getLast_modifier_by());

				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		AddEmployeeDepartment main = new AddEmployeeDepartment();
//		EmployeeDepartmentAddRequest request = new EmployeeDepartmentAddRequest();
//		request.setEmployee_id(1);
//		request.setEmployee_type_id(3);
//		request.setDepartment_id(2525);
//		request.setPosition_id(8);
//		main.add(request);
//	}
}