package com.jhta.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin/memberlist")
	public String memberlist() {
		return ".admin.memberlist";	
	}
	@GetMapping("/admin/notice")
	public String notice() {
		return ".admin.notice";	
	}
}









