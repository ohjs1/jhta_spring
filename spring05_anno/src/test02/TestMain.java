package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ������̼� ������� ��ü�� �����ɼ� �ֵ��� �����ϰ� main�޼ҵ忡�� ��Ʈ�ѷ��� ȣ���� ����� ������.
 */
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test02/test02.xml");
		MyController mc = (MyController)ac.getBean("myController");
		mc.execute();
	}
}
