package com.jhta.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhta.spring10.service.BoardService;
import com.jhta.spring10.vo.BoardVO;

@Controller
public class DetailController {
	@Autowired
	private BoardService service;
	@GetMapping("/board/detail")
	public String detail(int num,Model model) {
		service.addHit(num);//조회수 증가하기
		BoardVO vo=service.detail(num);//상세글정보
		BoardVO next=service.next(num);//다음글
		BoardVO prev=service.prev(num);//다음글
		model.addAttribute("vo",vo);
		model.addAttribute("next",next);
		model.addAttribute("prev",prev);
		return "board/detail";
	}
}

















