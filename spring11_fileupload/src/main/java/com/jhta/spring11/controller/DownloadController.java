package com.jhta.spring11.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class DownloadController {
	@Autowired
	private FileuploadService service;
	
	@GetMapping("/file/download")
	public String download(int filenum, Model model, HttpSession session) {
		//다운로드할 파일정보를 갖는 객체 얻어오기
		FileinfoVO vo = service.getFilename(filenum);
		String path = session.getServletContext().getRealPath("resources/upload");
		
		//다운로드할 파일 객체 
		File f = new File(path + File.separator + vo.getSavefilename());
		
		//다운로드창에 보여질 파일명
		String filename = vo.getOrgfilename();
		model.addAttribute("file", f);
		model.addAttribute("filename", filename);
		model.addAttribute("fileSize", vo.getFilesize());
		
		return "filedownloadView";
	}
}
