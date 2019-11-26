package com.fpt.hr_management.daoImpl.relations_personal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.relations_personnal.RPUpdateRequest;

public class RPUpdate {

	public void update(RPUpdateRequest request) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE relations_personal SET employee_id =?, dad_name = ?, mother_name =?, dad_job=?, mother_job=?, dad_phone=?, mother_phone=?, address=?, address_more=?, bs_name=?, bs_phone=?, bs_address=?, description=? WHERE id =?;";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getEmployee_id());
				pstm.setString(2, request.getDad_name());
				pstm.setString(3, request.getMother_name());
				pstm.setString(4, request.getDad_job());
				pstm.setString(5, request.getMother_job());
				pstm.setString(6, request.getDad_phone());
				pstm.setString(7, request.getMother_phone());
				pstm.setString(8, request.getAddress());
				pstm.setString(9, request.getAddress_more());
				pstm.setString(10, request.getBs_name());
				pstm.setString(11, request.getBs_phone());
				pstm.setString(12, request.getBs_address());
				pstm.setString(13, request.getDescription());
				pstm.setInt(14, request.getId());

				pstm.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
	}
}
