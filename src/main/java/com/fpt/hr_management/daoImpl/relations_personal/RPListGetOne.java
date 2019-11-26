package com.fpt.hr_management.daoImpl.relations_personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.relations_personnal.RPGetOneRequest;
import com.fpt.hr_management.listener.response.relations_personal.RPListGetOneResponse;

public class RPListGetOne {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;

	public List<RPListGetOneResponse> getInfoRPEmployee(RPGetOneRequest request) {
		String sql = "SELECT * FROM relations_personal where employee_id =?";
		RPListGetOneResponse employeeInfo;
		List<RPListGetOneResponse> listInfo = new ArrayList<RPListGetOneResponse>();
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				rs = pstm.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					int employee_id = rs.getInt("employee_id");
					String dad_or_mother_name = rs.getString("dad_or_mother_name");
					String dad_or_mother_job = rs.getString("dad_or_mother_job");
					String dad_or_mother_phone = rs.getString("dad_or_mother_phone");
					String dad_or_mother_address = rs.getString("dad_or_mother_address");
					String bs_name = rs.getString("bs_name");
					String bs_phone = rs.getString("bs_phone");
					String bs_address = rs.getString("bs_address");
					String description = rs.getString("description");

					employeeInfo = new RPListGetOneResponse(id, employee_id, dad_or_mother_name, dad_or_mother_job,
							dad_or_mother_phone, dad_or_mother_address, bs_name, bs_phone, bs_address, description);
					listInfo.add(employeeInfo);
				}

				System.out.println(listInfo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return listInfo;

	}

	/*
	 * public static void main(String[] args) { RPListGetOne getOne = new
	 * RPListGetOne(); RPGetOneRequest request = new RPGetOneRequest();
	 * request.setEmployee_id(1); getOne.getInfoRPEmployee(request); }
	 */
}
