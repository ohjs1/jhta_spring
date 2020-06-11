package com.jhta.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.service.MembersService;
import test.vo.MembersVo;

@Controller
public class InsertController {
	private MembersService service;
	public void setService(MembersService service) {
		this.service = service;
	}
	
	@RequestMapping("/insert")
	public String insertPage() {
		return "insert";
	}
	
	@RequestMapping("/insertOk")
	public ModelAndView insertOk(MembersVo vo) {
		int n = service.insert(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		if(n>0) {
			mv.addObject("code", "success");
		} else {
			mv.addObject("code", "error");
		}
		return mv;
	}
}
