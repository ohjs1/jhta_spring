package test.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.MyUsersDao;
import test.vo.MyUsersVo;

/*
 * myusers테이블과 연동해서
 * 데이터 추가/수정/삭제/조회/전체조회 기능 구현해보기
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/testapp.xml");
		MyUsersDao dao = (MyUsersDao)ac.getBean("dao");
		
		//회원 추가
		//String id, String pw, String email, Date mydate
//		MyUsersVo vo = new MyUsersVo("zzz", "12354", "1@naver.com", null);
//		int n = dao.insert(vo);	
//		System.out.println( n + "명의 회원 추가됨!" );
		
		//회원 수정
//		MyUsersVo vo = new MyUsersVo("zzz", "test", "test@naver.com", null);
//		int n = dao.update(vo);
//		System.out.println(n + "명의 회원 수정됨");
		
		//회원삭제
//		int n = dao.delete("22");
//		System.out.println(n + "명의 회원 삭제됨");
		
		//아이디로 조회
//		MyUsersVo vo = dao.list("zzz");
//		System.out.println("아이디:" + vo.getId());
//		System.out.println("비밀번호:" + vo.getPw());
//		System.out.println("이메일:" + vo.getEmail());
//		System.out.println("가입일:" + vo.getMydate());
		
		//전체조회
		List<MyUsersVo> list = dao.listAll();
		for(MyUsersVo vo : list) {
			System.out.println("아이디:" + vo.getId());
			System.out.println("비밀번호:" + vo.getPw());
			System.out.println("이메일:" + vo.getEmail());
			System.out.println("가입일:" + vo.getMydate());
			System.out.println("---------------------------");
		}
	}

}
