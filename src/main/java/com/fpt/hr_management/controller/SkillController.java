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

import com.fpt.hr_management.daoImpl.SkillImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.daoImpl.skill_category.SkillCategoryListGetAll;
import com.fpt.hr_management.listener.request.skill.SkillAddRequest;
import com.fpt.hr_management.listener.request.skill.SkillDeleteRequest;
import com.fpt.hr_management.listener.request.skill.SkillListGetOneRequest;
import com.fpt.hr_management.listener.request.skill.SkillUpdateRequest;
import com.fpt.hr_management.listener.response.skill.SkillCategoryListGetAllResponse;
import com.fpt.hr_management.listener.response.skill.SkillListGetOneResponse;

@RequestMapping("api/skill")
@Controller
public class SkillController extends AuthenticationAccount {

	private SkillImpl service = new SkillImpl();
	private int skillId = 0;

	@RequestMapping("get")

	public String getListSkill(Model model, HttpSession session) {
		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() == 0) {
				List<SkillCategoryListGetAllResponse> listSkill = service.listSkillGetAll();
				model.addAttribute("listSkill", listSkill);
				return "skill/list-skill";
			} else {
				return "redirect:/api/authorized/403";
			}
		} else {
			return "redirect:/api/account/login";
		}

	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteSkill(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			HttpServletRequest req, RedirectAttributes redirect, Model model) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		}
		try {
			mav = new ModelAndView("redirect:/api/skill/get");
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			}

			if (userAuthen.getRoleId() == 0) {
				service.deleteSkill(new SkillDeleteRequest(id));
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
			SkillCategoryListGetAll serviceSkCat = new SkillCategoryListGetAll();

			List<com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetAllResponse> listSkill = serviceSkCat
					.get();
			model.addAttribute("listSkill", listSkill);
			return new ModelAndView("skill/add-skill");
		} else {
			redirect.addFlashAttribute("message", "Phiên làm việc đã hết hạn, vui lòng đăng nhập lại.");
			redirect.addFlashAttribute("alerted", "warning");
			return mav;
		}

	}

	@RequestMapping(params = "addSkill")
	public ModelAndView doAddSKill(HttpSession session, ModelAndView mav, RedirectAttributes redirect,
			@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("category_id") int category_id) {

		String created_by = userAuthen.getUsername();
		String last_modifier_by = userAuthen.getUsername();
		mav = new ModelAndView("redirect:/api/skill/add");

		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			} else {
				service.addSkill(new SkillAddRequest(name, description, category_id, created_by, last_modifier_by));
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

		SkillListGetOneRequest request = new SkillListGetOneRequest(id);
		List<SkillListGetOneResponse> listSkillGetOne = service.listSkillGetOne(request);
		System.out.println(listSkillGetOne.toString());
		model.addAttribute("listSkillGetOne", listSkillGetOne);
		for (int i = 0; i < listSkillGetOne.size(); i++) {
			skillId = listSkillGetOne.get(i).getId();
		}

		return "skill/update-skill";
	}

	@RequestMapping(params = "updateSkill")
	public ModelAndView doUpdateSkill(@RequestParam("category_id") int category_id, HttpSession session,
			RedirectAttributes redirect, ModelAndView mav, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		} else {
			String last_modifier_by = userAuthen.getUsername();
			try {
				SkillUpdateRequest request = new SkillUpdateRequest(skillId, name, description, category_id,
						last_modifier_by);
				service.updateSkill(request);
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new ModelAndView("redirect:/api/skill/update/" + skillId);

	}

}
