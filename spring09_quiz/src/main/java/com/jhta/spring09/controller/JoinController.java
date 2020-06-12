package com.jhta.spring09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	@RequestMapping("/member/join")
	public String joinPageMove(HttpSession session) {
		session.setAttribute("ipage", "joinForm");
		//System.out.println("µø¿€");
		return "home";
	}
}
