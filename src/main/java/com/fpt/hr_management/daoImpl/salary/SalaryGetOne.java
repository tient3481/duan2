package com.fpt.hr_management.daoImpl.salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.salary.SalaryListGetOneRequest;
import com.fpt.hr_management.listener.response.salary.SalaryListGetOneResponse;

public class SalaryGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<SalaryListGetOneResponse> listSalary;

	public List<SalaryListGetOneResponse> getSalary(SalaryListGetOneRequest request) {
		SalaryListGetOneResponse salaryInfo = null;
		String sql = "SELECT sh.*, e.full_name FROM salary_history sh left join employee e on e.id = sh.user_id WHERE sh.user_id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				ResultSet rs = pstm.executeQuery();
				listSalary = new ArrayList<SalaryListGetOneResponse>();
				while (rs.next()) {
					salaryInfo = new SalaryListGetOneResponse();
					salaryInfo.setEmployeeId(rs.getInt("user_id"));
					salaryInfo.setEmployeeName(rs.getString("full_name"));
					salaryInfo.setMonth(rs.getInt("month"));
					salaryInfo.setTotalDay(rs.getLong("total_day"));
					salaryInfo.setTotalSalary(rs.getLong("total_salary"));

					listSalary.add(salaryInfo);
				}
				if (listSalary.size() > 0) {
					System.out.println(listSalary.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listSalary;
	}

	public static void main(String[] args) {
		SalaryGetOne main = new SalaryGetOne();
		main.getSalary(new SalaryListGetOneRequest(1));
	}
}