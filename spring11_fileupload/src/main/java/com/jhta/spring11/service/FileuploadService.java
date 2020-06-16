package com.jhta.spring11.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.spring11.dao.FileuploadDAO;
import com.jhta.spring11.vo.FileinfoVO;

@Service
public class FileuploadService {
	@Autowired
	private FileuploadDAO dao;
	
	public int insertFile(FileinfoVO vo) {
		return dao.insertFile(vo);
	}
	
	public List<FileinfoVO> getList(){
		return dao.getList();
	}
	
	public int delFile(int filenum) {
		return dao.delFile(filenum);
	}
	
	public void deleteFile(String filename) {
		dao.deleteFile(filename);
	}
	
	public FileinfoVO getFilename(int filenum) {
		return dao.getFilename(filenum);
	}
	
	public int updateFile(FileinfoVO vo) {
		return dao.updateFile(vo);
	}
	
	public List<FileinfoVO> getPageList(HashMap<String, Object> map){
		return dao.getPageList(map);
	}
	
	public int getTotalCount() {
		return dao.getTotalCount();
	}
}
