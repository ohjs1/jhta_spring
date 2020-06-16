package com.jhta.spring11.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class UpdateController {
	@Autowired
	private FileuploadService service;
	
	@GetMapping("/update/file")
	public String updateFile(int filenum, Model model) {
		FileinfoVO vo = service.getFilename(filenum);
		model.addAttribute("vlist", vo);
		return "update";
	}
	
	@PostMapping("/update/file")
	public String updateFileOk(FileinfoVO vo, HttpSession session, MultipartFile file1) {
		//업로드할 폴더 경로 얻어오기
		String uploadPath = session.getServletContext().getRealPath("resources/upload");
		
		
		try {
			//전송된 파일을 읽어오는 스트림 
			InputStream fis = file1.getInputStream(); 
			
			//전송된 파일명
			String orgfilename = file1.getOriginalFilename();
					
			//실제 저장할 파일명(중복되지 않도록)
			String savefileName = UUID.randomUUID() + "_" + orgfilename;
			
			//전송된 파일을 서버에 복사(업로드) 하기위한 출력 스트림
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + savefileName);
			
			//파일복사하기
			FileCopyUtils.copy(fis, fos);
			fis.close();
			fos.close();
			
			FileinfoVO fvo = new FileinfoVO(vo.getFilenum(), vo.getWriter(), vo.getTitle(), vo.getContent(), orgfilename,
					savefileName, file1.getSize());
			
			int n = service.updateFile(fvo);

			service.deleteFile(uploadPath + "\\" +vo.getSavefilename());

		} catch(IOException i) {
			System.out.println(i.getMessage());
		}
		
		
		
		return "redirect:/file/list";
	}
}
