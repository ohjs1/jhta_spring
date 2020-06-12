package com.jhta.spring08.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.service.MyusersService;

@Controller
public class LoginController {
	@Autowired private MyusersService service;
	
	//get방식으로 요청시 호출
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	//post방식으로 요청시 호출
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		boolean result = service.isMember(map);
		if(result) { //가입회원이 맞는 경우
			session.setAttribute("id", id); //세션 아이디 담기
			
			return "redirect:/"; // 메인페이지로 이동
		} else {
			return "login"; //로그인 페이지로 이동
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}


