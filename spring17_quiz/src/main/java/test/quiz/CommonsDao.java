package test.quiz;

public interface CommonsDao {
	void setDbserver(String dbserver);
	String getDbserver();
	void insert();
	void update();
	void delete();
	void select();

}
