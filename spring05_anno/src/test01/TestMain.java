package test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test01/test01.xml");
		MembersController mc = (MembersController)ac.getBean("mController"); 
		//클래스이름으로 생성됨( 시작문자는 소문자 ) Controller(value="") 속성으로 이름지정가능
		mc.execute();
	}
}
