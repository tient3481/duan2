package com.fpt.hr_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/authorized")
public class RedirectAuthorized {

	@RequestMapping("/403")
	public String AccessDenied() {
		return "access_denied/403";
	}
}
