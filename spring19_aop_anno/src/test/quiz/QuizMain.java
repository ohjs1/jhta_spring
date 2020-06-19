package test.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * �Ű������� ���޵Ǵ� ���� ���ϰ��� ����ϴ� �����̽�
 * ����� ����ǵ��� �غ����� . ������̼� ������� ��������.
 * 
 */
public class QuizMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/appQuiz.xml");
		QuizDao dao = (QuizDao)ac.getBean("dao");
		
		System.out.println("�ǵ������� ���� : " +dao.returnInt(10));
	}

}
