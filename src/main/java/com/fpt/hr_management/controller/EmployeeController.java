package com.fpt.hr_management.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.fpt.hr_management.daoImpl.EmployeeImpl;
import com.fpt.hr_management.daoImpl.LeaveImpl;
import com.fpt.hr_management.daoImpl.RelationsPersonalImpl;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.daoImpl.account.AccountRegisterEmployeeGetName;
import com.fpt.hr_management.daoImpl.department.DepartmentEmployeeGetOne;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.daoImpl.employee.EmployeeValidator;
import com.fpt.hr_management.daoImpl.employee_skill.SkillEmployeeGetOne;
import com.fpt.hr_management.listener.request.department.DepartmentEmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeUpdateRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.relations_personnal.RPGetOneRequest;
import com.fpt.hr_management.listener.response.account.AccountRegisterGetEmployeeNameResponse;
import com.fpt.hr_management.listener.response.department.DepartmentEmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetAllResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.employee_skill.SkillEmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;
import com.fpt.hr_management.listener.response.relations_personal.RPListGetOneResponse;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController extends AccountLogin {

	private static EmployeeImpl service = new EmployeeImpl();
	private static LeaveImpl serviceLeave = new LeaveImpl();
	private static RelationsPersonalImpl serviceRP = new RelationsPersonalImpl();
	private static final String pattern = "yyyy-MM-dd";
	private static EmployeeValidator validator = new EmployeeValidator();

	@RequestMapping("/get")
	public String getListEmployee(Model model, HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		if (userAuthen.getRoleId() == 1) {
			List<EmployeeGetAllResponse> employeeList = new ArrayList<EmployeeGetAllResponse>();
			employeeList = service.employeeListGetAll();
			if (employeeList.size() == 0) {
				model.addAttribute("message", "Danh sách nhân viên trống");
			}
			model.addAttribute("employeeList", employeeList);

		}

		else if (userAuthen.getRoleId() == 0) {
			model.addAttribute("messsage", "Bạn không có quyền");
		} else {
			return "redirect:/api/employee/update/" + userAuthen.getUser_id();
		}

		model.addAttribute("accountName", userAuthen.getUsername());
		model.addAttribute("roleName", userAuthen.getRoleName());
		model.addAttribute("roleId", userAuthen.getRoleId());
		model.addAttribute("accountId", userAuthen.getUser_id());

		return "employee/PersonInfo";
	}

	@RequestMapping("add")
	public String addEmployee(HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}
		if (userAuthen.getRoleId() == 1) {

			AccountRegisterEmployeeGetName employeeName = new AccountRegisterEmployeeGetName();
			List<AccountRegisterGetEmployeeNameResponse> listEmployeeName = new ArrayList<AccountRegisterGetEmployeeNameResponse>();
			listEmployeeName = employeeName.getListEmployee();
			if (listEmployeeName.size() == 0) {
				model.addAttribute("message", "Lỗi hệ thống, không thể lấy danh sách người quản lý.");
			} else {
				model.addAttribute("listEmployeeName", listEmployeeName);
			}
		} else {
			return "redirect:/api/authorized/403";
		}

		model.addAttribute("roleId", userAuthen.getRoleId());
		return "employee/add-employee";
	}

	@RequestMapping(params = "createAccount")
	public ModelAndView doAddEmployee(@RequestParam("first_name") String first_name,
			@RequestParam("middle_name") String middle_name, @RequestParam("last_name") String last_name,
			@RequestParam("dob") String dob, @RequestParam("sex") int sex, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("phone") String phone,
			@RequestParam("employee_type_id") int employee_type_id, @RequestParam("note") String note,
			@RequestParam("manager_id") int manager_id, HttpSession session, Model model) {

		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 1) {
			String created_by = userAuthen.getUsername();
			EmployeeAddRequest request = null;
			try {
				SimpleDateFormat sdfDob = new SimpleDateFormat(pattern);
				java.util.Date dobDate = sdfDob.parse(dob);
				Date dobDateSql = new Date(dobDate.getTime());

				if (validator.dob(validator.getYear(dobDateSql))) {
					request = new EmployeeAddRequest(first_name, middle_name, last_name, phone, email, dobDateSql,
							address, sex, employee_type_id, note, created_by, manager_id);

					service.employeeAdd(request);
					model.addAttribute("alert", "success");
					model.addAttribute("message", "Thành công.");
				} else {
					model.addAttribute("message", "Người này chưa đủ 18 tuổi.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

		return new ModelAndView("employee/add-employee");
	}

	@RequestMapping(value = "update/{id}")
	public String updateEmployee(@PathVariable("id") int id, Model model, RedirectAttributes redirect) {

		// Basic information employee
		List<EmployeeGetOneResponse> infoEmployee = new ArrayList<EmployeeGetOneResponse>();
		EmployeeGetOneRequest request = new EmployeeGetOneRequest();
		request.setId(id);
		infoEmployee = service.employeeGetOne(request);
		model.addAttribute("infoEmployee", infoEmployee);

		// Basic department employee
		List<DepartmentEmployeeGetOneResponse> listEmployeeDepartment = new ArrayList<DepartmentEmployeeGetOneResponse>();
		DepartmentEmployeeGetOne departmentEmployee = new DepartmentEmployeeGetOne();
		DepartmentEmployeeGetOneRequest requestEmployeeDepartment = new DepartmentEmployeeGetOneRequest(id);
		listEmployeeDepartment = departmentEmployee.employeeDepartmentInfo(requestEmployeeDepartment);
		model.addAttribute("listEmployeeDepartment", listEmployeeDepartment);

		// basic skill employee
		List<SkillEmployeeGetOneResponse> listSkillEmployee = new ArrayList<SkillEmployeeGetOneResponse>();
		SkillEmployeeGetOne skillEmployee = new SkillEmployeeGetOne();
		SkillEmployeeGetOneRequest requestEmployeeSkill = new SkillEmployeeGetOneRequest();
		requestEmployeeSkill.setEmployeeId(id);
		listSkillEmployee = skillEmployee.info(requestEmployeeSkill);
		model.addAttribute("listSkillEmployee", listSkillEmployee);
		model.addAttribute("username", userAuthen.getUsername());
		model.addAttribute("role", userAuthen.getRoleName());
		model.addAttribute("idAccount", id);

		// Leave list
		List<LeaveListGetAllResponse> listEmployeeLeave = new ArrayList<LeaveListGetAllResponse>();
		listEmployeeLeave = serviceLeave.leaveListGetAll();
		int count = 0;
		for (int i = 0; i < listEmployeeLeave.size(); i++) {
			if (listEmployeeLeave.get(i).getAccept_status() == 0) {
				count++;
			}
		}
		model.addAttribute("count", count);
		model.addAttribute("listEmployeeLeave", listEmployeeLeave);
		model.addAttribute("roleId", userAuthen.getRoleId());
		model.addAttribute("roleName", userAuthen.getRoleName());

		// Relation personal
		List<RPListGetOneResponse> listRPEmployee = new ArrayList<RPListGetOneResponse>();
		RPGetOneRequest requestRP = new RPGetOneRequest();
		requestRP.setEmployee_id(userAuthen.getUser_id());
		listRPEmployee = serviceRP.listRP(requestRP);
		model.addAttribute("listRPEmployee", listRPEmployee);

		return "employee/profile";
	}

	@RequestMapping(params = "updateAccount")
	public ModelAndView doUpdateEmployee(@RequestParam("first_name") String first_name,
			@RequestParam("middle_name") String middle_name, @RequestParam("last_name") String last_name,
			@RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("dob") String dob,
			@RequestParam("address") String address, @RequestParam("gender") int sex,
			@RequestParam("employee_date") String employee_date, @RequestParam("end_date") String end_date,
			@RequestParam("employee_type_id") int employee_type_id, @RequestParam("status") int status,
			@RequestParam("note") String note, HttpSession session, RedirectAttributes redirect, ModelAndView mav) {

		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		EmployeeUpdateRequest request = null;
		try {

			Date employeeDateSql = null;
			Date dobDateSql = null;
			Date endDateSql = null;

			if (dob != "" || dob.length() > 0) {
				SimpleDateFormat sdfDobDate = new SimpleDateFormat(pattern);
				java.util.Date dobDate = sdfDobDate.parse(dob);
				dobDateSql = new Date(dobDate.getTime());
			} else {
				dob = null;
			}

			if (employee_date != "" || employee_date.length() > 0) {
				SimpleDateFormat sdfEmployeeDate = new SimpleDateFormat(pattern);
				java.util.Date employeeDate = sdfEmployeeDate.parse(employee_date);
				employeeDateSql = new Date(employeeDate.getTime());
			} else {
				employee_date = null;
			}

			if (end_date != "" || end_date.length() > 0) {
				SimpleDateFormat sdfEndDate = new SimpleDateFormat(pattern);
				java.util.Date endDate = sdfEndDate.parse(end_date);
				endDateSql = new Date(endDate.getTime());
			} else {
				end_date = null;
			}

			String last_modifier_by = userAuthen.getUsername();

			if (!validator.dob(validator.getYear(dobDateSql))) {
				redirect.addFlashAttribute("message", "Ngày sinh không hợp lệ.");
				redirect.addFlashAttribute("alerted", "warning");
				mav = new ModelAndView("redirect:/api/employee/update/" + userAuthen.getUser_id());
				return mav;
			}

			request = new EmployeeUpdateRequest(userAuthen.getUser_id(), first_name, middle_name, last_name, phone,
					email, dobDateSql, address, sex, employeeDateSql, endDateSql, employee_type_id, status, note,
					last_modifier_by);

			service.employeeUpdate(request);
			redirect.addFlashAttribute("message", "Cập nhật thành công.");
			redirect.addFlashAttribute("alerted", "success");
			mav = new ModelAndView("redirect:/api/employee/update/" + userAuthen.getUser_id());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			HttpServletRequest req, RedirectAttributes redirect, Model model) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}
		String rootUrl = req.getRequestURI().toString();
		System.out.println(rootUrl);
		try {
			mav = new ModelAndView("redirect:/api/employee/get");
			if (userAuthen.getRoleId() != 1) {
				return new ModelAndView("redirect:/api/authorized/403");
			}

			if (userAuthen.getRoleId() == 1) {
				EmployeeDeleteRequest request = new EmployeeDeleteRequest();
				request.setId(id);
				EmployeeGetOne employeeGetOne = new EmployeeGetOne();
				EmployeeGetOneRequest requestId = new EmployeeGetOneRequest();
				requestId.setId(id);
				if (employeeGetOne.getInfoEmployee(requestId).isEmpty()) {
					redirect.addFlashAttribute("message", "Xóa thất bại.");
					redirect.addFlashAttribute("alerted", "warning");
				} else {
					service.employeeDelete(request);
					redirect.addFlashAttribute("message", "Xóa thành công.");
					redirect.addFlashAttribute("alerted", "success");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
