package com.jhta.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.service.MembersService;

@Controller
public class DeleteController {
	@Autowired private MembersService service;
	
	@RequestMapping("/delete")
	public String delete(int num) {
		int n = service.delete(num);
		if(n>0) {
			return "redirect:/list"; //리 다이렉트 방식으로 이동하기
		} else {
			return "error";
		}
	}
}
