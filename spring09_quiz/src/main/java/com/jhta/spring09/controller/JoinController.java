package com.jhta.spring09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.spring09.service.MyUsersService;

import quiz.vo.MyUsersVo;

@Controller
public class JoinController {
	@Autowired
	private MyUsersService service;
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String joinPageMove(HttpSession session) {
		session.setAttribute("ipage", "joinForm");
		//System.out.println("µ¿ÀÛ");
		return "home";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String joinPageMove(MyUsersVo vo, HttpSession session) {
		int n = service.userInsert(vo);
		if(n>0) {
			return "redirect:/";
		} else {
			session.setAttribute("ipage", "error");
			return "error";
		}
	}
}
