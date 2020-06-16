package com.jhta.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.spring11.service.FileuploadService;

@Controller
public class SearchController {
	@Autowired
	private FileuploadService service;
	
	@PostMapping("/search")
	public String searchList(String writer, String title, String content, String keyword) {
		System.out.println(writer + ", writer");
		System.out.println(title + ", title");
		System.out.println(content + ", content");
		System.out.println(keyword + ", keyword");
		
		return "list";
	}
}
