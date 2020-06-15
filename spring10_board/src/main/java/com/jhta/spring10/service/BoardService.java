package com.jhta.spring10.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.spring10.dao.BoardDAO;
import com.jhta.spring10.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}
	public int count() {
		return dao.count();
	}
	public List<BoardVO> list(HashMap<String,Object> map){
		return dao.list(map);
	}
	public BoardVO detail(int num) {
		return dao.detail(num);
	}
	public BoardVO next(int num) {
		return dao.next(num);
	}
	public BoardVO prev(int num) {
		return dao.prev(num);
	}
	public int addHit(int num) {
		return dao.addHit(num);
	}
}















