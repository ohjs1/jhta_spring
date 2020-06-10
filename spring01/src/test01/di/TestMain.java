package test01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		//Person객체 생성하고 값 저장후 출력하세요.
		/*
		 * Person person=new Person("최성진",26);
		 * System.out.println("이름:"+person.getName());
		 * System.out.println("나이:"+person.getAge());
		 */
		//Bean설정파일에서 정보 읽어와 (스프링이)객체 생성하기
		ApplicationContext ac=
			new ClassPathXmlApplicationContext("test01/di/app01.xml");
		//스프링이 생성한 객체 얻어오기
		Person pp=(Person)ac.getBean("person");
		System.out.println("이름:" + pp.getName());
		System.out.println("나이:" + pp.getAge());
		Person pp1=(Person)ac.getBean("person1");
		System.out.println("이름:" + pp1.getName());
		System.out.println("나이:" + pp1.getAge());
	}
}





