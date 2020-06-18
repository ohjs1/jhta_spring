package com.jhta.spring14.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.vo.MembersVo;

@Repository
public class MembersDao {
	@Autowired
	private SqlSessionTemplate sql;
	private final String NAMESPACE = "jhta.mybatis.mapper.MembersMapper";
	
	public List<MembersVo> getUserList(String addr){
		return sql.selectList(NAMESPACE + ".select", addr);
	}
}
