package com.jhta.spring11.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/*
 * 커스텀 뷰 만들기 -> 사용자가 직접 만든뷰
 * AbstractView를 상속받아 만든다.
 */
public class DownloadView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//1.다운로드창으로 응답하기
		super.setContentType("application/octet-stream");
		File f= (File)model.get("file");
		String filename = (String)model.get("filename");
		long fileSize = (Long)model.get("fileSize");
		response.setContentType(getContentType());
		response.setContentLength( (int)fileSize );
		
		//다운로드창에 파일명이 한글인 경우 한글이 깨지지 않도록 인코딩 설정
		filename = URLEncoder.encode(filename, "utf-8");
		filename = filename.replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename = " + filename);
		
		//2.실제로 다운로드하기(클라이언트 컴퓨터에 파일복사하기)
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
		fis.close();
		os.close();
	}
}
