package test04.quiz;

public class MyController {
	private CommonsDao dao; //MyController�� JDBCDao ����
	public MyController(CommonsDao dao) {//������ ���� DI
		this.dao=dao;
	}
	public void service() {
		dao.insert("�迵��");
		dao.delete("�̿���");
		dao.update("�￵��");
		dao.select("1");
	}
}
