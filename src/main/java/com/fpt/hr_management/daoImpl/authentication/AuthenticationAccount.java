package com.fpt.hr_management.daoImpl.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;

public class AuthenticationAccount extends AccountLogin {

	public static HashMap<Integer, AuthenticationEntity> hmAccountPermission() {
		if (userAuthen == null) {
			System.out.println("Vui lòng đăng nhập...");
		} else {
			hmAccountPermission.put(userAuthen.getRoleId(), userAuthen);
			for (Map.Entry<Integer, AuthenticationEntity> entry : hmAccountPermission.entrySet()) {
				System.out.println("RoleId: " + entry.getKey() + "- Account Info: " + entry.getValue());
			}
		}
		return hmAccountPermission;
	}

	public static HashMap<Integer, AuthenticationEntity> getHmAccountPermission() {
		return hmAccountPermission;
	}

	public boolean sessionInvalid(HttpSession session) {
		if (session.getAttribute("account") == null) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		AccountLogin account = new AccountLogin();
		AccountLoginRequest request = new AccountLoginRequest();
		String username = "cuongnv";
		String password = "123";
		request.setUsername(username);
		request.setPassword(password);
		account.login(request);

		hmAccountPermission();
	}

}
