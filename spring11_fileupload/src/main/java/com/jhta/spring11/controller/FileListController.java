package com.jhta.spring11.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;
import com.jhta.spring11.vo.Pagning;

@Controller
public class FileListController {
	@Autowired
	private FileuploadService service;
	
	
	@GetMapping("/file/list")
	public String getFileList(HttpSession session, @RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "searchbox", required = false) String[] checkboxValue, String keyword) {
		
		//System.out.println(checkboxValue);
		
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("field", checkboxValue);
		map.put("keyword", keyword);

		int maxPageCount = service.getTotalCount(map);
		System.out.println(maxPageCount + " 전체글 개수");
		Pagning pg = new Pagning(pageNum, maxPageCount, 5, 5);
		map.put("startRow", pg.getStartRow());
		map.put("endRow", pg.getEndRow());
		
		List<FileinfoVO> flist = service.getPageList(map);
		session.setAttribute("field", checkboxValue);
		session.setAttribute("pg", pg);
		session.setAttribute("flist", flist);
		
		
		return "list";
	}
}
