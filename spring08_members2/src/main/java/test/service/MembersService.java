package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.MembersDao;
import test.vo.MembersVo;

@Service
public class MembersService {
	@Autowired private MembersDao dao;
	
	public void setDao(MembersDao dao) {
		this.dao = dao;
	}
	
	public int insert(MembersVo vo) {
		return dao.insert(vo);
	}
	
	public int delete(int num) {
		return dao.delete(num);
	}
	
	public int update(MembersVo vo) {
		return dao.update(vo);
	}
	
	public MembersVo getinfo(int num) {
		return dao.listOne(num);
	}
	
	public List<MembersVo> list(){
		return dao.list();
	}
	
}
