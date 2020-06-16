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
		@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
		String field, String keyword) {
		HashMap<String,Object> map=new HashMap<String, Object>();
		
		//검색조건 Map에 담기
		map.put("field", field);
		map.put("keyword", keyword);
		
		ModelAndView mv=new ModelAndView("board/list");
		int totalRowCount=service.count(map);//전체 글의 갯수
		PageUtil pu=new PageUtil(pageNum, totalRowCount,5,10);
		
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		
		List<BoardVO> list=service.list(map);
		
		mv.addObject("list",list);
		mv.addObject("pu",pu);	
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
}





