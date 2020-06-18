package com.jhta.spring14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.spring14.dao.MembersDao;

import test.vo.MembersVo;

@Service
public class MembersService {
	@Autowired
	private MembersDao dao;
	
	public List<MembersVo> getUserList(String addr){
		return dao.getUserList(addr);
	}
}
