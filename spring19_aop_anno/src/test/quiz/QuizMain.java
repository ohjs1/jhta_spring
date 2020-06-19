package test.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 매개변수로 전달되는 값과 리턴값을 출력하는 어드바이스
 * 만들고 적용되도록 해보세요 . 어노테이션 기반으로 만들어보세요.
 * 
 */
public class QuizMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/appQuiz.xml");
		QuizDao dao = (QuizDao)ac.getBean("dao");
		
		System.out.println("되돌려받은 정수 : " +dao.returnInt(10));
	}

}
