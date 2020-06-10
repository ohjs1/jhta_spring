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
		
		MembersVo v2 = service.select(1);
		
		if(v2 != null) {
			System.out.println("�̸�:" + v2.getName());
			System.out.println("��ȣ:" + v2.getNum());
			System.out.println("��ȭ��ȣ:" + v2.getPhone());
			System.out.println("�ּ�:" + v2.getAddr());
			System.out.println("������:" + v2.getRegdate());
			System.out.println("-----------------------------");
		} else {
			System.out.println("���� ȸ���Դϴ�.");
		}
	}

}
