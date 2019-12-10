package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.hr_management.daoImpl.AllowancesImpl;
import com.fpt.hr_management.daoImpl.allowances.AllowanceGetAll;
import com.fpt.hr_management.daoImpl.allowances.AllowanceGetOneByEmployee;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.listener.request.allowances.AllowanceAddRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceGetOneByEmployeeRequest;
import com.fpt.hr_management.listener.request.allowances.AllowanceUpdateRequest;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetAllResponse;
import com.fpt.hr_management.listener.response.allowances.AllowanceGetOneByEmployeeResponse;

@Controller
@RequestMapping("/api/employee/allowance")
public class AllowanceController extends AuthenticationAccount {

	private AllowancesImpl service = new AllowancesImpl();
	private int employeeId;
	private int allowaneId;

	@RequestMapping("add/{id}")
	public String addAllowance(@PathVariable("id") int id, Model model) {
		employeeId = id;
		String employeeName = new EmployeeGetOne().findName(employeeId);
		model.addAttribute("employeeName", employeeName);
		model.addAttribute("accountId", employeeId);
		List<AllowanceGetAllResponse> listAllowance = new AllowanceGetAll().getName();
		model.addAttribute("listAllowance", listAllowance);
		return "allowances/allowance-add";
	}

	@RequestMapping(params = "addAllowance")
	public ModelAndView doAddAllowance(Model model,
			@RequestParam("salary_allowance_type_id") int salary_allowance_type_id,
			@RequestParam("total_salary") long total_salary, ModelAndView mav, RedirectAttributes redirect,
			HttpSession session) {

		mav = new ModelAndView("redirect:/api/employee/allowance/add/" + employeeId);
		if (!sessionInvalid(session)) {
			try {
				String created_by = userAuthen.getUsername();
				String last_modifier_by = userAuthen.getUsername();
				service.allowancesAdd(new AllowanceAddRequest(salary_allowance_type_id, total_salary, created_by,
						last_modifier_by, employeeId));
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			} catch (Exception e) {
				redirect.addFlashAttribute("message", "Thất bại.");
				redirect.addFlashAttribute("alerted", "warning");
				e.printStackTrace();
			}
		} else {
			return new ModelAndView("redirect:/api/account/login");
		}

		return mav;
	}

	@RequestMapping(value = "update/{id}")
	public String updateAllowance(@PathVariable("id") int id, HttpSession session, Model model) {
		if (sessionInvalid(session)) {
			return "redirect:/api/account/login";
		}

		AllowanceGetOneByEmployee serviceGetOne = new AllowanceGetOneByEmployee();
		List<AllowanceGetOneByEmployeeResponse> listAllowance = serviceGetOne
				.getOne(new AllowanceGetOneByEmployeeRequest(id));
		model.addAttribute("listAllowance", listAllowance);
		return "allowances/allowance-update";
	}

	@RequestMapping(params = "updateAllowance")
	public ModelAndView doUpdateAllowance(@RequestParam("saTypeId") int saTypeId,
			@RequestParam("saTotalSalary") long saTotalSalary, HttpSession session, ModelAndView mav,
			RedirectAttributes redirect, Model model) {
		try {
			mav = new ModelAndView("redirect:/api/employee/allownce/add" + employeeId);
			if (userAuthen.getRoleId() != 1) {
				return new ModelAndView("redirect:/api/authorized/403");
			}

			if (userAuthen.getRoleId() == 1) {
				service.allowancesUpdate(new AllowanceUpdateRequest(allowaneId, saTypeId, saTotalSalary));
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("message", "Thất bại.");
			redirect.addFlashAttribute("alerted", "warning");
			e.printStackTrace();
		}

		return mav;
	}
}
