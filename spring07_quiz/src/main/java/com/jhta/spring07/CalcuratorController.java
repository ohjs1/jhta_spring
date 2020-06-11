package com.jhta.spring07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcuratorController {
	
	@RequestMapping("/quiz")
	public ModelAndView sum(int num1, int num2) {
		int result = num1 + num2;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("calcurator");
		return mv;
	}
}
