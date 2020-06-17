package com.jhta.spring11.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class SearchController {
	@Autowired
	private FileuploadService service;
	
	@PostMapping("/search")
	public String searchList(String keyword, @RequestParam("searchbox") String[] searchboxValue,
			Model model) {
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String chkbox = "";
		
		for(int i=0; i<searchboxValue.length; i++) {
			chkbox = searchboxValue[i];
			if(chkbox != null) {
				map.put("chkbox", chkbox);
				map.put("keyword", keyword);
				System.out.println(chkbox);
				System.out.println(keyword);
			}
		}
		List<FileinfoVO> mlist = service.searchList(map);
		
		model.addAttribute("searchList", mlist);
		
		return "list";
	}
}
