package test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	private OracleDao oracledao;
	@Autowired
	private MySqlDao  mysqlDao;
	
	public void setOracledao(OracleDao oracledao) {
		this.oracledao = oracledao;
	}
	
	public void setMysqlDao(MySqlDao mysqlDao) {
		this.mysqlDao = mysqlDao;
	}
	
	public void insert(String data) {
		oracledao.insert(data);
		mysqlDao.insert(data);
	}
	
	public void delete(String data) {
		oracledao.delete(data);
		mysqlDao.delete(data);
	}
	
	public void update(String data) {
		oracledao.update(data);
		mysqlDao.update(data);
	}
	
	public void select(String data) {
		oracledao.select(data);
		mysqlDao.select(data);
	}
}
