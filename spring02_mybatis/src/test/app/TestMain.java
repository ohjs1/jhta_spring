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
		MembersVo vo = new MembersVo(7, "ȫ", "00", "����", null);
//		int n = dao.insert(vo);
//		System.out.println( n + "�� ȸ�����!" );
		
//		List<MembersVo> list = dao.list();
//		for( MembersVo vo2 : list ) {
//			System.out.println("�̸�:" + vo2.getName());
//			System.out.println("��ȣ:" + vo2.getNum());
//			System.out.println("��ȭ��ȣ:" + vo2.getPhone());
//			System.out.println("�ּ�:" + vo2.getAddr());
//			System.out.println("������:" + vo2.getRegdate());
//			System.out.println("-----------------------------");
//		}
//		
//		int n = dao.delete(11);
//		System.out.println( n + "�� ȸ�� ������." );
		
//		int n = dao.update(vo);
//		System.out.println( n + "�� ȸ�� ������." );
		
		MembersVo v2 = dao.listOne(7);
		System.out.println("�̸�:" + v2.getName());
		System.out.println("��ȣ:" + v2.getNum());
		System.out.println("��ȭ��ȣ:" + v2.getPhone());
		System.out.println("�ּ�:" + v2.getAddr());
		System.out.println("������:" + v2.getRegdate());
		System.out.println("-----------------------------");
	}

}
