package com.jhta.spring20.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.spring20.vo.MembersVo;


public class MembersDao {
	private SqlSession session;
	private final String NAMESPACE="mybatis.MembersMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public int insert(MembersVo vo) {
		int n=session.insert(NAMESPACE+".insert",vo);
		return n;
	}
	public List<MembersVo> list(){
		List<MembersVo> mlist=session.selectList(NAMESPACE +".list");
		return mlist;
	}
	public int delete(int num) {
		int n=session.delete(NAMESPACE+".delete",num);
		return n;
	}
	public int update(MembersVo vo) {
		int n=session.update(NAMESPACE+".update",vo);
		return n;
	}
	public MembersVo getinfo(int num) {
		return session.selectOne(NAMESPACE +".getinfo",num);
	}
	
	
}





