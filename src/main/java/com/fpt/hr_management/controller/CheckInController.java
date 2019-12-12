package com.fpt.hr_management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView checkInAdd(HttpSession session, Model model, HttpServletResponse response,
			RedirectAttributes reAt, ModelAndView mav) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		mav = new ModelAndView("redirect:/api/employee/checkin");
		CheckInAddRequest request = new CheckInAddRequest();
		request.setUser_id(userAuthen.getUser_id());
		service.addCheckIn(request);
		Cookie cookie = new Cookie("userCookie", userAuthen.getUsername());
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
		session.setAttribute("user", service);
		session.setMaxInactiveInterval(0);

		reAt.addFlashAttribute("alerted", "success");
		reAt.addFlashAttribute("message", "Check-in thành công.");
		return mav;
	}

	@RequestMapping(params = "checkout")
	public ModelAndView checkOutUpdate(HttpSession session, Model model, HttpServletRequest req,
			RedirectAttributes reAt, ModelAndView mav) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}
		mav = new ModelAndView("redirect:/api/employee/checkin");
		if (CheckInAdd.inCheckIn.getKeyGenerate() == 0) {
			reAt.addFlashAttribute("alerted", "warning");
			reAt.addFlashAttribute("message", "Vui lòng Check-in");
		} else {
			CheckOutUpdateRequest request = new CheckOutUpdateRequest();
			request.setId(CheckInAdd.inCheckIn.getKeyGenerate());
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userCookie")) {
					service.updateCheckIn(request);
					reAt.addFlashAttribute("alerted", "success");
					reAt.addFlashAttribute("message", "Check-out thành công.");
					break;
				} else {
					reAt.addFlashAttribute("alerted", "warning");
					reAt.addFlashAttribute("message", "Session time out...");
					System.out.println("Time out account for user: " + userAuthen.getUsername());
				}
			}
			return mav;
		}

		return mav;
	}
}
