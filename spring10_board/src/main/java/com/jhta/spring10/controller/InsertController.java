package com.jhta.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.spring10.service.BoardService;
import com.jhta.spring10.vo.BoardVO;

@Controller
public class InsertController {
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/board/insert",method=RequestMethod.GET)
	public String insertForm() {
		return "board/insert";
	}
	@RequestMapping(value="/board/insert",method=RequestMethod.POST)
	public String insertOk(BoardVO vo) {
		try {
			service.insert(vo);
			return "success";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
}















