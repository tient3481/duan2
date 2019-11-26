package com.fpt.hr_management.daoImpl.employee_department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.employee_department.GetInfoEmployeeAddDepartmentResponse;

public class GetInfoEmployeeAddDepartment {
	private ResultSet rs;
	private Statement stm;
	private Connection con;
	private List<GetInfoEmployeeAddDepartmentResponse> listEmployeeNameAndId = new ArrayList<GetInfoEmployeeAddDepartmentResponse>();

	public List<GetInfoEmployeeAddDepartmentResponse> getListEmployee() {
		GetInfoEmployeeAddDepartmentResponse employee = null;
		String sql = "SELECT id, full_name from employee";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					employee = new GetInfoEmployeeAddDepartmentResponse();
					employee.setEmployeeId(rs.getInt("id"));
					employee.setEmployeeName(rs.getString("full_name"));
					listEmployeeNameAndId.add(employee);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, null);
		}

		return listEmployeeNameAndId;
	}

}
