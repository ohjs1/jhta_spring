package test.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.MembersVo;
import test.service.MembersService;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("test/app/app01.xml");
		
		MembersService service = (MembersService)ac.getBean("service");
		//int num, String name, String phone, String addr, Date regdate
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
		
		MembersVo v2 = service.select(1);
		
		if(v2 != null) {
			System.out.println("이름:" + v2.getName());
			System.out.println("번호:" + v2.getNum());
			System.out.println("전화번호:" + v2.getPhone());
			System.out.println("주소:" + v2.getAddr());
			System.out.println("가입일:" + v2.getRegdate());
			System.out.println("-----------------------------");
		} else {
			System.out.println("없는 회원입니다.");
		}
	}

}
