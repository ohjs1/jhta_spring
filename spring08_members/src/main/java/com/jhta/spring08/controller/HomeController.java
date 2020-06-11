package com.jhta.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String goHome() {
		//String을 리턴하면 뷰이름이 리턴됨
		return "main";
	}
}
