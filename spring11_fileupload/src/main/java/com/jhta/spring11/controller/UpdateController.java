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
		//���ε��� ���� ��� ������
		String uploadPath = session.getServletContext().getRealPath("resources/upload");
		
		
		try {
			//���۵� ������ �о���� ��Ʈ�� 
			InputStream fis = file1.getInputStream(); 
			
			//���۵� ���ϸ�
			String orgfilename = file1.getOriginalFilename();
					
			//���� ������ ���ϸ�(�ߺ����� �ʵ���)
			String savefileName = UUID.randomUUID() + "_" + orgfilename;
			
			//���۵� ������ ������ ����(���ε�) �ϱ����� ��� ��Ʈ��
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + savefileName);
			
			//���Ϻ����ϱ�
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
