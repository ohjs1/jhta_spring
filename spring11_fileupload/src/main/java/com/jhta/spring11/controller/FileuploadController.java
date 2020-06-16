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
	//MultipartFile file1 : ���۵� ������ MultipartFile Ÿ�԰�ü�� ���޹ޱ�
	public String uploadOk(String writer, String title, String content, MultipartFile file1, HttpSession session) {
		//���ε��� ���� ��� ������
		String uploadPath = session.getServletContext().getRealPath("resources/upload");
		
		//System.out.println(uploadPath);
		
		//���۵� ���ϸ�
		String orgfilename = file1.getOriginalFilename();
		
		//���� ������ ���ϸ�(�ߺ����� �ʵ���)
		String savefileName = UUID.randomUUID() + "_" + orgfilename;
		try {
			//���۵� ������ �о���� ��Ʈ�� 
			InputStream fis = file1.getInputStream(); 
			
			//���۵� ������ ������ ����(���ε�) �ϱ����� ��� ��Ʈ��
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + savefileName);
			
			//���Ϻ����ϱ�
			FileCopyUtils.copy(fis, fos);
			fis.close();
			fos.close();
			
			//DB�� �������� �����ϱ�... int filenum, String writer, String title, String content, String orgfilename, String savefilename,
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
