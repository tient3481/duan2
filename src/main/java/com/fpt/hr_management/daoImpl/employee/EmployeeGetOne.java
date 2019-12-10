package com.fpt.hr_management.daoImpl.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;

public class EmployeeGetOne {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;

	public List<EmployeeGetOneResponse> getInfoEmployee(EmployeeGetOneRequest request) {
		String sql = "SELECT * FROM employee where id =?";
		EmployeeGetOneResponse employeeInfo;
		List<EmployeeGetOneResponse> listInfo = new ArrayList<EmployeeGetOneResponse>();
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());

				rs = pstm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String first_name = rs.getString("first_name");
					String middle_name = rs.getString("middle_name");
					String last_name = rs.getString("last_name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String dob = rs.getString("dob");
					String address = rs.getString("address");
					String gender, type_name, user_manager_name, status_name = "";
					if (rs.getInt("sex") == 0) {
						gender = "Male";
					} else {
						gender = "Female";
					}

					if (rs.getInt("employee_type_id") == 1) {
						type_name = "Intership";
					}

					if (rs.getInt("employee_type_id") == 2) {
						type_name = "Probation";
					} else {
						type_name = "Official";
					}

					if (rs.getInt("status") == 0) {
						status_name = "Left";
					}

					if (rs.getInt("status") == 1) {
						status_name = "Working";
					}

					String employee_date = rs.getString("employee_date");
					String end_date = rs.getString("end_date");
					String note = rs.getString("note");
					long salary_base = rs.getLong("salary_base");
					user_manager_name = findName(request.getId());

					employeeInfo = new EmployeeGetOneResponse(id, first_name, middle_name, last_name, phone, email, dob,
							address, gender, employee_date, end_date, type_name, status_name, user_manager_name, note,
							salary_base);
					listInfo.add(employeeInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listInfo;
	}

	public String findName(int id) {
		String name = "";
		String sql = "SELECT full_name from employee where id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, id);

				rs = pstm.executeQuery();
				if (rs.next()) {
					name = rs.getString("full_name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

//	public static void main(String[] args) {
//		EmployeeGetOne getOne = new EmployeeGetOne();
//		EmployeeGetOneRequest request = new EmployeeGetOneRequest();
//		request.setId(1);
//
//		getOne.findName(1);
//	}
}
