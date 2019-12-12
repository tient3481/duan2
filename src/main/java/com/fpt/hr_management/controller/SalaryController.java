package com.fpt.hr_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.salary.SalaryService;
import com.fpt.hr_management.listener.request.salary.SalaryPayRequest;
import com.fpt.hr_management.listener.response.salary.SalaryDetail;

@Controller
@RequestMapping("/api/employee/salary")
public class SalaryController extends AuthenticationAccount {

	private int employeeId;

	@RequestMapping("details/get/{id}")
	public String detailSalary(@PathVariable("id") int id, Model model) {
		employeeId = id;
		List<SalaryDetail> salaryDetails = new ArrayList<SalaryDetail>();
		SalaryPayRequest request = new SalaryPayRequest(id);
		salaryDetails = SalaryService.salaryDetail(request);

		model.addAttribute("fromDate", SalaryService.fromDateOfMonth());
		model.addAttribute("toDate", SalaryService.toDateOfMonth());
		model.addAttribute("salaryDetails", salaryDetails);
		return "salary/salary-details";
	}

	@RequestMapping(params = "searchSalary")
	public String detailSalary(Model model, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		List<SalaryDetail> salaryDetails = new ArrayList<SalaryDetail>();
		SalaryPayRequest request = new SalaryPayRequest(employeeId);
		request.setFromDate(fromDate);
		request.setToDate(toDate);
		salaryDetails = SalaryService.salaryDetail(request);
		model.addAttribute("fromDate", fromDate);
		model.addAttribute("toDate", toDate);
		model.addAttribute("salaryDetails", salaryDetails);
		return "salary/salary-details";
	}
}
