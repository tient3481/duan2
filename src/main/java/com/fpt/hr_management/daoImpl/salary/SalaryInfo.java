package com.fpt.hr_management.daoImpl.salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.salary.TotalSalaryInfoRequest;
import com.fpt.hr_management.listener.response.salary.TotalSalaryInfoResponse;

public class SalaryInfo {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<TotalSalaryInfoResponse> listSalaryInfo = new ArrayList<TotalSalaryInfoResponse>();

	public List<TotalSalaryInfoResponse> listSalaryGetOne(TotalSalaryInfoRequest request) {
		String sql = "select\r\n" + "e.full_name as employeeName,\r\n" + "sh.user_id as employeeId,\r\n"
				+ "sh.total_salary as totalSalary,\r\n" + "sh.month as month,\r\n" + "sh.total_day as totalDay,\r\n"
				+ "sat.name as allowanceName,\r\n" + "sa.total_salary as totalSalaryAllowance,\r\n"
				+ "sdt.name as disciplineName,\r\n" + "sd.total_discipline as totalSalaryDiscipline,\r\n"
				+ "sbt.name as bonusName,\r\n" + "sb.total_salary_bonus as totalSalaryBonus\r\n" + "\r\n" + "FROM\r\n"
				+ "salary_history sh\r\n" + "left join employee e on e.id = sh.user_id\r\n"
				+ "LEFT JOIN salary_bonus sb on sb.id = sh.salary_bonus_id\r\n"
				+ "LEFT JOIN salary_bonus_type sbt on sbt.id = sb.salary_bonus_type_id\r\n"
				+ "LEFT JOIN salary_discipline sd on sd.id = sh.salary_discipline_id\r\n"
				+ "LEFT JOIN salary_discipline_type sdt on sdt.id = sd.discipline_type_id\r\n"
				+ "LEFT JOIN salary_allowance sa on sa.id = sh.salary_allowance_id\r\n"
				+ "LEFT JOIN salary_allowance_type sat on sat.id = sa.salary_allowance_type_id\r\n" + "\r\n"
				+ "WHERE sh.user_id = ?;\r\n" + "";
		TotalSalaryInfoResponse salaryInfo;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				rs = pstm.executeQuery();
				while (rs.next()) {
					salaryInfo = new TotalSalaryInfoResponse();
					salaryInfo.setEmployeeName(rs.getString("employeeName"));
					salaryInfo.setEmployeeId(rs.getInt("employeeId"));
					salaryInfo.setTotalSalary(rs.getLong("totalSalary"));
					salaryInfo.setMonth(rs.getInt("month"));
					salaryInfo.setTotalDay(rs.getLong("totalDay"));
					salaryInfo.setAllowanceName(rs.getString("allowanceName"));
					salaryInfo.setTotalSalaryAllowance(rs.getLong("totalSalaryAllowance"));
					salaryInfo.setDisciplineName(rs.getString("disciplineName"));
					salaryInfo.setTotalSalaryDiscipline(rs.getLong("totalSalaryDiscipline"));
					salaryInfo.setBonusName(rs.getString("bonusName"));
					salaryInfo.setTotalSalaryBonus(rs.getLong("totalSalaryBonus"));
					listSalaryInfo.add(salaryInfo);
				}

				System.out.println(listSalaryInfo.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listSalaryInfo;
	}

	public static void main(String[] args) {
		SalaryInfo main = new SalaryInfo();
		main.listSalaryGetOne(new TotalSalaryInfoRequest(1));
	}

}
