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

import com.fpt.hr_management.daoImpl.SkillCategoryImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryAddRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryDeleteRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryListGetOneRequest;
import com.fpt.hr_management.listener.request.skill_category.SkillCategoryUpdateRequest;
import com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetOneResponse;

@RequestMapping("/api/category-skill")
@Controller
public class SkillCategoryController extends AuthenticationAccount {

	private SkillCategoryImpl service = new SkillCategoryImpl();
	private int skillCategoryId = 0;

	@RequestMapping("get")
	public String getListSkillCategory(Model model, HttpSession session) {
		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() == 0) {
				List<com.fpt.hr_management.listener.response.skill_category.SkillCategoryListGetAllResponse> listCategorySkill = service
						.listSkillCategoryGetAll();
				model.addAttribute("listCategorySkill", listCategorySkill);
				return "category_skill/list-cat-skill";
			} else {
				return "redirect:/api/authorized/403";
			}
		} else {
			return "redirect:/api/account/login";
		}

	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteSkillCategory(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			HttpServletRequest req, RedirectAttributes redirect, Model model) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		}
		try {
			mav = new ModelAndView("redirect:/api/category-skill/get");
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			}

			if (userAuthen.getRoleId() == 0) {
				service.deleteSkillCategory(new SkillCategoryDeleteRequest(id));
				redirect.addFlashAttribute("message", "Xóa thành công.");
				redirect.addFlashAttribute("alerted", "success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping("add")
	public ModelAndView addSKillCategory(HttpSession session, Model model, RedirectAttributes redirect,
			ModelAndView mav) {
		mav = new ModelAndView("redirect:/api/account/login");
		if (!sessionInvalid(session)) {
			return new ModelAndView("category_skill/add-cat-skill");
		} else {
			redirect.addFlashAttribute("message", "Phiên làm việc đã hết hạn, vui lòng đăng nhập lại.");
			redirect.addFlashAttribute("alerted", "warning");
			return mav;
		}

	}

	@RequestMapping(params = "addSkillCat")
	public ModelAndView doAddSKillCategory(HttpSession session, ModelAndView mav, RedirectAttributes redirect,
			@RequestParam("name") String name, @RequestParam("description") String description) {

		String created_by = userAuthen.getUsername();
		String last_modifier_by = userAuthen.getUsername();
		mav = new ModelAndView("redirect:/api/category-skill/add");

		if (!sessionInvalid(session)) {
			if (userAuthen.getRoleId() != 0) {
				return new ModelAndView("redirect:/api/authorized/403");
			} else {
				service.addSkillCategory(new SkillCategoryAddRequest(name, description, created_by, last_modifier_by));
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

		SkillCategoryListGetOneRequest request = new SkillCategoryListGetOneRequest(id);
		List<SkillCategoryListGetOneResponse> listSkillCatGetOne = service.listSkillCategoryGetOne(request);

		model.addAttribute("listSkillCatGetOne", listSkillCatGetOne);
		for (int i = 0; i < listSkillCatGetOne.size(); i++) {
			skillCategoryId = listSkillCatGetOne.get(i).getId();
		}

		return "category_skill/update-cat-skill";
	}

	@RequestMapping(params = "updateSkillCat")
	public ModelAndView doUpdateSkill(HttpSession session, RedirectAttributes redirect, ModelAndView mav,
			@RequestParam("name") String name, @RequestParam("description") String description) {
		if (sessionInvalid(session)) {
			return new ModelAndView("redirect:/api/account/login");
		} else {
			String last_modifier_by = userAuthen.getUsername();
			try {
				SkillCategoryUpdateRequest request = new SkillCategoryUpdateRequest(skillCategoryId, name, description,
						last_modifier_by);
				service.updateSkillCategory(request);
				redirect.addFlashAttribute("message", "Thành công.");
				redirect.addFlashAttribute("alerted", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new ModelAndView("redirect:/api/category-skill/update/" + skillCategoryId);

	}

}
