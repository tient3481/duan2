package com.fpt.hr_management.daoImpl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.department.DepartmentGetOneRequest;
import com.fpt.hr_management.listener.response.department.DepartmentGetOneResponse;

public class DepartmentGetOne {

	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<DepartmentGetOneResponse> listDepartmentGetOne;

	public List<DepartmentGetOneResponse> getDepartment(DepartmentGetOneRequest request) {
		DepartmentGetOneResponse departmentInfo = null;
		String sql = "SELECT * FROM department WHERE id = ?";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listDepartmentGetOne = new ArrayList<DepartmentGetOneResponse>();
				while (rs.next()) {
					departmentInfo = new DepartmentGetOneResponse();
					departmentInfo.setId(rs.getInt("id"));
					departmentInfo.setName(rs.getString("name"));
					departmentInfo.setPhone(rs.getString("phone"));
					departmentInfo.setLocation(rs.getString("location"));

					listDepartmentGetOne.add(departmentInfo);
				}
				if (listDepartmentGetOne.size() > 0) {
					System.out.println(listDepartmentGetOne.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listDepartmentGetOne;
	}

//	public static void main(String[] args) {
//		DepartmentGetOne main = new DepartmentGetOne();
//		DepartmentGetOneRequest request = new DepartmentGetOneRequest();
//		request.setId(2525);
//		main.getDepartment(request);
//	}
}
