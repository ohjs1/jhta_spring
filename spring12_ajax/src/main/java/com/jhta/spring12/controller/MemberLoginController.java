package com.jhta.spring12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberLoginController {
	@RequestMapping(value="/login/xml", produces = "application/xml; charset=utf8")
	@ResponseBody
	public String getLoginCheck() {
		StringBuffer sbr = new StringBuffer();
		sbr.append("<login>");
		sbr.append("<name>ȫ�浿</name>");
		sbr.append("<email>admin@naver.com</email>");
		sbr.append("<id>admin</id>");
		sbr.append("</login>");
		
		return sbr.toString();
	}
}
