package test04.quiz;

public class JDBCDao implements CommonsDao{
	public void init() {
		System.out.println("jdbc를 사용하기 위한 초기화 작업 수행!");
	}
	public void destroy() {
		System.out.println("jdbc를 종료하기 위한 작업 수행!");
	}
	
	@Override
	public int insert(Object data) {
		System.out.println("jdbc를 사용하여 " + data +" insert");
		return 1;
	}

	@Override
	public int delete(Object data) {
		System.out.println("jdbc를 사용하여 " + data+" delete");
		return 1;
	}

	@Override
	public int update(Object data) {
		System.out.println("jdbc를 사용하여 " + data+" update");
		return 1;
	}

	@Override
	public Object select(Object data) {
		System.out.println("jdbc를 사용하여 " + data+" select");
		return "홍길동";
	}
	
}
