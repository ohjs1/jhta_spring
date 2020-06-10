package test04.quiz;
/*
 * 					CommonDao : DAO�� ������ �� ��� �����ϴ� �������̽�
 * 						|
 * 					 JDBCDao  : �������̽� ������ Ŭ����
 * 
 * 					MyController -> JDBCDao����
 * 
 *  ���� ������ �ش��ϴ� �������̽��� Ŭ������ �����ϰ� �������� ���� ��ü ������
 *  ����� ������.
 *  
 * c:\����\0609\����1������ �ڵ� �ø�����.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("test04/quiz/app04.xml");
		MyController mc=
				(MyController)ac.getBean("controller");
		mc.service();
		System.out.println("mc:" + mc);
		MyController mc1=(MyController)ac.getBean("controller");
		System.out.println("mc1:" + mc1);
	}
}








