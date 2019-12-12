package com.fpt.hr_management.daoImpl.salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.daoImpl.checkinout.CheckInGetTimeSize;
import com.fpt.hr_management.daoImpl.checkinout.CheckInService;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.daoImpl.holiday_info.HolidayGetTotal;
import com.fpt.hr_management.listener.request.checkin.CheckInGetTimeRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.salary.SalaryAllowanceRequest;
import com.fpt.hr_management.listener.request.salary.SalaryBonusRequest;
import com.fpt.hr_management.listener.request.salary.SalaryDisciplineRequest;
import com.fpt.hr_management.listener.request.salary.SalaryPayRequest;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.salary.SalaryAllowanceResponse;
import com.fpt.hr_management.listener.response.salary.SalaryBonusResponse;
import com.fpt.hr_management.listener.response.salary.SalaryDetail;
import com.fpt.hr_management.listener.response.salary.SalaryDisciplineResponse;

public class SalaryService {
	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	private static List<SalaryBonusResponse> listBonusInfo;
	private static List<SalaryAllowanceResponse> listAllowanceInfo;
	private static List<SalaryDisciplineResponse> listDisciplineInfo;

	private static EmployeeGetOne serviceEmployee = new EmployeeGetOne();

	public static List<SalaryDetail> salaryDetail(SalaryPayRequest request) {
		SalaryDetail salaryDetail = new SalaryDetail();
		if ((request.getFromDate() == null || request.getToDate() == null)) {
			request.setFromDate(fromDateOfMonth());
			request.setToDate(toDateOfMonth());

			actionSalaryDetail(request);
		} else {
			actionSalaryDetail(request);
		}

		salaryDetail.setFromDate(request.getFromDate());
		salaryDetail.setToDate(request.getToDate());

		return actionSalaryDetail(request);
	}

	private static List<SalaryDetail> actionSalaryDetail(SalaryPayRequest request) {
		List<SalaryBonusResponse> listSalaryBonus = null;
		List<SalaryAllowanceResponse> listSalaryAllowance = null;
		List<SalaryDisciplineResponse> listSalaryDiscipline = null;
		List<SalaryDetail> salaryDetail = new ArrayList<SalaryDetail>();

		listSalaryBonus = getSalaryBonus(
				new SalaryBonusRequest(request.getEmployeeId(), request.getFromDate(), request.getToDate()));
		listSalaryDiscipline = getSalaryDiscipline(
				new SalaryDisciplineRequest(request.getEmployeeId(), request.getFromDate(), request.getToDate()));
		listSalaryAllowance = getSalaryAllowance(new SalaryAllowanceRequest(request.getEmployeeId()));

		String employeeName = null;
		long totalBonus = 0;
		long totalAllowance = 0;
		long totalDiscipline = 0;
		long baseSalary = 0;
		long totalSalary = 0;
		long totalDay = 0;
		long totalTime = 0;

		for (int i = 0; i < listSalaryBonus.size(); i++) {
			totalBonus += listSalaryBonus.get(i).getBonusSalary();
		}

		for (int i = 0; i < listSalaryAllowance.size(); i++) {
			totalAllowance += listSalaryAllowance.get(i).getAllowanceSalary();
		}

		for (int i = 0; i < listSalaryDiscipline.size(); i++) {
			totalDiscipline += listSalaryDiscipline.get(i).getDisciplineSalary();
		}

		// start- get base salary
		List<EmployeeGetOneResponse> listInfoBaseEmployee = new ArrayList<EmployeeGetOneResponse>();
		listInfoBaseEmployee = serviceEmployee.getInfoEmployee(new EmployeeGetOneRequest(request.getEmployeeId()));
		for (int i = 0; i < listInfoBaseEmployee.size(); i++) {
			baseSalary = listInfoBaseEmployee.get(i).getSalary_base();
			employeeName = listInfoBaseEmployee.get(i).getFirst_name() + listInfoBaseEmployee.get(i).getMiddle_name()
					+ listInfoBaseEmployee.get(i).getLast_name();
		}
		// end- get base salary

		CheckInGetTimeSize sumTotalTime = new CheckInGetTimeSize();
		CheckInGetTimeRequest requestTime = new CheckInGetTimeRequest();
		requestTime.setId(request.getEmployeeId());
		requestTime.setCheck_in_time(request.getFromDate());
		requestTime.setCheck_out_time(request.getToDate());

		totalTime = sumTotalTime.getTimeSize(requestTime);
		totalDay = CheckInService.workingDayActualOneMonth(totalTime);

		int employeeId = request.getEmployeeId();
		long actualWorkDay = totalDay;
		int totalMoneyLunch = new HolidayGetTotal().getTotalLunch() * 35000;
		long lunchMoney = totalMoneyLunch;
		long phoneMoney = getPhoneMoney(employeeId);
		long gasolineMoney = getGasolineMoney(request.getEmployeeId());

		if (totalDay == 0) {
			lunchMoney = 0;
			phoneMoney = 0;
			gasolineMoney = 0;
			totalBonus = 0;
			totalAllowance = 0;
			totalDiscipline = 0;
		} else {
			totalSalary = (((baseSalary) / 26) * totalDay) + totalBonus + totalAllowance - totalDiscipline + lunchMoney;
		}
		long actualSalary = totalSalary;

		SalaryDetail detail = new SalaryDetail(employeeId, employeeName, actualWorkDay, baseSalary, lunchMoney,
				phoneMoney, gasolineMoney, actualSalary);
		salaryDetail = new ArrayList<SalaryDetail>();
		salaryDetail.add(detail);

		System.out.println(salaryDetail.toString());
		return salaryDetail;
	}

