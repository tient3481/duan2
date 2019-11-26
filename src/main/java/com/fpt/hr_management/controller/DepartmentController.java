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

import com.fpt.hr_management.daoImpl.DepartmentImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.department.DepartmentAddRequest;
import com.fpt.hr_management.listener.request.department.DepartmentDeleteRequest;
import com.fpt.hr_management.listener.request.department.DepartmentGetOneRequest;
import com.fpt.hr_management.listener.request.department.DepartmentUpdateRequest;
import com.fpt.hr_management.listener.response.department.DepartmentGetOneResponse;
import com.fpt.hr_management.listener.response.department.DepartmentListGetAllResponse;

@RequestMapping("api/department")
@Controller
public class DepartmentController extends AuthenticationAccount {

	private DepartmentImpl service = new DepartmentImpl();
	private int departmentId;

	@RequestMapping("get")
	public String listDepartment(HttpSession session, Model model) {
		if (session.getAttribute("account") != null) {
			List<DepartmentListGetAllResponse> listDepartment = service.departmentListGetAll();
			model.addAttribute("listDepartment", listDepartment);

			model.addAttribute("roleId", userAuthen.getRoleId());
			return "department/list-department";
		} else {
			return "redirect:/api/account/login";
		}
	}

	@RequestMapping("add")
	public String addForm(HttpSession session) {
		if (session.getAttribute("account") != null && userAuthen.getRoleId() == 0) {
			return "department/add-department";
		}

		return "redirect:/api/authorized/403";

	}

	@RequestMapping(params = "addDepartment")
	public ModelAndView doAddDepartment(@RequestParam("name") String name, @RequestParam("phone") String phone,
			@RequestParam("location") String location, HttpSession session, RedirectAttributes reAt, ModelAndView mav) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 0) {
			String created_by = userAuthen.getUsername();
			String last_modifier_by = userAuthen.getUsername();
			int id = 190299;
			DepartmentAddRequest request = new DepartmentAddRequest(id, name, phone, location, created_by,
					last_modifier_by);
			service.departmentAdd(request, id);

			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("message", "Thành công.");
			mav = new ModelAndView("redirect:/api/department/add");
			return mav;
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

	}

	@RequestMapping(value = "update/{id}")
	public String updateDepartment(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}
		departmentId = id;
		List<DepartmentGetOneResponse> listDepartmentInfo = service
				.departmentGetOne(new DepartmentGetOneRequest(departmentId));

		model.addAttribute("listDepartmentInfo", listDepartmentInfo);

		return "department/update-department";
	}

	@RequestMapping(params = "updateDepartment")
	public ModelAndView updateDepartment(@RequestParam("name") String name, @RequestParam("phone") String phone,
			@RequestParam("location") String location, HttpSession session, RedirectAttributes reAt, ModelAndView mav) {

		mav = new ModelAndView("redirect:/api/department/update/" + departmentId);
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}
		String last_modifier_by = userAuthen.getUsername();
		DepartmentUpdateRequest request = new DepartmentUpdateRequest(departmentId, name, phone, location,
				last_modifier_by);
		try {
			service.departmentUpdate(request);
			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("message", "Thành công.");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteDepartment(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			RedirectAttributes reAt) {

		mav = new ModelAndView("redirect:/api/department/get");
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		try {
			DepartmentDeleteRequest request = new DepartmentDeleteRequest(id);
			service.departmentDelete(request.getId());
			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("messsage", "Xóa thành công.");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
