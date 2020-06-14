package com.jhta.spring09.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.spring09.dao.MyUsersDao;

import quiz.vo.MyUsersVo;
@Service
public class MyUsersService {
	@Autowired
	private MyUsersDao dao;
	public void setDao(MyUsersDao dao) {
		this.dao = dao;
	}
	
	public int userInsert(MyUsersVo vo) {
		return dao.insertMyUser(vo);
	}
	
	public List<MyUsersVo> showUsersAll(){
		return dao.showUsersAll();
	}
	
	public boolean loginChk(String id, String pw){
		return dao.loginCheck(id, pw);
	}
	
	public List<MyUsersVo> pagningList(HashMap<String, Integer> map){
		return dao.pagningList(map);
	}
	
	public int countPage() {
		return dao.countPage();
	}
}
