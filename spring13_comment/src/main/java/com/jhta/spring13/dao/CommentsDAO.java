package com.jhta.spring13.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.spring13.vo.CommentVO;

@Repository
public class CommentsDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.CommentMapper";
	
	public int insert(CommentVO vo) {
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	public int count(int mnum) {
		return sqlSession.selectOne(NAMESPACE + ".count", mnum);
	}
	
	public List<CommentVO> list(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".getList", map);
	}
}