	public static String fromDateOfMonth() {
		Date dateNow = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateNow);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.getActualMinimum(Calendar.DAY_OF_MONTH);

		StringBuilder sbDate;
		sbDate = new StringBuilder();
		sbDate.append(year).append("-");
		sbDate.append(month < 10 ? "0" + month : month).append("-").append(date < 10 ? "0" + date : date);
		System.out.println(sbDate);
		return sbDate.toString();
	}

	public static String toDateOfMonth() {
		Date dateNow = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateNow);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		StringBuilder sbDate;
		sbDate = new StringBuilder();
		sbDate.append(year).append("-");
		sbDate.append(month < 10 ? "0" + month : month).append("-").append(date < 10 ? "0" + date : date);

		System.out.println(sbDate);
		return sbDate.toString();
	}

	public static void main(String[] args) {
		// salaryDetail(new SalaryPayRequest(1, "2019-12-09", "2019-12-10"));
//		getSalaryDiscipline(new SalaryDisciplineRequest(1, "2019-12-09", "2019-12-10"));
//		getSalaryBonus(new SalaryBonusRequest(1, "2019-12-09", "2019-12-10"));
		fromDateOfMonth();
		toDateOfMonth();
	}

	private static long getPhoneMoney(int employeeId) {
		String sql = "select e.full_name as employeeName, sa.total_salary from salary_allowance sa join employee e on e.id = sa.employee_id join salary_allowance_type sat on sat.id = sa.salary_allowance_type_id where sa.employee_id = ? and sat.name LIKE 'Phí điện thoại';";
		long phoneMoney = 0;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employeeId);
				ResultSet rs = pstm.executeQuery();
				listBonusInfo = new ArrayList<SalaryBonusResponse>();
				while (rs.next()) {
					phoneMoney = rs.getLong("total_salary");
				}

				if (listBonusInfo.size() > 0) {
					System.out.println(listBonusInfo.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return phoneMoney;
	}

	private static long getGasolineMoney(int employeeId) {
		String sql = "select e.full_name as employeeName, sa.total_salary from salary_allowance sa join employee e on e.id = sa.employee_id join salary_allowance_type sat on sat.id = sa.salary_allowance_type_id where sa.employee_id = ? and sat.name LIKE 'Phí xăng xe';";
		long gasolineMoney = 0;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employeeId);
				ResultSet rs = pstm.executeQuery();
				listBonusInfo = new ArrayList<SalaryBonusResponse>();
				while (rs.next()) {
					gasolineMoney = rs.getLong("total_salary");
				}

				if (listBonusInfo.size() > 0) {
					System.out.println(listBonusInfo.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return gasolineMoney;
	}

	private static List<SalaryBonusResponse> getSalaryBonus(SalaryBonusRequest request) {
		SalaryBonusResponse salaryBonusInfo = null;
		String sql = "select ci.id, ci.user_id as employeeId, e.full_name as employeeName,"
				+ "sbt.name as bonusName, sbt.description as bonusDescription,"
				+ "sb.total_salary_bonus as bonusSalary, ci.date as date " + "FROM check_in_history ci "
				+ "LEFT JOIN employee e on e.id = ci.user_id "
				+ "LEFT JOIN salary_bonus sb on sb.id = ci.salary_bonus_id "
				+ "LEFT JOIN salary_bonus_type sbt on sbt.id = sb.salary_bonus_type_id "
				+ "where ci.user_id = ? and ci.date between '" + request.getFromDate() + "'" + " and '"
				+ request.getToDate() + "';";

		System.out.println("sql: " + sql);
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				ResultSet rs = pstm.executeQuery();
				listBonusInfo = new ArrayList<SalaryBonusResponse>();
				while (rs.next()) {
					salaryBonusInfo = new SalaryBonusResponse();
					salaryBonusInfo.setId(rs.getInt("id"));
					salaryBonusInfo.setEmployeeId(rs.getInt("employeeId"));
					salaryBonusInfo.setEmployeeName(rs.getString("employeeName"));
					salaryBonusInfo.setBonusName(rs.getString("bonusName"));
					salaryBonusInfo.setBonusDescription(rs.getString("bonusDescription"));
					salaryBonusInfo.setBonusSalary(rs.getLong("bonusSalary"));
					salaryBonusInfo.setDate(rs.getDate("date"));
					listBonusInfo.add(salaryBonusInfo);
				}

				if (listBonusInfo.size() > 0) {
					System.out.println(listBonusInfo.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listBonusInfo;
	}

	private static List<SalaryDisciplineResponse> getSalaryDiscipline(SalaryDisciplineRequest request) {
		SalaryDisciplineResponse salaryDisciplineInfo = null;
		String sql = "select ci.id, ci.user_id as employeeId, e.full_name as employeeName,"
				+ " sdt.name as disciplineName, sdt.description as disciplineDescription,"
				+ " sd.total_discipline as disciplineSalary, ci.date as date" + " FROM check_in_history ci"
				+ " LEFT JOIN employee e on e.id = ci.user_id"
				+ " LEFT JOIN salary_discipline sd on sd.id = ci.salary_discipline_id"
				+ " LEFT JOIN salary_discipline_type sdt on sdt.id = sd.discipline_type_id"
				+ " where ci.user_id = ? and ci.date between '" + request.getFromDate() + "'" + " and '"
				+ request.getToDate() + "';";

		System.out.println(sql);
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				ResultSet rs = pstm.executeQuery();
				listDisciplineInfo = new ArrayList<SalaryDisciplineResponse>();
				while (rs.next()) {
					salaryDisciplineInfo = new SalaryDisciplineResponse();
					salaryDisciplineInfo.setId(rs.getInt("id"));
					salaryDisciplineInfo.setEmployeeId(rs.getInt("employeeId"));
					salaryDisciplineInfo.setEmployeeName(rs.getString("employeeName"));
					salaryDisciplineInfo.setDisciplineName(rs.getString("disciplineName"));
					salaryDisciplineInfo.setDisciplineDescription(rs.getString("disciplineDescription"));
					salaryDisciplineInfo.setDisciplineSalary(rs.getLong("disciplineSalary"));
					salaryDisciplineInfo.setDate(rs.getDate("date"));

					listDisciplineInfo.add(salaryDisciplineInfo);
				}
				if (listDisciplineInfo.size() > 0) {
					System.out.println(listDisciplineInfo.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listDisciplineInfo;

	}

	private static List<SalaryAllowanceResponse> getSalaryAllowance(SalaryAllowanceRequest request) {
		SalaryAllowanceResponse salaryAllownaceInfo = null;
		String sql = "select sa.employee_id as employeeId, e.full_name as employeeName,"
				+ " sat.name as allowanceName, sat.description as allowanceDescription,"
				+ " sa.total_salary as allowanceSalary from employee e"
				+ " LEFT JOIN salary_allowance sa on e.id = sa.employee_id"
				+ " LEFT JOIN salary_allowance_type sat on sat.id = sa.salary_allowance_type_id"
				+ " where sa.employee_id =?;";

		System.out.println(sql);
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				ResultSet rs = pstm.executeQuery();
				listAllowanceInfo = new ArrayList<SalaryAllowanceResponse>();
				while (rs.next()) {
					salaryAllownaceInfo = new SalaryAllowanceResponse();
					salaryAllownaceInfo.setEmployeeId(rs.getInt("employeeId"));
					salaryAllownaceInfo.setEmployeeName(rs.getString("employeeName"));
					salaryAllownaceInfo.setAllowanceName(rs.getString("allowanceName"));
					salaryAllownaceInfo.setAllowanceDescription(rs.getString("allowanceDescription"));
					salaryAllownaceInfo.setAllowanceSalary(rs.getLong("allowanceSalary"));

					listAllowanceInfo.add(salaryAllownaceInfo);
				}
				if (listAllowanceInfo.size() > 0) {
					System.out.println(listAllowanceInfo.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listAllowanceInfo;

	}

//	private void updateCheckIn(BonusDisciplineUpdateRequest request) {
//		String sql = "UPDATE `hr_management`.`check_in_history` SET `salary_bonus_id` = ?, `salary_discipline_id` = ? WHERE `id` = ?;";
//		try {
//			con = DbConnection.getConnection();
//			if (con != null) {
//				pstm = con.prepareStatement(sql);
//				pstm.setInt(1, request.getSalary_bonus_id());
//				pstm.setInt(2, request.getSalary_discipline_id());
//				pstm.setInt(3, request.getEmployeeId());
//
//				pstm.executeUpdate();
//			} else {
//				System.out.println("SalaryService class - updateCheckIn method không thể kết nối.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DbConnection.close(con, pstm, null, null);
//		}
//	}

}
