package com.jhta.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FortuneController {
	
	@RequestMapping("/fortune")
	public ModelAndView fortune() {
		String result = "동쪽으로 가면 귀인을 만나리~~";
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("showFortune");
		return mv;
	}
}
