package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;

public class AccountDelete extends AccountValidator {

	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;

	public void delete(Integer accountId) {
		String sql = "DELETE FROM user_role where id =?;";
		int recordBegin = getSizeListAccount();
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, accountId);
				pstm.executeUpdate();

				int recordEnd = getSizeListAccount();
				if (recordEnd < recordBegin) {
					System.out.println("Delete success id: " + accountId);
					return;
				}

				System.out.println("Id: " + accountId + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

	}

//	public static void main(String[] args) {
//		deleteAccount(10);
//	}
}
