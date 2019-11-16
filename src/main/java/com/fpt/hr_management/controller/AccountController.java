package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpt.hr_management.daoImpl.AccountImpl;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.daoImpl.account.AccountRegister;
import com.fpt.hr_management.daoImpl.account.AccountResetPassword;
import com.fpt.hr_management.daoImpl.account.AccountUpdate;
import com.fpt.hr_management.daoImpl.authentication.AccountResetEntity;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;
import com.fpt.hr_management.listener.request.account.AccountVerifyPasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountResetPasswordRequest;
import com.fpt.hr_management.listener.response.account.AccountRegisterEmployeeGetResponse;
import com.fpt.hr_management.listener.response.account.AccountRegisterRoleGetResponse;
import com.fpt.hr_management.model.account.Account;

@Controller
@RequestMapping("api/account")
public class AccountController extends AuthenticationAccount {

	private AccountImpl service = new AccountImpl();
	private AccountResetEntity accountResetEntity = new AccountResetEntity();
	private AccountResetPassword accountResetPassword = new AccountResetPassword();
	private AccountUpdate account = new AccountUpdate();

	@RequestMapping("login")
	public String login(HttpSession session) {
		if (session.getAttribute("account") != null) {
			return "redirect:/api/employee/get";
		}

		return "account/login";
	}

	@RequestMapping(params = "loginAccount", method = RequestMethod.POST)
	public String loginForm(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		AccountLogin account = new AccountLogin();
		AccountLoginRequest request = new AccountLoginRequest();
		request.setUsername(username);
		request.setPassword(password);
		account.login(request);

		model.addAttribute("roleName", userAuthen.getRoleName());
		model.addAttribute("roleId", userAuthen.getRoleId());
		session.setAttribute("account", userAuthen.getUsername());
		session.setMaxInactiveInterval(3600);
		if (userAuthen.getRoleName() == null) {
			return "account/login";

		}

		return "redirect:/api/employee/get";
	}

	/**
	 * @param session Permission: ADMIN
	 */
	@RequestMapping("/register")
	public String register(HttpSession session, Model model) {
		if (session.getAttribute("account") != null && userAuthen.getRoleId() == ADMIN) {
			List<AccountRegisterEmployeeGetResponse> listEmployee = service.getListEmployee();
			List<AccountRegisterRoleGetResponse> listRole = service.getListRole();
			model.addAttribute("employee", listEmployee);
			model.addAttribute("role", listRole);

			return "account/register";
		}

		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("account") != null) {
			session.removeAttribute("account");
		}
		return "redirect:/api/account/login";
	}

	@RequestMapping(params = "createAccount")
	public String createAccount(HttpSession session, Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("role_id") int role_id,
			@RequestParam("employee_id") int employee_id) {

		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setRole_id(role_id);
		account.setEmployee_id(employee_id);
		account.setCreated_by(userAuthen.getUsername());
		account.setLast_modifier_by(userAuthen.getUsername());

		AccountRegister regAccount = new AccountRegister();
		regAccount.registerAccount(account);
		model.addAttribute("message", "Register success.");
		return "account/register";
	}

	/**
	 * @param session Permission: all
	 */
	@RequestMapping("/profile")
	public String profile(HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "account/login";
		}

		return "account/profile";
	}

	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "account/forgotpassword";
	}

	@RequestMapping("/verify-code")
	public String verifyCode() {
		return "account/verifycode";
	}

	@RequestMapping("change-password")
	public String changePassword() {
		return "account/changepassword";
	}

	@RequestMapping(params = "submitEmail")
	public String doForgotPassword(@RequestParam("emailReset") String emailReset, Model model) {
		if (accountResetPassword.getEmailAccount(emailReset) == null) {
			model.addAttribute("message", "Email not found.");
			return "account/forgotpassword";
		}

		accountResetEntity.setEmail(emailReset);
		try {
			accountResetPassword.sendCode(emailReset);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/account/verifycode";

	}

	@RequestMapping(params = "submitCode")
	public String doSubmitCode(@RequestParam("code") int code, Model model) {
		if (accountResetPassword.submitCode(code)) {
			return "account/changepassword";
		}
		return "account/verifycode";

	}

	@RequestMapping(params = "submitPassword")
	public ModelAndView doSubmitPassword(Model model, @RequestParam("password") String password,
			@RequestParam("re-password") String verifyPassword) {

		ModelAndView modelAndViewSuccess = new ModelAndView("account/login");
		ModelAndView modelAndViewResetCode = new ModelAndView("account/verifycode");
		AccountVerifyPasswordRequest request = new AccountVerifyPasswordRequest();
		request.setPassword(password);
		request.setVerifyPassword(verifyPassword);
		if (accountResetPassword.resetPasswordAccount(request)) {
			AccountResetPasswordRequest requestEmail = new AccountResetPasswordRequest(accountResetEntity.getEmail(),
					password, userAuthen.getUsername());

			account.updatePasswordByEmail(requestEmail);
			modelAndViewSuccess.addObject("message", "Change password success.");
			return modelAndViewSuccess;
		} else {
			return modelAndViewResetCode;
		}
	}

}
