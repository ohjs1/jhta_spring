package test04.quiz;

public class JDBCDao implements CommonsDao{
	public void init() {
		System.out.println("jdbc�� ����ϱ� ���� �ʱ�ȭ �۾� ����!");
	}
	public void destroy() {
		System.out.println("jdbc�� �����ϱ� ���� �۾� ����!");
	}
	
	@Override
	public int insert(Object data) {
		System.out.println("jdbc�� ����Ͽ� " + data +" insert");
		return 1;
	}

	@Override
	public int delete(Object data) {
		System.out.println("jdbc�� ����Ͽ� " + data+" delete");
		return 1;
	}

	@Override
	public int update(Object data) {
		System.out.println("jdbc�� ����Ͽ� " + data+" update");
		return 1;
	}

	@Override
	public Object select(Object data) {
		System.out.println("jdbc�� ����Ͽ� " + data+" select");
		return "ȫ�浿";
	}
	
}
