package com.fpt.hr_management.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.hr_management.daoImpl.EmployeeSkillImpl;
import com.fpt.hr_management.daoImpl.employee.EmployeeGetOne;
import com.fpt.hr_management.daoImpl.employee_skill.SkillEmployeeGetOne;
import com.fpt.hr_management.daoImpl.level.LevelListGetAll;
import com.fpt.hr_management.daoImpl.skill.SkillListGetAll;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeAddRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeDeleteRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeGetOneRequest;
import com.fpt.hr_management.listener.request.employee_skill.SkillEmployeeUpdateRequest;
import com.fpt.hr_management.listener.response.employee_skill.SkillEmployeeGetOneResponse;
import com.fpt.hr_management.listener.response.level.LevelListGetAllResponse;
import com.fpt.hr_management.listener.response.skill.SkillListGetAllResponse;

@Controller
@RequestMapping("/api/employee/skill")
public class EmployeeSkillController extends EmployeeController {

	private EmployeeSkillImpl service = new EmployeeSkillImpl();
	private int employeeId;
	private int idTable;

	@RequestMapping("add/{id}")
	public String addForm(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") != null && userAuthen.getRoleId() == 1) {

			employeeId = id;
			EmployeeGetOne serviceEmployee = new EmployeeGetOne();
			String employeeName = serviceEmployee.findName(id);
			model.addAttribute("employeeName", employeeName);
			model.addAttribute("employeeId", id);

			SkillListGetAll serviceSkill = new SkillListGetAll();
			List<SkillListGetAllResponse> listSkill = serviceSkill.getSkill();
			model.addAttribute("listSkill", listSkill);

			LevelListGetAll serviceLevel = new LevelListGetAll();
			List<LevelListGetAllResponse> listLevel = serviceLevel.get();
			model.addAttribute("listLevel", listLevel);
			return "employee_skill/add-skill-employee";
		}

		return "redirect:/api/authorized/403";

	}

	@RequestMapping(params = "addEmployeeSkill")
	public ModelAndView doAddEmployeeSkill(@RequestParam("skill_id") int skill_id,
			@RequestParam("skill_start") int skill_start, @RequestParam("skill_end") int skill_end,
			@RequestParam("level_id") int level_id, HttpSession session, RedirectAttributes reAt, ModelAndView mav) {

		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 1) {
			String created_by = userAuthen.getUsername();
			String last_modifier_by = userAuthen.getUsername();

			SkillEmployeeAddRequest request = new SkillEmployeeAddRequest(employeeId, skill_id, skill_start, skill_end,
					level_id, created_by, last_modifier_by);
			service.employeeSkillAdd(request);

			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("message", "Thành công.");
			mav = new ModelAndView("redirect:/api/employee/skill/add/" + employeeId);
			return mav;
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

	}

	@RequestMapping(value = "updater/{id}") // id cua bang
	public ModelAndView updateEmployeeSkill(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 1) {

			SkillListGetAll serviceSkill = new SkillListGetAll();
			List<SkillListGetAllResponse> listSkill = serviceSkill.getSkill();
			model.addAttribute("listSkill", listSkill);

			LevelListGetAll serviceLevel = new LevelListGetAll();
			List<LevelListGetAllResponse> listLevel = serviceLevel.get();
			model.addAttribute("listLevel", listLevel);

			SkillEmployeeGetOne serviceSkillEmployee = new SkillEmployeeGetOne();
			List<SkillEmployeeGetOneResponse> skillTime = serviceSkillEmployee.info(new SkillEmployeeGetOneRequest(id),
					0000);
			int skillStart = 0;
			int skillEnd = 0;
			for (int i = 0; i < skillTime.size(); i++) {
				skillStart = skillTime.get(i).getSkill_start();
				skillEnd = skillTime.get(i).getSkill_end();
			}

			model.addAttribute("skillStart", skillStart);
			model.addAttribute("skillEnd", skillEnd);
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

		idTable = id;
		return new ModelAndView("employee_skill/update-skill-employee");
	}

	@RequestMapping(params = "updateEmployeeSkill")
	public ModelAndView doUpdateSkillEmployee(@RequestParam("skill_id") int skill_id,
			@RequestParam("skill_start") int skill_start, @RequestParam("skill_end") int skill_end,
			@RequestParam("level_id") int level_id, HttpSession session, RedirectAttributes reAt, ModelAndView mav) {

		mav = new ModelAndView("redirect:/api/employee/skill/update/" + idTable);
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 1) {
			String last_modifier_by = userAuthen.getUsername();
			SkillEmployeeUpdateRequest request = new SkillEmployeeUpdateRequest(idTable, skill_id, skill_start,
					skill_end, level_id, last_modifier_by);

			Calendar cal = Calendar.getInstance();
			if ((request.getSkill_end() > cal.get(Calendar.YEAR))
					|| (request.getSkill_start() > cal.get(Calendar.YEAR))) {
				reAt.addFlashAttribute("alert", "warning");
				reAt.addFlashAttribute("message", "Thời gian không hợp lệ.");
				return new ModelAndView("redirect:/api/employee/skill/update/" + idTable);
			}

			try {
				service.employeeSkillUpdate(request);
				reAt.addFlashAttribute("alert", "success");
				reAt.addFlashAttribute("message", "Thành công.");
				return mav;
			} catch (Exception e) {
				reAt.addFlashAttribute("alert", "warning");
				reAt.addFlashAttribute("warning", "Đã có lỗi xảy ra, vui lòng thử lại sau.");
				return new ModelAndView("redirect:/api/employee/skill/update/" + idTable);
			}
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

	}

	@RequestMapping(value = "deleter/{id}")
	public ModelAndView deleteSkillEmployee(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			RedirectAttributes reAt) {

		mav = new ModelAndView("redirect:/api/employee/skill/delete/" + id);
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		try {
			SkillEmployeeDeleteRequest request = new SkillEmployeeDeleteRequest(id);
			service.employeeSkillDelete(request);
			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("messsage", "Xóa thành công.");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
