package com.jhta.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.service.MembersService;
import test.vo.MembersVo;

@Controller
public class UpdateController {
	@Autowired
	private MembersService service;
	
	@RequestMapping("/update")
	public ModelAndView updateUser(int num) {
		ModelAndView mv = new ModelAndView();
		MembersVo vo = service.getinfo(num);
		mv.setViewName("update");
		mv.addObject("updatelist", vo);
		return mv;
	}
	
	@RequestMapping("updateOk")
	public String updateOk(MembersVo vo) {
		int n = service.update(vo);
		if(n>0) {
			return "redirect:/list"; //리 다이렉트 방식으로 이동하기
		} else {
			return "error";
		}
	}
}
