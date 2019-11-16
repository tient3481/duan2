package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fpt.hr_management.connection.DbConnection;

public class AccountValidator {

	private static Connection con = null;
	private static PreparedStatement pstm = null;
	private static Statement stm = null;
	private static ResultSet rs = null;

	/**
	 * @param employeeId
	 * @Returns true if the employeeId has been found and versa
	 */

	public boolean checkIdEmployee(int employeeId) {
		String sql = "SELECT * FROM employee where id = ?; ";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, employeeId);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return false;
	}

	/**
	 * @param user_role_id
	 * @Returns true if the user_role_id has been found and versa
	 */
	public static boolean checkAccountId(int user_role_id) {
		String sql = "SELECT * FROM user_role where id = ?; ";
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, user_role_id);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return false;
	}

	public static int getSizeListAccount() {
		String sql = "SELECT COUNT(id) FROM user_role; ";
		int countRecord = 0;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					countRecord = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countRecord;
	}

	public static void main(String[] args) {
		System.out.println(getSizeListAccount());
	}
}
