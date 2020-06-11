package quest.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import quest.vo.MyBoardVo;

public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "quest.app.boardMapper";
	
	public int insert(MyBoardVo vo) {
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
}
