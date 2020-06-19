package test.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.quiz.CommonsDao;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/app.xml");
		CommonsDao dao = (CommonsDao)ac.getBean("dao");
		
		dao.insert();
		dao.update();
		dao.select();
		dao.delete();
	}

}
