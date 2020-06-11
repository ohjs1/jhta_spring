package com.jhta.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {
	
	@RequestMapping("/weather")
	public ModelAndView weather(int day) {
		String result = "";
		if(day==1) {
			result = "¿À´ÃÀÇ ³¯¾¾ : ´õ¿ö¿ä~";
		} else if(day==2) {
			result = "¿À´ÃÀÇ ³¯¾¾ : ´õ´õ¿ö¿ä~";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("views/showWeather");
		return mv;
	}
}
