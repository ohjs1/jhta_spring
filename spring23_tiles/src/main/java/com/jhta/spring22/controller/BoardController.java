package com.jhta.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/member/board1")
	public String board1() {
		return ".member.board.board1";	
	}
	@GetMapping("/member/board2")
	public String board2() {
		return ".member.board.board2";
	}
}






