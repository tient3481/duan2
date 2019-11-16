package com.fpt.hr_management.daoImpl.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee.EmployeeUpdateRequest;

public class EmployeeUpdate {

	public void update(EmployeeUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE employee SET first_name =?, middle_name = ?, last_name =?, full_name=?, phone=?, email=?, dob=?, address=?, sex=?, employee_date=?, end_date=?, employee_type_id=?, status=?, note=?, base_salary=?, last_modifier_by =? WHERE id =?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, request.getFirst_name());
				pstm.setString(2, request.getMiddle_name());
				pstm.setString(3, request.getLast_name());
				pstm.setString(4,
						request.getLast_name() + " " + request.getMiddle_name() + " " + request.getFirst_name());
				pstm.setString(5, request.getPhone());
				pstm.setString(6, request.getEmail());
				pstm.setDate(7, request.getDob());
				pstm.setString(8, request.getAddress());
				pstm.setInt(9, request.getSex());
				pstm.setDate(10, request.getEmployee_date());
				pstm.setDate(11, request.getEnd_date());
				pstm.setInt(12, request.getEmployee_type_id());
				pstm.setInt(13, request.getStatus());
				pstm.setString(14, request.getNote());
				pstm.setLong(15, request.getBase_salary());
				pstm.setString(16, request.getLast_modifier_by());
				pstm.setInt(17, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}

//	public static void main(String[] args) {
//		EmployeeUpdate main = new EmployeeUpdate();
//		EmployeeUpdateRequest request = new EmployeeUpdateRequest();
//		request.setId(1);
//		request.setFirst_name("An");
//		request.setEmployee_type_id(1);
//		Date dob = Date.valueOf("1999-02-19");
//		request.setDob(dob);
//		main.update(request);
//	}

}
