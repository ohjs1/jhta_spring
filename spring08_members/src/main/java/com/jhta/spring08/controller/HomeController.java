package com.jhta.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String goHome() {
		//String�� �����ϸ� ���̸��� ���ϵ�
		return "main";
	}
}
