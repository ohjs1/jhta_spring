package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.quiz.CommonsDao;

/*
 * daoŬ�������� �޼ҵ尡 ����Ǵ� ó���ð��� ���ؼ� ����ϴ� ����� AOP�� ����� ������ ������.
 * System.currentTimemills()
 */
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/jhta/spring17/aop/app.xml");
		CommonsDao dao = (CommonsDao)ac.getBean("oracleDao");
		dao.insert();
		dao.update();
		dao.select();
		dao.delete();
	}
}
