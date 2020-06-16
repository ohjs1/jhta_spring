package com.jhta.spring11.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.spring11.vo.FileinfoVO;

@Repository
public class FileuploadDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.FileinfoMapper";
	
	public int insertFile(FileinfoVO vo) {
		return sqlSessionTemplate.insert(NAMESPACE + ".insert", vo);
	}
	
	public int updateFile(FileinfoVO vo) {
		return sqlSessionTemplate.update(NAMESPACE + ".update", vo);
	}
	
	public List<FileinfoVO> getList(){
		return sqlSessionTemplate.selectList(NAMESPACE + ".select");
	}
	
	public int delFile(int filenum) {
		return sqlSessionTemplate.delete(NAMESPACE + ".delete", filenum);
	}
	
	public void deleteFile(String nfile) {
		File file = new File(nfile);
		System.out.println("삭제될 파일 경로 " + nfile);
		if(file.delete()) {
			System.out.println("파일 삭제 성공");
		}
		
	}
	
	public FileinfoVO getFilename(int filenum) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectFilename", filenum);
	}
	
	public List<FileinfoVO> getPageList(HashMap<String, Object> map){
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectPage", map);
	}
	
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".maxPageCount");
	}
}
