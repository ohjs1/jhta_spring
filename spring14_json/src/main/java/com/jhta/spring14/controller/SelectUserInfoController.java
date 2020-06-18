package com.jhta.spring14.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SelectUserInfoController {
	
	@RequestMapping(value="/member/info/{num}", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getInfo(@PathVariable("num") int num) {
		System.out.println(num);
		
		JSONObject json = new JSONObject();

		if(num == 1) {
			json.put("error", "sucess");
			json.put("name", "È«±æµ¿");
			json.put("phone", "010");
			json.put("addr", "¼­¿ï");
		} else {
			json.put("error", "fail");
		}
		
		return json.toString();
	}
}
