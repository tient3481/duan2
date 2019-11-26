package com.fpt.hr_management.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.hr_management.daoImpl.CheckInOutImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.checkinout.CheckInAdd;
import com.fpt.hr_management.listener.request.checkin.CheckInAddRequest;
import com.fpt.hr_management.listener.request.checkin.CheckInUserRequest;
import com.fpt.hr_management.listener.request.checkin.CheckOutUpdateRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckInGetAllResponse;

@Controller
@RequestMapping("/api/employee")
public class CheckInController extends AuthenticationAccount {
	private CheckInOutImpl service = new CheckInOutImpl();

	@RequestMapping("checkin")
	public String checkIn(Model model, HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		List<CheckInGetAllResponse> employeeList = new ArrayList<CheckInGetAllResponse>();
		CheckInUserRequest request = new CheckInUserRequest();
		request.setId(userAuthen.getUser_id());
		employeeList = service.listCheckIn(request);
		model.addAttribute("employeeList", employeeList);
		return "checkin/CheckInInfo";
	}

	@RequestMapping(params = "checkin")
	public String checkInAdd(HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		CheckInAddRequest request = new CheckInAddRequest();
		request.setUser_id(userAuthen.getUser_id());
		service.addCheckIn(request);
		session.setAttribute("user", service);
		session.setMaxInactiveInterval(86400);
		return "redirect:/api/employee/checkin";
	}

	@RequestMapping(params = "checkout")
	public String checkOutUpdate(HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		if (CheckInAdd.inCheckIn.getKeyGenerate() >= 0) {
			CheckOutUpdateRequest request = new CheckOutUpdateRequest();
			request.setId(CheckInAdd.inCheckIn.getKeyGenerate());
			service.updateCheckIn(request);
		} else {
			model.addAttribute("message", "Bạn chưa checkin");
		}

		return "redirect:/api/employee/checkin";
	}

	public static void hourWorkOneDay(CheckInGetAllResponse data) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

		java.util.Date date = new java.util.Date(sdf.parse(data.getDate()).getTime());
		java.util.Date time1 = dateFormat.parse(data.getCheck_in_time());
		java.util.Date time2 = dateFormat.parse(data.getCheck_out_time());

		Calendar calendarDate = Calendar.getInstance();
		Calendar calendarTime1 = Calendar.getInstance();
		Calendar calendarTime2 = Calendar.getInstance();
		calendarDate.setTime(date);
		calendarTime1.setTime(time1);
		calendarTime2.setTime(time2);

		long diff = time2.getTime() - time1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;

	}

	public static void main(String[] args) {
		CheckInGetAllResponse data = new CheckInGetAllResponse();
		data.setDate("2019-02-02");
		data.setCheck_in_time("08:30:03");
		data.setCheck_out_time("08:30:04");
		try {
			hourWorkOneDay(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
