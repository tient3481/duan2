package com.fpt.hr_management.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.hr_management.daoImpl.LeaveImpl;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

@Controller
@RequestMapping("api/employee/leave")
public class LeaveController extends AccountLogin {
	private LeaveImpl service = new LeaveImpl();

	@RequestMapping(value = "/get")
	public String getListEmployeeLeave(HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}
		List<LeaveListGetAllResponse> listEmployeeLeave = new ArrayList<LeaveListGetAllResponse>();
		listEmployeeLeave = service.leaveListGetAll();
		int count = 0;
		for (int i = 0; i < listEmployeeLeave.size(); i++) {
			if (listEmployeeLeave.get(i).getAccept_status() == 0) {
				count++;
			}
		}
		System.out.println("count: " + count);
		model.addAttribute("count", count);
		model.addAttribute("listEmployeeLeave", listEmployeeLeave);
		model.addAttribute("roleId", userAuthen.getRoleId());
		model.addAttribute("roleName", userAuthen.getRoleName());
		return "/employee/leave";
	}

	@RequestMapping(value = "/add")
	public String leaveAdd(Model model, HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}
		List<LeaveListGetAllResponse> leaveList = new ArrayList<LeaveListGetAllResponse>();
		List<LeaveListGetAllResponse> listReasonName = new ArrayList<LeaveListGetAllResponse>();
		listReasonName = service.getReasonName();
		leaveList = service.leaveListGetAll();
		model.addAttribute("leaveList", leaveList);
		model.addAttribute("listReasonName", listReasonName);
		model.addAttribute("userid", userAuthen.getUser_id());

		return "employee/LeaveRegister";
	}

	@RequestMapping(params = "createLeave", method = RequestMethod.GET)
	public String doleaveAdd(Model model, HttpSession session, @RequestParam("reason_id") int reason_id,
			@RequestParam("start_date") Date start_date, @RequestParam("end_date") Date end_date,
			@RequestParam("start_time") String start_time, @RequestParam("end_time") String end_time,
			@RequestParam("note") String note) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		System.out.println("start_date: " + start_date + "; end_date: " + end_date + "; start_time: " + start_time
				+ "; end_time: " + end_time);

		try {
			DateFormat formatter = new SimpleDateFormat("HH:mm");
			Time startTime = new Time(formatter.parse(start_time).getTime());
			Time endTime = new Time(formatter.parse(end_time).getTime());

			int employee_id = userAuthen.getUser_id();
			String created_by = userAuthen.getUsername(), last_modifier_by = userAuthen.getUsername();
			LeaveAddRequest request = new LeaveAddRequest(employee_id, reason_id, start_date, end_date, startTime,
					endTime, note, created_by, last_modifier_by);
			service.leaveAdd(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "employee/LeaveRegister";
	}

}
