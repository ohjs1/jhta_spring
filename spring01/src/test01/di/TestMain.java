package test01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		//Person��ü �����ϰ� �� ������ ����ϼ���.
		/*
		 * Person person=new Person("�ּ���",26);
		 * System.out.println("�̸�:"+person.getName());
		 * System.out.println("����:"+person.getAge());
		 */
		//Bean�������Ͽ��� ���� �о�� (��������)��ü �����ϱ�
		ApplicationContext ac=
			new ClassPathXmlApplicationContext("test01/di/app01.xml");
		//�������� ������ ��ü ������
		Person pp=(Person)ac.getBean("person");
		System.out.println("�̸�:" + pp.getName());
		System.out.println("����:" + pp.getAge());
		Person pp1=(Person)ac.getBean("person1");
		System.out.println("�̸�:" + pp1.getName());
		System.out.println("����:" + pp1.getAge());
	}
}





