package com.fpt.hr_management.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost:";
		int port = 3306;
		String dbName = "/hr_management";
		String username = "root";
		String password = "admin";

		return connectionInfo(hostName, port, dbName, username, password);
	}

	public static Connection connectionInfo(String hostName, int port, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + port + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

	public static void close(Connection connection, PreparedStatement pstm, Statement stm, ResultSet rs) {
		try {
			if (connection != null) {
				connection.close();
			}

			if (pstm != null) {
				pstm.close();
			}

			if (stm != null) {
				stm.close();
			}

			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		if (getConnection() != null) {
//			System.out.println("ok");
//			return;
//		}
//		
//		System.out.println("fail");
//	}

}
