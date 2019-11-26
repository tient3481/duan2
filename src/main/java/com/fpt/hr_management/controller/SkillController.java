package com.fpt.hr_management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.hr_management.daoImpl.SkillImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.response.skill.SkillListGetAllResponse;

@RequestMapping("api/skill")
@Controller
public class SkillController extends AuthenticationAccount {

	private SkillImpl service = new SkillImpl();

	@RequestMapping("get")
	public String getListSkill(Model model, HttpSession session) {
		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() == 0) {
				List<SkillListGetAllResponse> listSkill = service.listSkillGetAll();
				model.addAttribute("listSkill", listSkill);
				return "skill/list-skill";
			} else {
				return "redirect:/api/authorized/403";
			}
		} else {
			return "redirect:/api/account/login";
		}

	}

	private boolean sessionInvalid(HttpSession session) {
		if (session.getAttribute("account") == null) {
			return true;
		}

		return false;
	}

	@RequestMapping("add")
	public String addSKill(HttpSession session) {
		if (!sessionInvalid(session)) {
			return "skill/add-skill";
		} else {
			return "redirect:/api/account/login";
		}
	}

}
