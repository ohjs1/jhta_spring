package test04.quiz;

public interface CommonsDao {
	int insert(Object data);
	int delete(Object data);
	int update(Object data);
	Object select(Object data);
}
