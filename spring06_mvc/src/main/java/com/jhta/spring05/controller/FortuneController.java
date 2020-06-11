package com.jhta.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FortuneController {
	
	@RequestMapping("/fortune")
	public ModelAndView fortune() {
		String result = "�������� ���� ������ ������~~";
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("showFortune");
		return mv;
	}
}
