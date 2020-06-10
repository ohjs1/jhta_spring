package test05.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.MembersVo;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("test05/jdbc/app05.xml");
		MembersDao dao=(MembersDao)ac.getBean("dao");
		MembersVo vo=new MembersVo(10, "김디비", "010", "종로", null);
//		int n=dao.insert(vo);
//		System.out.println(n+"명의 회원이 등록됨");
//		int n=dao.delete(10);
//		System.out.println(n+"명의 회원이 삭제됨");
		MembersVo vo1=new MembersVo(4, null, "222", "부산", null);
//		int n=dao.update(vo1);
//		System.out.println(n+"명의 회원이 수정됨");
//		List<MembersVo> list=dao.list();
//		for(MembersVo vo2:list) {
//			System.out.println("회원번호:" + vo2.getNum());
//			System.out.println("회원이름:" + vo2.getName());
//			System.out.println("회원전화번호:" + vo2.getPhone());
//			System.out.println("회원주소:" + vo2.getAddr());
//			System.out.println("회원가입일:" + vo2.getRegdate());
//			System.out.println();
//		}
//		MembersVo vo3=dao.getinfo(13);
//		if(vo3!=null) {
//			System.out.println("<<조회된 회원정보>>");
//			System.out.println("회원번호:" + vo3.getNum());
//			System.out.println("회원이름:" + vo3.getName());
//			System.out.println("회원전화번호:" + vo3.getPhone());
//			System.out.println("회원주소:" + vo3.getAddr());
//			System.out.println("회원가입일:" + vo3.getRegdate());
//		}else {
//			System.out.println("조회된 회원정보가 없습니다");
//		}
		//회원이름으로 데이터 조회하기
		List<MembersVo> list=dao.searchList("길동");
		for(MembersVo vo4:list) {
			System.out.println("회원번호:" + vo4.getNum());
			System.out.println("회원이름:" + vo4.getName());
			System.out.println("회원전화번호:" + vo4.getPhone());
			System.out.println("회원주소:" + vo4.getAddr());
			System.out.println("회원가입일:" + vo4.getRegdate());
			System.out.println();
		}
		
		
	}
}






