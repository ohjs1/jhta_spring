package test.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.MembersVo;
import test.dao.MembersDao;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("test/app/app01.xml");
		MembersDao dao = (MembersDao)ac.getBean("dao");
		//int num, String name, String phone, String addr, Date regdate
		MembersVo vo = new MembersVo(7, "홍", "00", "서울", null);
//		int n = dao.insert(vo);
//		System.out.println( n + "명 회원등록!" );
		
//		List<MembersVo> list = dao.list();
//		for( MembersVo vo2 : list ) {
//			System.out.println("이름:" + vo2.getName());
//			System.out.println("번호:" + vo2.getNum());
//			System.out.println("전화번호:" + vo2.getPhone());
//			System.out.println("주소:" + vo2.getAddr());
//			System.out.println("가입일:" + vo2.getRegdate());
//			System.out.println("-----------------------------");
//		}
//		
//		int n = dao.delete(11);
//		System.out.println( n + "명 회원 삭제됨." );
		
//		int n = dao.update(vo);
//		System.out.println( n + "명 회원 수정됨." );
		
		MembersVo v2 = dao.listOne(7);
		System.out.println("이름:" + v2.getName());
		System.out.println("번호:" + v2.getNum());
		System.out.println("전화번호:" + v2.getPhone());
		System.out.println("주소:" + v2.getAddr());
		System.out.println("가입일:" + v2.getRegdate());
		System.out.println("-----------------------------");
	}

}
