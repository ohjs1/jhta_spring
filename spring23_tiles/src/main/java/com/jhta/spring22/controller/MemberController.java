package com.jhta.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("/member/mypage")
	public String mypage() {
		return ".member.mypage";	
	}
	@GetMapping("/member/cart")
	public String cart() {
		return ".member.cart";	
	}
}







