package com.jhta.spring20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.spring20.service.MembersService;
import com.jhta.spring20.vo.MembersVo;

@Controller
public class JoinController {
	@Autowired
	private MembersService service;
	
	@RequestMapping("/member/join")
	public String joinForm() {
		return "insert";
	}
	
	@PostMapping("/insertOk")
	public String joinOk(MembersVo vo) {
		try {
			service.insert(vo);
			return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
