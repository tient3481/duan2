package com.fpt.hr_management.daoImpl.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.account.AccountVerifyPasswordRequest;
import com.fpt.hr_management.mailsender.MailConfig;

public class AccountResetPassword extends MailConfig {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;

	public AccountResetPassword() {

	}

	public void verifyEmail(String emailReset) {
		getEmailAccount(emailReset);
	}

	public void sendCode(String emailReset) {
		if (getEmailAccount(emailReset) != null) {
			try {
				sendEmail(emailReset);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean submitCode(int code) {
		if (code == mailInfo.getCode()) {
			return true;
		}
		return false;
	}

	public boolean resetPasswordAccount(AccountVerifyPasswordRequest request) {
		if (request.getPassword().equals(request.getVerifyPassword())) {
			return true;
		}
		return false;
	}

	public String getEmailAccount(String emailReset) {
		String email = null;
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				String sql = "SELECT email FROM employee where email = ?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, emailReset);
				rs = pstm.executeQuery();
				while (rs.next()) {
					email = rs.getString("email");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, null);
		}
		return email;
	}

//	public static void main(String[] args) {
//		AccountResetPassword main = new AccountResetPassword();
//		System.out.println(main.resetPasswordAccount("123", "123"));
//	}
}
