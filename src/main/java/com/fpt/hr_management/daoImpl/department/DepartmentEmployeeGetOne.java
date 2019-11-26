package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.department.DepartmentEmployeeGetOneRequest;
import com.fpt.hr_management.listener.response.department.DepartmentEmployeeGetOneResponse;

public class DepartmentEmployeeGetOne {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public List<DepartmentEmployeeGetOneResponse> employeeDepartmentInfo(DepartmentEmployeeGetOneRequest request) {
		List<DepartmentEmployeeGetOneResponse> list = new ArrayList<DepartmentEmployeeGetOneResponse>();
		DepartmentEmployeeGetOneResponse employeeInfo = null;
		String sql = "select ed.id as employeeDepartmentId, e.full_name as employeeName, et.id as employeeTypeId, et.name as employeeTypeName, d.id as departmentId, d.name as departmentName, d.phone as departmentPhone,"
				+ " d.location as departmentLocation, p.id as positionId, p.name as positionName, ed.start_date as startDate, ed.end_date as endDate"
				+ " from employee e join employee_department ed on ed.employee_id = e.id"
				+ " join department d on d.id = ed.department_id" + " join position p on p.id = ed.position_id"
				+ " join employee_type et on et.id = ed.employee_type_id" + " where e.id = ? ;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployeeId());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					employeeInfo = new DepartmentEmployeeGetOneResponse();
					employeeInfo.setEmployeeName(rs.getString("employeeName"));
					employeeInfo.setEmployeeTypeName(rs.getString("employeeTypeName"));
					employeeInfo.setDepartmentName(rs.getString("departmentName"));
					employeeInfo.setDepartmentPhone(rs.getString("departmentPhone"));
					employeeInfo.setDepartmentLocation(rs.getString("departmentLocation"));
					employeeInfo.setPositionName(rs.getString("positionName"));
					if (rs.getString("startDate") == null) {
						employeeInfo.setStartDateName("Không xác định.");
					}

					if (rs.getString("endDate") == null) {
						employeeInfo.setEndDateName("Không xác định");
					}

					employeeInfo.setStart_date(rs.getString("startDate"));
					employeeInfo.setEnd_date(rs.getString("endDate"));

					employeeInfo.setEmployeeDepartmentId(rs.getInt("employeeDepartmentId"));
					employeeInfo.setEmployeeTypeId(rs.getInt("employeeTypeId"));
					employeeInfo.setDepartmentId(rs.getInt("departmentId"));
					employeeInfo.setPositionId(rs.getInt("positionId"));

					list.add(employeeInfo);

				}
				if (list.size() > 0) {
					System.out.println(employeeInfo.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return list;
	}

	public static void main(String[] args) {
		DepartmentEmployeeGetOne main = new DepartmentEmployeeGetOne();
		DepartmentEmployeeGetOneRequest request = new DepartmentEmployeeGetOneRequest();
		request.setEmployeeId(1);
		main.employeeDepartmentInfo(request);
	}

}
