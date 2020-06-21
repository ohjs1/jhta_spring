package com.jhta.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.board.service.BoardService;
import com.jhta.board.vo.BoardVo;

@Controller
public class InsertController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/write")
	public String insertForm() {
		return "insertForm";
	}
	
	@PostMapping("/write")
	public String boardInsert(BoardVo vo) {
		int n = service.insert(vo);
		
		if(n>0) {
			return "sucess";
		} else {
			return "fall";
		}
	}
}
