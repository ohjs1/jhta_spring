package test.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.MembersDAO;

public class TestMain1 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/app/app1.xml");
		MembersDAO dao = (MembersDAO)ac.getBean("dao");
		
		dao.select("ȫ�浿1");
		dao.insert("ȫ�浿2");
		dao.update("ȫ�浿3");
		dao.delete("ȫ�浿4");
	}

}
