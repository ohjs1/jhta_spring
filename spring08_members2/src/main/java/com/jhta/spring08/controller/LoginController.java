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
	
	//get������� ��û�� ȣ��
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	//post������� ��û�� ȣ��
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		boolean result = service.isMember(map);
		if(result) { //����ȸ���� �´� ���
			session.setAttribute("id", id); //���� ���̵� ���
			
			return "redirect:/"; // ������������ �̵�
		} else {
			return "login"; //�α��� �������� �̵�
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}


