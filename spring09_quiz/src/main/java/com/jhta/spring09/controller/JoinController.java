package com.jhta.spring09.controller;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String joinPageMove(HttpSession session) {
		session.setAttribute("ipage", "joinForm");
		//System.out.println("µø¿€");
		return "home";
	}
	
	
}
