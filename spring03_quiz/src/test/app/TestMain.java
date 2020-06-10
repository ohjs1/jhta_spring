package test.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.MyUsersDao;
import test.vo.MyUsersVo;

/*
 * myusers���̺�� �����ؼ�
 * ������ �߰�/����/����/��ȸ/��ü��ȸ ��� �����غ���
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/testapp.xml");
		MyUsersDao dao = (MyUsersDao)ac.getBean("dao");
		
		//ȸ�� �߰�
		//String id, String pw, String email, Date mydate
//		MyUsersVo vo = new MyUsersVo("zzz", "12354", "1@naver.com", null);
//		int n = dao.insert(vo);	
//		System.out.println( n + "���� ȸ�� �߰���!" );
		
		//ȸ�� ����
//		MyUsersVo vo = new MyUsersVo("zzz", "test", "test@naver.com", null);
//		int n = dao.update(vo);
//		System.out.println(n + "���� ȸ�� ������");
		
		//ȸ������
//		int n = dao.delete("22");
//		System.out.println(n + "���� ȸ�� ������");
		
		//���̵�� ��ȸ
//		MyUsersVo vo = dao.list("zzz");
//		System.out.println("���̵�:" + vo.getId());
//		System.out.println("��й�ȣ:" + vo.getPw());
//		System.out.println("�̸���:" + vo.getEmail());
//		System.out.println("������:" + vo.getMydate());
		
		//��ü��ȸ
		List<MyUsersVo> list = dao.listAll();
		for(MyUsersVo vo : list) {
			System.out.println("���̵�:" + vo.getId());
			System.out.println("��й�ȣ:" + vo.getPw());
			System.out.println("�̸���:" + vo.getEmail());
			System.out.println("������:" + vo.getMydate());
			System.out.println("---------------------------");
		}
	}

}
