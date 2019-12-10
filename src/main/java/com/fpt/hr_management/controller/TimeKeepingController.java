package com.fpt.hr_management.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.time_keeping.TimeKeepingGetAll;
import com.fpt.hr_management.listener.request.TimeKeeping.TimeKeepingGetAllRequest;
import com.fpt.hr_management.listener.response.time_keeping.TimeKeepingGetAllResponse;

@Controller
@RequestMapping("api/employee/checkin-realtime")
public class TimeKeepingController extends AuthenticationAccount {

	private TimeKeepingGetAll service = new TimeKeepingGetAll();

	@RequestMapping("/get/{id}")
	public String getRealTime(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		List<TimeKeepingGetAllResponse> employeeList = new ArrayList<TimeKeepingGetAllResponse>();
		TimeKeepingGetAllRequest request = new TimeKeepingGetAllRequest(id);
		employeeList = service.getInfoLastCheckIn(request);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("accountId", userAuthen.getUser_id());

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormatter = sdf.format(date);
		model.addAttribute("dateFormatter", dateFormatter);

		return "checkin/CheckInRealTime";
	}

	@RequestMapping(params = "verifyCheckIn")
	public ModelAndView doVerifyCheckIn(HttpSession session, ModelAndView mav, RedirectAttributes reAt) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}
		mav = new ModelAndView("redirect:/api/employee/checkin-realtime/get/" + userAuthen.getUser_id());
		if (service.timeKeeping(new TimeKeepingGetAllRequest(userAuthen.getUser_id()))) {
			reAt.addFlashAttribute("message", "Xác nhận thành công");
			reAt.addFlashAttribute("alerted", "success");
		} else {
			reAt.addFlashAttribute("message", "Bạn đã xác nhận chấm công ngày hôm nay.");
			reAt.addFlashAttribute("alerted", "warning");
		}

		return mav;
	}

}
