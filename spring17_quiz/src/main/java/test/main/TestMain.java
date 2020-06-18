package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.quiz.CommonsDao;

/*
 * dao클래스내의 메소드가 실행되는 처리시간을 구해서 출력하는 기능을 AOP를 사용해 구현해 보세요.
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
