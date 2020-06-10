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
		MembersVo vo=new MembersVo(10, "����", "010", "����", null);
//		int n=dao.insert(vo);
//		System.out.println(n+"���� ȸ���� ��ϵ�");
//		int n=dao.delete(10);
//		System.out.println(n+"���� ȸ���� ������");
		MembersVo vo1=new MembersVo(4, null, "222", "�λ�", null);
//		int n=dao.update(vo1);
//		System.out.println(n+"���� ȸ���� ������");
//		List<MembersVo> list=dao.list();
//		for(MembersVo vo2:list) {
//			System.out.println("ȸ����ȣ:" + vo2.getNum());
//			System.out.println("ȸ���̸�:" + vo2.getName());
//			System.out.println("ȸ����ȭ��ȣ:" + vo2.getPhone());
//			System.out.println("ȸ���ּ�:" + vo2.getAddr());
//			System.out.println("ȸ��������:" + vo2.getRegdate());
//			System.out.println();
//		}
//		MembersVo vo3=dao.getinfo(13);
//		if(vo3!=null) {
//			System.out.println("<<��ȸ�� ȸ������>>");
//			System.out.println("ȸ����ȣ:" + vo3.getNum());
//			System.out.println("ȸ���̸�:" + vo3.getName());
//			System.out.println("ȸ����ȭ��ȣ:" + vo3.getPhone());
//			System.out.println("ȸ���ּ�:" + vo3.getAddr());
//			System.out.println("ȸ��������:" + vo3.getRegdate());
//		}else {
//			System.out.println("��ȸ�� ȸ�������� �����ϴ�");
//		}
		//ȸ���̸����� ������ ��ȸ�ϱ�
		List<MembersVo> list=dao.searchList("�浿");
		for(MembersVo vo4:list) {
			System.out.println("ȸ����ȣ:" + vo4.getNum());
			System.out.println("ȸ���̸�:" + vo4.getName());
			System.out.println("ȸ����ȭ��ȣ:" + vo4.getPhone());
			System.out.println("ȸ���ּ�:" + vo4.getAddr());
			System.out.println("ȸ��������:" + vo4.getRegdate());
			System.out.println();
		}
		
		
	}
}






