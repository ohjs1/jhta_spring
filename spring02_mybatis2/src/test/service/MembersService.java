package test.service;

import org.springframework.beans.factory.annotation.Autowired;

import mybatis.MembersVo;
import test.dao.MembersDao;

public class MembersService {
	@Autowired
	private MembersDao dao;
	public int insert(MembersVo vo) {
		return dao.insert(vo);
	}
	
	public int delete(int num) {
		return dao.delete(num);
	}
	
	public int update(MembersVo vo) {
		return dao.update(vo);
	}
	
	public MembersVo select(int num) {
		return dao.listOne(num);
	}
}
