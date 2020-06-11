package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 어노테이션 기반으로 객체가 생성될수 있도록 설정하고 main메소드에서 컨트롤러를 호출해 사용해 보세요.
 */
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test02/test02.xml");
		MyController mc = (MyController)ac.getBean("myController");
		mc.execute();
	}
}
