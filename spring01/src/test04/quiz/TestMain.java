package test04.quiz;
/*
 * 					CommonDao : DAO가 가져야 할 목록 제시하는 인터페이스
 * 						|
 * 					 JDBCDao  : 인터페이스 구현한 클래스
 * 
 * 					MyController -> JDBCDao주입
 * 
 *  위의 구조에 해당하는 인터페이스와 클래스를 구현하고 스프링을 통해 객체 생성후
 *  사용해 보세요.
 *  
 * c:\과제\0609\퀴즈1폴더에 코드 올리세요.
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








