package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.salary.SalaryGetOne;
import com.fpt.hr_management.listener.request.salary.SalaryListGetOneRequest;
import com.fpt.hr_management.listener.response.salary.SalaryListGetOneResponse;

@Controller
@RequestMapping("/api/employee/salary")
public class SalaryController extends AuthenticationAccount {

	@RequestMapping("get/{id}")
	public String getListSalary(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		id = userAuthen.getUser_id();

		List<SalaryListGetOneResponse> listSalary = new SalaryGetOne().getSalary(new SalaryListGetOneRequest(id));
		model.addAttribute("listSalary", listSalary);
		model.addAttribute("roleId", userAuthen.getRoleId());
		return "salary/salary-info";
	}

	@RequestMapping("details/get")
	public String detailSalary() {
		return "salary/salary-details";
	}
}
