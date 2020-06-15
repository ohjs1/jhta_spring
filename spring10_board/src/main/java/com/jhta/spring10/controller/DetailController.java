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
		service.addHit(num);//��ȸ�� �����ϱ�
		BoardVO vo=service.detail(num);//�󼼱�����
		BoardVO next=service.next(num);//������
		BoardVO prev=service.prev(num);//������
		model.addAttribute("vo",vo);
		model.addAttribute("next",next);
		model.addAttribute("prev",prev);
		return "board/detail";
	}
}

















