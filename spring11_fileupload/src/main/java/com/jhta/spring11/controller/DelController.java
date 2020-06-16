package com.jhta.spring11.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class DelController {
	@Autowired
	private FileuploadService service;
	
	@GetMapping("/del/file")
	public String delFile(int filenum, HttpSession session) {
		String filepath = session.getServletContext().getRealPath("resources/upload");
		FileinfoVO vo = service.getFilename(filenum);
		int n = service.delFile(filenum);
		String filename = vo.getSavefilename();
		
		if(n>0) {
			service.deleteFile(filepath + "/" + filename);
		}
		
		
		return "redirect:/";
	}
}
