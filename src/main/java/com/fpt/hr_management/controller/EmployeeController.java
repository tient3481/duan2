package com.fpt.hr_management.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpt.hr_management.daoImpl.EmployeeImpl;
import com.fpt.hr_management.daoImpl.account.AccountLogin;
import com.fpt.hr_management.daoImpl.department.DepartmentEmployeeGetOne;
import com.fpt.hr_management.daoImpl.skillemployee.SkillEmployeeGetOne;
import com.fpt.hr_management.listener.request.department.DepartmentEmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee.EmployeeUpdateRequest;
import com.fpt.hr_management.listener.request.employeeskill.SkillEmployeeGetOneRequest;
import com.fpt.hr_management.listener.response.department.DepartmentEmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetAllResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.skillemployee.SkillEmployeeGetOneResponse;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController extends AccountLogin {

	private static EmployeeImpl service = new EmployeeImpl();

	@RequestMapping("/get")
	public String getList(Model model, HttpSession session) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		List<EmployeeGetAllResponse> employeeList = new ArrayList<EmployeeGetAllResponse>();
		employeeList = service.employeeListGetAll();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("accountName", userAuthen.getUsername());
		model.addAttribute("roleName", userAuthen.getRoleName());
		model.addAttribute("roleId", userAuthen.getRoleId());
		return "employee/PersonInfo";
	}

	@RequestMapping("add")
	public String addEmployee() {
		return "employee/add-employee";
	}

	@RequestMapping(value = "update/{id}")
	public String updateEmployee(@PathVariable("id") int id, Model model) {

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
		
		return "employee/profile";
	}

	@RequestMapping(params = "updateAccount")
	public String doUpdateEmployee(@RequestParam("first_name") String first_name,
			@RequestParam("middle_name") String middle_name, @RequestParam("last_name") String last_name,
			@RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("dob") Date dob,
			@RequestParam("address") String address, @RequestParam("gender") int sex,
			@RequestParam("employee_date") Date employee_date, @RequestParam("end_date") Date end_date,
			@RequestParam("employee_type_id") int employee_type_id, @RequestParam("status") int status,
			@RequestParam("base_salary") long base_salary, @RequestParam("note") String note,
			@RequestParam("id") int id, HttpSession session) {

		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}

		String last_modifier_by = userAuthen.getUsername();
		EmployeeUpdateRequest request = new EmployeeUpdateRequest(id, first_name, middle_name, last_name, phone, email,
				dob, address, sex, employee_date, end_date, employee_type_id, status, base_salary, note,
				last_modifier_by);
		try {
			service.employeeUpdate(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "employee/profile";
	}

	@RequestMapping(params = "createAccount")
	public ModelAndView doAddEmployee(@RequestParam("first_name") String first_name,
			@RequestParam("middle_name") String middle_name, @RequestParam("last_name") String last_name,
			@RequestParam("dob") Date dob, @RequestParam("gender") int sex, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("phone") String phone,
			@RequestParam("employee_type") int employee_type, @RequestParam("note") String note,
			@RequestParam("user_manager") int manager_id, HttpSession session) {

		ModelAndView modelAndViewLogin = new ModelAndView("api/account/login");
		ModelAndView modelAndViewSuccess = new ModelAndView("api/account/login");
		if (session.getAttribute("account") == null) {
			return modelAndViewLogin;
		}

		String created_by = userAuthen.getUsername();
		EmployeeAddRequest request = new EmployeeAddRequest(first_name, middle_name, last_name, dob, sex, email,
				address, phone, employee_type, note, created_by, manager_id);

		service.employeeAdd(request);

		return modelAndViewSuccess;
	}

}
