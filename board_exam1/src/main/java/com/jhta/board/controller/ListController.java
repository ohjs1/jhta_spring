package com.jhta.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.board.service.BoardService;
import com.jhta.board.vo.BoardVo;
import com.jhta.page.util.PageUtil;

@Controller
public class ListController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			String field, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("field", field);
		map.put("keyword", keyword);

		int totalRow = service.count(map);
		
		PageUtil pu = new PageUtil(pageNum, totalRow, 3, 3);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<BoardVo> list = service.list(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		model.addAttribute("keyword", keyword);
		model.addAttribute("field", field);
		
		return "list";
	}
}
