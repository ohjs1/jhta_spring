package com.jhta.spring10.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.spring10.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.BoardMapper";
	public int insert(BoardVO vo) {
		return sqlSession.insert(NAMESPACE +".insert",vo);
	}
	public int count(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE +".count", map);
	}
	public List<BoardVO> list(HashMap<String,Object> map){
		return sqlSession.selectList(NAMESPACE+".list",map);
	}
	public BoardVO detail(int num) {
		return sqlSession.selectOne(NAMESPACE +".detail",num);
	}
	public BoardVO next(int num) {
		return sqlSession.selectOne(NAMESPACE +".next",num);
	}
	public BoardVO prev(int num) {
		return sqlSession.selectOne(NAMESPACE +".prev",num);
	}
	public int addHit(int num) {
		return sqlSession.update(NAMESPACE +".hit",num);
	}
}
















