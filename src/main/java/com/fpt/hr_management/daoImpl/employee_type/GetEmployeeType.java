package com.fpt.hr_management.daoImpl.employee_type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.employee_type.EmployeeTypeResponse;

public class GetEmployeeType {
	private ResultSet rs;
	private Statement stm;
	private Connection con;
	private List<EmployeeTypeResponse> listEmployeeType = new ArrayList<EmployeeTypeResponse>();

	public List<EmployeeTypeResponse> getListEmployeeType() {
		EmployeeTypeResponse type = null;
		String sql = "SELECT * from employee_type";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					type = new EmployeeTypeResponse();
					type.setId(rs.getInt("id"));
					type.setName(rs.getString("name"));
					type.setDescription(rs.getString("description"));
					listEmployeeType.add(type);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, null);
		}

		return listEmployeeType;
	}

//	public static void main(String[] args) {
//		GetEmployeeType main = new GetEmployeeType();
//		main.getListEmployeeType();
//	}

}
