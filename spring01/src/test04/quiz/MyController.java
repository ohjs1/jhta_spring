package test04.quiz;

public class MyController {
	private CommonsDao dao; //MyController´Â JDBCDao ÀÇÁ¸
	public MyController(CommonsDao dao) {//ÀÇÁ¸¼º ÁÖÀÔ DI
		this.dao=dao;
	}
	public void service() {
		dao.insert("±è¿µÈñ");
		dao.delete("ÀÌ¿µÈñ");
		dao.update("»ï¿µÈñ");
		dao.select("1");
	}
}
