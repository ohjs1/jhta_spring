package test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import test.vo.MyUsersVo;

public class MyUsersDao {
	private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "mybatis.usersMapper";
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public int insert(MyUsersVo vo) {
		int n = sqlSessionTemplate.insert(NAMESPACE + ".insert", vo);
		return n;
	}
	
	public int update(MyUsersVo vo) {
		int n = sqlSessionTemplate.update(NAMESPACE + ".update", vo);
		return n;
	}
	
	public int delete(String id) {
		int n = sqlSessionTemplate.delete(NAMESPACE + ".delete", id);
		return n;
	}
	
	public MyUsersVo list(String id) {
		MyUsersVo vo = sqlSessionTemplate.selectOne(NAMESPACE + ".select", id);
		return vo;
	}
	
	public List<MyUsersVo> listAll(){
		List<MyUsersVo> list = sqlSessionTemplate.selectList(NAMESPACE + ".selectAll");
		return list;
	}
}
