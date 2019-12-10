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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpt.hr_management.daoImpl.LeaveImpl;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.daoImpl.holiday_info.HolidayGetTotal;
import com.fpt.hr_management.daoImpl.holiday_info.HolidayInfoAdd;
import com.fpt.hr_management.listener.request.holiday_info.HolidayAddRequest;
import com.fpt.hr_management.listener.request.leave.LeaveAddRequest;
import com.fpt.hr_management.listener.request.leave.LeaveUpdateRequest;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

@Controller
@RequestMapping("api/employee/leave")
public class EmployeeLeaveController extends AccountLogin {
	private LeaveImpl service = new LeaveImpl();
	private HolidayInfoAdd serviceHoliday = new HolidayInfoAdd();
	private int employee_id;

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
			employee_id = listEmployeeLeave.get(i).getEmployee_id();
		}
		model.addAttribute("count", count);
		model.addAttribute("listEmployeeLeave", listEmployeeLeave);
		model.addAttribute("roleId", userAuthen.getRoleId());
		model.addAttribute("roleName", userAuthen.getRoleName());

		String employeeLeave = "/employee/leave";
		String profile = "redirect:/api/employee/update/" + userAuthen.getUser_id();
		String[] str = { employeeLeave, profile };

		HolidayGetTotal serviceHoliday = new HolidayGetTotal();
		String dateMin = serviceHoliday.getMinDateHoliday(employee_id);
		String dateMax = serviceHoliday.getMaxDateHoliday(employee_id);
		int approved = serviceHoliday.holidayGetTotal(dateMin, dateMax, 1, employee_id);
		int notApproved = serviceHoliday.holidayGetTotal(dateMin, dateMax, 0, employee_id);
		
		model.addAttribute("approved", approved);
		model.addAttribute("notApproved", notApproved);
		model.addAttribute("dateMin", dateMin);
		model.addAttribute("dateMax", dateMax);
		int approved_left = 12 - approved;
		model.addAttribute("approved-left", approved_left);

		return str[0];
	}

	@RequestMapping(value = "/accept/{id}")
	public String doUpdateLeaveAccept(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		if (userAuthen.getRoleId() == 1 || userAuthen.getRoleId() == 2) {
			LeaveUpdateRequest request = new LeaveUpdateRequest();
			try {
				request.setEmployee_accept(userAuthen.getUsername());
				request.setAccept_status(1);
				request.setLast_modifier_by(userAuthen.getUsername());
				request.setIdRecord(id);
				service.leaveUpdate(request);

				HolidayAddRequest requestHoliday = new HolidayAddRequest(employee_id, 1);
				serviceHoliday.add(requestHoliday);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			model.addAttribute("permission", "Bạn không có quyền thao tác.");
		}

		return "redirect:/api/employee/leave/get";
	}

	@RequestMapping(value = "/cancel/{id}")
	public String doUpdateLeaveCancel(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		if (userAuthen.getRoleId() == 1 || userAuthen.getRoleId() == 2) {
			LeaveUpdateRequest request = new LeaveUpdateRequest();
			try {
				request.setEmployee_accept(userAuthen.getUsername());
				request.setAccept_status(2);
				request.setLast_modifier_by(userAuthen.getUsername());
				request.setIdRecord(id);
				service.leaveUpdate(request);

				HolidayAddRequest requestHoliday = new HolidayAddRequest(employee_id, 0);
				serviceHoliday.add(requestHoliday);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.addAttribute("permission", "Bạn không có quyền thao tác.");
		}

		return "redirect:/api/employee/leave/get";
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
