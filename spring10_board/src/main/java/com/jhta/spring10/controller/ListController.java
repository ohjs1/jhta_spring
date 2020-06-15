package com.jhta.spring10.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.page.util.PageUtil;
import com.jhta.spring10.service.BoardService;
import com.jhta.spring10.vo.BoardVO;

@Controller
public class ListController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board/list")
	public ModelAndView list(
		@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		ModelAndView mv=new ModelAndView("board/list");
		int totalRowCount=service.count();//전체 글의 갯수
		PageUtil pu=new PageUtil(pageNum, totalRowCount,5,10);
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<BoardVO> list=service.list(map);
		mv.addObject("list",list);
		mv.addObject("pu",pu);	
		return mv;
	}
}





