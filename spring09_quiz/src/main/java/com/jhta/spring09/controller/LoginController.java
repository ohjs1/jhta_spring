package com.jhta.spring09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.spring09.service.MyUsersService;

@Controller
public class LoginController {
	@Autowired
	private MyUsersService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(HttpSession session) {
		session.setAttribute("ipage", "loginForm");
		
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginCheck(String id, String pw, HttpSession session) {
		boolean checked = service.loginChk(id, pw);
		
		//System.out.println(checked);
		
		if(checked) {
			session.setAttribute("loginchk", "true");
			session.setAttribute("ipage", "default");
		} else {
			session.setAttribute("loginchk", "false");
			session.setAttribute("ipage", "loginForm");
		}
		
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
