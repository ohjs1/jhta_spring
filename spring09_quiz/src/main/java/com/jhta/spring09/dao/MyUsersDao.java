package com.jhta.spring09.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quiz.vo.MyUsersVo;
@Repository
public class MyUsersDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.MyUsersMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public int insertMyUser(MyUsersVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	
	public List<MyUsersVo> showUsersAll(){
		return session.selectList(NAMESPACE + ".selectAll");
	}
	
	public List<MyUsersVo> pagningList(HashMap<String, Integer> map){
		return session.selectList(NAMESPACE + ".pagning", map); 
	}
	
	public int countPage() {
		return session.selectOne(NAMESPACE + ".pageCount");
	}
	
	
	public boolean loginCheck(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		MyUsersVo list = session.selectOne(NAMESPACE + ".loginChk", map);
		
		if(list != null) {
			return true;
		} else {
			return false;
		}
	}
}
