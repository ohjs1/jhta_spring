package com.jhta.spring13.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.spring13.dao.CommentsDAO;
import com.jhta.spring13.vo.CommentVO;

@Service
public class CommentsService {
	@Autowired
	private CommentsDAO dao;
	
	public int insert(CommentVO vo) {
		return dao.insert(vo);
	}
	
	public int count(int mnum) {
		return dao.count(mnum);
	}
	
	public List<CommentVO> list(HashMap<String, Object> map){
		return dao.list(map);
	}
}
