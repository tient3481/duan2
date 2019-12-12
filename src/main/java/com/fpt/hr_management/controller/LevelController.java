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

import com.fpt.hr_management.daoImpl.LevelImpl;
import com.fpt.hr_management.daoImpl.authentication.AuthenticationAccount;
import com.fpt.hr_management.listener.request.level.LevelAddRequest;
import com.fpt.hr_management.listener.request.level.LevelDeleteRequest;
import com.fpt.hr_management.listener.request.level.LevelListGetOneRequest;
import com.fpt.hr_management.listener.request.level.LevelUpdateRequest;
import com.fpt.hr_management.listener.response.level.LevelListGetAllResponse;
import com.fpt.hr_management.listener.response.level.LevelListGetOneResponse;

@Controller
@RequestMapping("api/level")
public class LevelController extends AuthenticationAccount {

	private LevelImpl service = new LevelImpl();
	private int levelId;

	@RequestMapping("get")
	public String listLevel(HttpSession session, Model model) {
		if (session.getAttribute("account") != null) {
			List<LevelListGetAllResponse> listLevel = service.levelListGetAll();
			model.addAttribute("listLevel", listLevel);
			model.addAttribute("roleId", userAuthen.getRoleId());
			return "level/list-level";
		} else {
			return "redirect:/api/account/login";
		}
	}

	@RequestMapping("add")
	public String addForm(HttpSession session) {
		if (session.getAttribute("account") != null && userAuthen.getRoleId() == 0) {
			return "level/add-level";
		}

		return "redirect:/api/authorized/403";

	}

	@RequestMapping(params = "addLevel")
	public ModelAndView doAddLevel(@RequestParam("name") String name, @RequestParam("note") String note,
			HttpSession session, RedirectAttributes reAt, ModelAndView mav) {
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		if (userAuthen.getRoleId() == 0) {
			LevelAddRequest request = new LevelAddRequest(name, note);
			service.levelAdd(request);

			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("message", "Thành công.");
			mav = new ModelAndView("redirect:/api/level/add");
			return mav;
		} else {
			return new ModelAndView("redirect:/api/authorized/403");
		}

	}

	@RequestMapping(value = "update/{id}")
	public String updateLevel(@PathVariable("id") int id, HttpSession session, Model model) {
		if (session.getAttribute("account") == null) {
			return "redirect:/api/account/login";
		}
		levelId = id;
		List<LevelListGetOneResponse> listLevelInfo = service.levelListGetOne(new LevelListGetOneRequest(levelId));
		model.addAttribute("listLevelInfo", listLevelInfo);
		return "level/update-level";
	}

	@RequestMapping(params = "updateLevel")
	public ModelAndView updateLevel(@RequestParam("name") String name, @RequestParam("note") String note,
			HttpSession session, RedirectAttributes reAt, ModelAndView mav) {

		mav = new ModelAndView("redirect:/api/level/update/" + levelId);
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}
		LevelUpdateRequest request = new LevelUpdateRequest(levelId, name, note);
		try {
			service.levelUpdate(request);
			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("message", "Thành công.");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView deleteLevel(@PathVariable("id") int id, HttpSession session, ModelAndView mav,
			RedirectAttributes reAt) {

		mav = new ModelAndView("redirect:/api/level/get");
		if (session.getAttribute("account") == null) {
			return new ModelAndView("redirect:/api/account/login");
		}

		try {
			LevelDeleteRequest request = new LevelDeleteRequest(id);
			service.levelDelete(request);
			reAt.addFlashAttribute("alert", "success");
			reAt.addFlashAttribute("messsage", "Xóa thành công.");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
