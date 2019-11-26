package com.fpt.hr_management.daoImpl.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.employee.EmployeeGetAllResponse;

public class EmployeeListGetAll {
	private List<EmployeeGetAllResponse> listEmployee;

	public List<EmployeeGetAllResponse> list() {
		String sql = "SELECT id, full_name, phone, email, dob, address, sex, start_date, employee_date, status FROM employee;";
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listEmployee = new ArrayList<EmployeeGetAllResponse>();
				if (rs != null) {
					EmployeeGetAllResponse objEmp = null;
					while (rs.next()) {
						objEmp = new EmployeeGetAllResponse();

						objEmp.setId(rs.getInt("id"));
						objEmp.setFull_name(rs.getString("full_name"));
						objEmp.setPhone(rs.getString("phone"));
						objEmp.setEmail(rs.getString("email"));
						objEmp.setDob(rs.getString("dob"));
						objEmp.setAddress(rs.getString("address"));
						if (rs.getInt("sex") == 0) {
							objEmp.setSexName("Nam");
						} else {
							objEmp.setSexName("Nữ");
						}
						objEmp.setStart_date(rs.getString("start_date"));
						objEmp.setEmployee_date(rs.getString("employee_date"));
						objEmp.setStatus(rs.getBoolean("status"));

						listEmployee.add(objEmp);
					}

					System.out.println(listEmployee.toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listEmployee;
	}

	public static void main(String[] args) {
		EmployeeListGetAll main = new EmployeeListGetAll();
		main.list();
	}

}
