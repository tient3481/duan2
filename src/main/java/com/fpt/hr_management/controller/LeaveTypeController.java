package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.hr_management.daoImpl.LeaveTypeImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeAddRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeDeleteRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeListGetOneRequest;
import com.fpt.hr_management.listener.request.leave_type.LeaveTypeUpdateRequest;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetAllResponse;
import com.fpt.hr_management.listener.response.leave_type.LeaveTypeListGetOneResponse;

@RequestMapping("/api/leave_type")
@Controller
public class LeaveTypeController extends AuthenticationAccount {

	private LeaveTypeImpl service = new LeaveTypeImpl();
	private int leaveTypeId = 0;

	@RequestMapping("get")
	public String getListLeaveType(Model model, HttpSession session) {
		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() == 0) {
				List<LeaveTypeListGetAllResponse> listLeaveType = service.leaveTypeListGetAll();
				model.addAttribute("listLeaveType", listLeaveType);
				return "leave_type/list-leave-type";
			} else {
				return "redirect:/api/authorized/403";
			}
		} else {
			return "redirect:/api/account/login";
		}

	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteLeaveType(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			HttpServletRequest req, RedirectAttributes redirect, Model model) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		}
		try {
			mav = new ModelAndView("redirect:/api/leave_type/get");
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			}

			if (userAuthen.getRoleId() == 0) {
				service.leaveTypeDelete(new LeaveTypeDeleteRequest(id));
				redirect.addFlashAttribute("message", "Xóa thành công.");
				redirect.addFlashAttribute("alerted", "success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping("add")
	public ModelAndView addSKill(HttpSession session, Model model, RedirectAttributes redirect, ModelAndView mav) {
		mav = new ModelAndView("redirect:/api/account/login");
		if (!sessionInvalid(session)) {
			return new ModelAndView("leave_type/add-leave-type");
		} else {
			redirect.addFlashAttribute("message", "Phiên làm việc đã hết hạn, vui lòng đăng nhập lại.");
			redirect.addFlashAttribute("alerted", "warning");
			return mav;
		}

	}

	@RequestMapping(params = "addLeaveType")
	public ModelAndView doAddSKill(HttpSession session, ModelAndView mav, RedirectAttributes redirect,
			@RequestParam("name") String name, @RequestParam("note") String note) {

		String created_by = userAuthen.getUsername();
		String last_modifier_by = userAuthen.getUsername();
		mav = new ModelAndView("redirect:/api/leave_type/add");

		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			} else {
				service.leaveTypeAdd(new LeaveTypeAddRequest(name, note, created_by, last_modifier_by));
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			}
		} else {

		}
		return mav;
	}

	@RequestMapping("update/{id}")
	public String updateSkill(@PathVariable("id") int id, HttpSession session, Model model) {
		if (sessionInvalid(session)) {
			return "redirect:/api/account/login";
		}

		LeaveTypeListGetOneRequest request = new LeaveTypeListGetOneRequest(id);
		List<LeaveTypeListGetOneResponse> listLeaveTypeGetOne = service.getOne(request);
		System.out.println(listLeaveTypeGetOne.toString());
		model.addAttribute("listLeaveTypeGetOne", listLeaveTypeGetOne);
		for (int i = 0; i < listLeaveTypeGetOne.size(); i++) {
			leaveTypeId = listLeaveTypeGetOne.get(i).getId();
		}

		return "leave_type/update-leave-type";

	}

	@RequestMapping(params = "updateLeaveType")
	public ModelAndView doUpdateSkill(HttpSession session, RedirectAttributes redirect, ModelAndView mav,
			@RequestParam("name") String name, @RequestParam("note") String note) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		} else {
			String last_modifier_by = userAuthen.getUsername();
			try {
				LeaveTypeUpdateRequest request = new LeaveTypeUpdateRequest(leaveTypeId, name, note, last_modifier_by);
				service.leaveTypeUpdate(request);
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new ModelAndView("redirect:/api/leave_type/update/" + leaveTypeId);

	}

}
