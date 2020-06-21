package com.jhta.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.board.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.jhta.board.mybatis.mapper.BoardMapper";
	
	
	public int insert(BoardVo vo) {
		return sqlSessionTemplate.insert(NAMESPACE + ".insert", vo);
	}
	
	public List<BoardVo> list(HashMap<String, Object> map){
		return sqlSessionTemplate.selectList(NAMESPACE + ".list", map);
	}
	
	public int count(HashMap<String, Object> map) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".count", map);
	}
}
