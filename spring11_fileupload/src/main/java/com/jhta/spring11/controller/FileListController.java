package com.jhta.spring11.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class FileListController {
	@Autowired
	private FileuploadService service;
	
	
	@GetMapping("/file/list")
	public String getFileList(HttpSession session) {
		System.out.println("dfsdf");
		List<FileinfoVO> list = service.getList();
		session.setAttribute("flist", list);
		return "list";
	}
}
