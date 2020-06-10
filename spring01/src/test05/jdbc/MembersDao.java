package test05.jdbc;
/*
 * Spring에서는 jdbc작업을 할때 JDBC의 반복되는 작업을 탬플릿화한다
 * JDBCTemplate을 사용한다.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import test.MembersVo;

public class MembersDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insert(MembersVo vo) {
		String sql="insert into members values(?,?,?,?,sysdate)";
		//jdbcTemplate.update(실행할 sql구문,?에 대응되는 값들
		int n=jdbcTemplate.update(sql,vo.getNum(),
				vo.getName(),vo.getPhone(),vo.getAddr());
		return n;
	}
	public int delete(int num) {
		String sql="delete from members where num=?";
		int n=jdbcTemplate.update(sql,num);
		return n;
	}
	public int update(MembersVo vo) {
		String sql="update members set phone=?,addr=? where num=?";
		int n=jdbcTemplate.update(sql,vo.getPhone(),vo.getAddr(),vo.getNum());
		return n;
	}
	public List<MembersVo> list(){
		String sql="select * from members";
		RowMapper<MembersVo> rowMapper=new RowMapper<MembersVo>() {
			//select로 조회된 결과를 어떻게 vo에 담을지 설정
			@Override
			public MembersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MembersVo vo=new MembersVo();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddr(rs.getString("addr"));
				vo.setRegdate(rs.getDate("regdate"));
				return vo;
			}
		};
		List<MembersVo> list=jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	public MembersVo getinfo(int num) {
		try {
			String sql="select * from members where num=?";
			MembersVo vo=jdbcTemplate.queryForObject(sql, new RowMapper<MembersVo>() {
				@Override
				public MembersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					MembersVo vo=new MembersVo();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setPhone(rs.getString("phone"));
					vo.setAddr(rs.getString("addr"));
					vo.setRegdate(rs.getDate("regdate"));
					return vo;
				}
			}, num);
			return vo;
		}catch (EmptyResultDataAccessException e) { //조회된 회원이 없으면 null 리턴
			System.out.println(e.getMessage());
			return null;
		}
	}
	public List<MembersVo> searchList(String name){
		try {
			String sql="select * from members where name like '%'||?||'%'";
			List<MembersVo> list=jdbcTemplate.query(sql, new RowMapper<MembersVo>() {
				@Override
				public MembersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					MembersVo vo=new MembersVo();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setPhone(rs.getString("phone"));
					vo.setAddr(rs.getString("addr"));
					vo.setRegdate(rs.getDate("regdate"));
					return vo;
				}
			}, name);
			return list;
		}catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}








