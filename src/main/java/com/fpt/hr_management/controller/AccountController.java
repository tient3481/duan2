package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.hr_management.daoImpl.AccountImpl;
import com.fpt.hr_management.daoImpl.account.AccountChangePassword;
import com.fpt.hr_management.daoImpl.account.AccountRegister;
import com.fpt.hr_management.daoImpl.account.AccountResetPassword;
import com.fpt.hr_management.daoImpl.account.AccountUpdate;
import com.fpt.hr_management.daoImpl.authentication.AccountResetEntity;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.account.AccountChangePasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountLoginRequest;
import com.fpt.hr_management.listener.request.account.AccountResetPasswordRequest;
import com.fpt.hr_management.listener.request.account.AccountVerifyPasswordRequest;
import com.fpt.hr_management.listener.response.account.AccountRegisterGetEmployeeNameResponse;
import com.fpt.hr_management.listener.response.account.AccountRegisterGetRoleResponse;
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
	public ModelAndView loginForm(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session, RedirectAttributes redirect) throws Exception {

		if (session.getAttribute("account") != null) {
			return new ModelAndView("redirect:/api/employee/get");
		} else {
			if (login(new AccountLoginRequest(username, password))) {
				model.addAttribute("roleName", userAuthen.getRoleName());
				model.addAttribute("roleId", userAuthen.getRoleId());
				session.setAttribute("account", userAuthen.getUsername());
				session.setMaxInactiveInterval(0);
				redirect.addFlashAttribute("message", "Đăng nhập thành công");
				redirect.addFlashAttribute("alerted", "success");
				Thread.sleep(2000);
				return new ModelAndView("redirect:/api/employee/get");
			} else {
				redirect.addFlashAttribute("message", "Tài khoản không tồn tại");
				redirect.addFlashAttribute("alerted", "warning");
				return new ModelAndView("redirect:/api/account/login");
			}
		}

	}

	@RequestMapping("user-change-password")
	public String changePasswordForm(HttpSession session) {
		if (sessionInvalid(session)) {
			return "redirect:/api/account/login";
		}
		return "account/user-change-password";
	}

	@RequestMapping(params = "changePassword", method = RequestMethod.POST)
	public ModelAndView doChangePassword(HttpSession session, RedirectAttributes reAt, ModelAndView mav,
			@RequestParam("current_password") String current_password, @RequestParam("new_password") String newPassword,
			@RequestParam("re_new_password") String re_new_password) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		}
		AccountChangePassword accountService = new AccountChangePassword();
		try {
			if (accountService.isPasswordAccount(current_password)) {
				if (newPassword.equalsIgnoreCase(re_new_password)) {
					AccountChangePasswordRequest request = new AccountChangePasswordRequest();
					request.setUser_role_id(userAuthen.getUser_role_id());
					request.setPassword(newPassword);

					accountService.changePassword(request);
					reAt.addFlashAttribute("message", "Đổi mật khẩu thành công.");
					reAt.addFlashAttribute("alerted", "success");
				} else {
					reAt.addFlashAttribute("message", "Xác nhận mật khẩu mới không hợp lệ.");
					reAt.addFlashAttribute("alerted", "warning");
				}

			} else {
				reAt.addFlashAttribute("message", "Mật khẩu cũ không chính xác.");
				reAt.addFlashAttribute("alerted", "warning");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav = new ModelAndView("redirect:/api/account/user-change-password");
		return mav;

	}

	/**
	 * @param session Permission: ADMIN
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpSession session, Model model, RedirectAttributes redirect) throws Exception {
		if (session.getAttribute("account") == null) {
			redirect.addFlashAttribute("message", "Vui lòng đăng nhập");
			redirect.addFlashAttribute("alerted", "warning");
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == ADMIN) {
			List<AccountRegisterGetEmployeeNameResponse> listEmployee = service.getListEmployeeName();
			List<AccountRegisterGetRoleResponse> listRole = service.getListRole();
			model.addAttribute("employee", listEmployee);
			model.addAttribute("role", listRole);
			return new ModelAndView("account/register");
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("account");
		return "redirect:/api/account/login";
	}

	@RequestMapping(params = "createAccount")
	public ModelAndView createAccount(HttpSession session, Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("role_id") int role_id,
			@RequestParam("employee_id") int employee_id, RedirectAttributes redirect) throws Exception {

		String created_by = userAuthen.getUsername();
		String last_modifier_by = userAuthen.getUsername();
		Account account = new Account(role_id, employee_id, username, password, created_by, last_modifier_by);
		AccountRegister.registerAccount(account);

		redirect.addFlashAttribute("message", "Đăng ký thành công");
		redirect.addFlashAttribute("alerted", "success");
		return new ModelAndView("redirect:/api/account/register");
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
	public ModelAndView doForgotPassword(@RequestParam("emailReset") String emailReset, Model model,
			RedirectAttributes redirect) {
		if (accountResetPassword.getEmailAccount(emailReset) == null) {
			redirect.addFlashAttribute("message", "Email không tồn tại trên hệ thống");
			redirect.addFlashAttribute("alerted", "warning");
			return new ModelAndView("redirect:/api/account/forgot-password");
		}

		accountResetEntity.setEmail(emailReset);
		try {
			accountResetPassword.sendCode(emailReset);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("/account/verifycode");

	}

	@RequestMapping(params = "submitCode")
	public ModelAndView doSubmitCode(@RequestParam("code") int code, RedirectAttributes redirect) {
		if (accountResetPassword.submitCode(code)) {

			return new ModelAndView("account/changepassword");
		} else {
			redirect.addFlashAttribute("message", "Mã xác nhận không hợp lệ, vui lòng thử lại");
			redirect.addFlashAttribute("alerted", "warning");
			return new ModelAndView("redirect:/api/account/verify-code");
		}

	}

	@RequestMapping(params = "submitPassword")
	public ModelAndView doSubmitPassword(Model model, @RequestParam("password") String password,
			@RequestParam("re-password") String verifyPassword, RedirectAttributes redirect) {

		ModelAndView modelAndViewReset = new ModelAndView("redirect:/api/account/change-password");
		ModelAndView modelAndViewResetSuccess = new ModelAndView("redirect:/api/account/login");
		AccountVerifyPasswordRequest request = new AccountVerifyPasswordRequest();
		request.setPassword(password);
		request.setVerifyPassword(verifyPassword);
		if (accountResetPassword.resetPasswordAccount(request)) {
			AccountResetPasswordRequest requestEmail = new AccountResetPasswordRequest(accountResetEntity.getEmail(),
					password, userAuthen.getUsername());

			account.updatePasswordByEmail(requestEmail);
			redirect.addFlashAttribute("message", "Đổi mật khẩu thành công");
			redirect.addFlashAttribute("alerted", "success");
			return modelAndViewResetSuccess;
		} else {
			redirect.addFlashAttribute("message", "Xác nhận mật khẩu không đúng");
			redirect.addFlashAttribute("alerted", "warning");
			return modelAndViewReset;
		}
	}

}
