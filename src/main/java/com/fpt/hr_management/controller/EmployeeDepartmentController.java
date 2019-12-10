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

import com.fpt.hr_management.daoImpl.EmployeeDepartmentImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.department.DepartmentGetNameAndId;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.daoImpl.employee_department.GetInfoEmployeeAddDepartment;
import com.fpt.hr_management.daoImpl.employee_type.GetEmployeeType;
import com.fpt.hr_management.daoImpl.position.PositionGetNamAndId;
import com.fpt.hr_management.listener.request.employee.EmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentAddRequest;
import com.fpt.hr_management.listener.request.employee_department.EmployeeDepartmentDeleteRequest;
import com.fpt.hr_management.listener.response.department.DepartmentGetNameAndIdResponse;
import com.fpt.hr_management.listener.response.employee.EmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.employee_department.GetInfoEmployeeAddDepartmentResponse;
import com.fpt.hr_management.listener.response.employee_type.EmployeeTypeResponse;
import com.fpt.hr_management.listener.response.position.PositionGetNamAndIdResponse;

@Controller
@RequestMapping("/api/employee/department")
public class EmployeeDepartmentController extends AuthenticationAccount {

	private EmployeeDepartmentImpl service = new EmployeeDepartmentImpl();
	private int employeeId;

	@RequestMapping(value = "add/{id}")
	public String doaddEmployeeDepartment(@PathVariable("id") int id, HttpSession session, Model model) {
		// employee
		GetInfoEmployeeAddDepartment employee = new GetInfoEmployeeAddDepartment();
		List<GetInfoEmployeeAddDepartmentResponse> listEmpNameAndId = employee.getListEmployee();
		model.addAttribute("listEmpNameAndId", listEmpNameAndId);

		// employeeType
		GetEmployeeType employeeType = new GetEmployeeType();
		List<EmployeeTypeResponse> listEmployeeType = employeeType.getListEmployeeType();
		model.addAttribute("listEmployeeType", listEmployeeType);

		// department
		DepartmentGetNameAndId department = new DepartmentGetNameAndId();
		List<DepartmentGetNameAndIdResponse> listDepNameAndId = department.listDepartment();
		model.addAttribute("listDepNameAndId", listDepNameAndId);

		// position
		PositionGetNamAndId position = new PositionGetNamAndId();
		List<PositionGetNamAndIdResponse> listPosNameAndId = position.getListPosition();
		model.addAttribute("listPosNameAndId", listPosNameAndId);

		employeeId = id;
		model.addAttribute("employeeId", id);
		EmployeeGetOne getEmployee = new EmployeeGetOne();
		List<EmployeeGetOneResponse> employeeNameOnce = getEmployee.getInfoEmployee(new EmployeeGetOneRequest(id));
		String employeeName = null;
		for (int i = 0; i < employeeNameOnce.size(); i++) {
			employeeName = employeeNameOnce.get(i).getLast_name() + " " + employeeNameOnce.get(i).getMiddle_name() + " "
					+ employeeNameOnce.get(i).getFirst_name();
		}
		model.addAttribute("employeeName", employeeName);
		return "department/add-employee-department";
	}

	@RequestMapping(params = "addEmployeeDepartment")
	public ModelAndView doAddEmployeeDepartment(@RequestParam("employee_type_id") int employee_type_id,
			@RequestParam("department_id") int department_id, @RequestParam("position_id") int position_id,
			HttpSession session, ModelAndView mav, RedirectAttributes reAt) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		try {
			if (userAuthen.getRoleId() == 1) {
				EmployeeDepartmentAddRequest request = new EmployeeDepartmentAddRequest();
				request.setEmployee_id(employeeId);
				request.setEmployee_type_id(employee_type_id);
				request.setDepartment_id(department_id);
				request.setPosition_id(position_id);
				request.setCreated_by(userAuthen.getUsername());
				request.setLast_modifier_by(userAuthen.getUsername());
				service.addEmployeeDepartment(request);

				reAt.addFlashAttribute("alerted", "success");
				reAt.addFlashAttribute("message", "Thêm thành công.");

				return mav = new ModelAndView("redirect:/api/employee/department/add/" + employeeId);
			} else {
				return new ModelAndView("redirect:/api/authorized/403");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "delete/{employeeDepartmentId}")
	public ModelAndView doDeleteEmployeeDepartment(@PathVariable("employeeDepartmentId") int id, HttpSession session,
			RedirectAttributes redirect) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 1) {
			EmployeeDepartmentDeleteRequest request = new EmployeeDepartmentDeleteRequest(id);
			try {
				service.deleteEmployeeDepartment(request);
				redirect.addFlashAttribute("alerted", "success");
				redirect.addFlashAttribute("message", "Xóa thành công.");
				return new ModelAndView("redirect:/api/employee/update/" + id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}
		return null;

	}
}
