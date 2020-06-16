package com.jhta.spring11.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.spring11.service.FileuploadService;
import com.jhta.spring11.vo.FileinfoVO;

@Controller
public class FileuploadController {
	@Autowired
	private FileuploadService service;
	
	@GetMapping("/file/upload")
	public String uploadForm() {
		return "insert";
	}
	
	@PostMapping("/file/upload")
	//MultipartFile file1 : 전송된 파일은 MultipartFile 타입객체로 전달받기
	public String uploadOk(String writer, String title, String content, MultipartFile file1, HttpSession session) {
		//업로드할 폴더 경로 얻어오기
		String uploadPath = session.getServletContext().getRealPath("resources/upload");
		
		//System.out.println(uploadPath);
		
		//전송된 파일명
		String orgfilename = file1.getOriginalFilename();
		
		//실제 저장할 파일명(중복되지 않도록)
		String savefileName = UUID.randomUUID() + "_" + orgfilename;
		try {
			//전송된 파일을 읽어오는 스트림 
			InputStream fis = file1.getInputStream(); 
			
			//전송된 파일을 서버에 복사(업로드) 하기위한 출력 스트림
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + savefileName);
			
			//파일복사하기
			FileCopyUtils.copy(fis, fos);
			fis.close();
			fos.close();
			
			//DB에 파일정보 저장하기... int filenum, String writer, String title, String content, String orgfilename, String savefilename,
			//long filesize
			
			
			FileinfoVO vo = new FileinfoVO(0, writer, title, content, orgfilename,
					savefileName, file1.getSize());
			
			int n = service.insertFile(vo);
			
			if(n > 0) {
				return "success";
			} else {
				return "error";
			}
			
					
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
			return "error";
		}
	}
}
