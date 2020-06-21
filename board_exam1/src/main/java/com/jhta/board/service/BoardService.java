package com.jhta.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.board.dao.BoardDao;
import com.jhta.board.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public int insert(BoardVo vo) {
		return dao.insert(vo);
	} 
	
	public List<BoardVo> list(HashMap<String, Object> map){
		return dao.list(map);
	}
	
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
}
