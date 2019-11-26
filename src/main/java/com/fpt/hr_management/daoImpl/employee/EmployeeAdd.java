package com.fpt.hr_management.daoImpl.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee.EmployeeAddRequest;

public class EmployeeAdd {

	public void add(EmployeeAddRequest emp) {
		Connection con = null;
		PreparedStatement pstm = null;

		String sql = "INSERT INTO employee(first_name, middle_name, last_name, full_name, phone, email, dob, address, sex, start_date, employee_type_id, note, created_by, manager_id) VALUE(?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?);";
		try {
			con = DbConnection.getConnection();
			if (con != null && sql != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, emp.getFirst_name());
				pstm.setString(2, emp.getMiddle_name());
				pstm.setString(3, emp.getLast_name());
				pstm.setString(4, emp.getFirst_name() + " " + emp.getMiddle_name() + " " + emp.getLast_name());
				pstm.setString(5, emp.getPhone());
				pstm.setString(6, emp.getEmail());
				pstm.setDate(7, emp.getDob());
				pstm.setString(8, emp.getAddress());
				pstm.setInt(9, emp.getSex());
				pstm.setInt(10, emp.getEmployee_type_id());
				pstm.setString(11, emp.getNote());
				pstm.setString(12, emp.getCreated_by());
				pstm.setInt(13, emp.getManager_id());

				pstm.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}

	}

//	public static void main(String[] args) {
//		EmployeeAdd main = new EmployeeAdd();
//		EmployeeAddRequest request = new EmployeeAddRequest();
//		request.setAddress("hanoi");
//		request.setEmployee_type_id(1);
//		main.add(request);
//	}
}
