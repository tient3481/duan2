package com.fpt.hr_management.daoImpl.allowances;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.allowances.AllowanceGetOneByEmployeeRequest;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetOneByEmployeeResponse;

public class AllowanceGetOneByEmployee {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public List<AllowanceGetOneByEmployeeResponse> getOne(AllowanceGetOneByEmployeeRequest request) {
		List<AllowanceGetOneByEmployeeResponse> list = new ArrayList<AllowanceGetOneByEmployeeResponse>();
		String sql = "select e.id as employeeId, e.full_name as employeeName, sat.id as satId,"
				+ " sat.name as satName, sat.description as satDescription,"
				+ " sa.id as saId, sa.total_salary as saTotalSalary," + " sa.salary_allowance_type_id as saTypeId"
				+ " from employee e" + " LEFT JOIN salary_allowance sa on e.id = sa.employee_id"
				+ " LEFT JOIN salary_allowance_type sat on sat.id = sa.salary_allowance_type_id" + " where e.id = ?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				rs = pstm.executeQuery();
				AllowanceGetOneByEmployeeResponse employeeAllowance = null;
				while (rs.next()) {
					employeeAllowance = new AllowanceGetOneByEmployeeResponse();
					employeeAllowance.setEmployeeId(rs.getInt("employeeId"));
					employeeAllowance.setEmployeeName(rs.getString("employeeName"));
					employeeAllowance.setSatId(rs.getInt("satId"));
					employeeAllowance.setSatName(rs.getString("satName"));
					employeeAllowance.setSatDescription(rs.getString("satDescription"));

					employeeAllowance.setSaId(rs.getInt("saId"));
					employeeAllowance.setSaTypeId(rs.getInt("saTypeId"));
					employeeAllowance.setSaTotalSalary(rs.getLong("saTotalSalary"));

					list.add(employeeAllowance);
				}

				System.out.println(list.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return list;
	}

	public static void main(String[] args) {
		AllowanceGetOneByEmployee main = new AllowanceGetOneByEmployee();
		main.getOne(new AllowanceGetOneByEmployeeRequest(1));
	}
}
