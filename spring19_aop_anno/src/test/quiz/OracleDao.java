package test.quiz;

public class OracleDao implements CommonsDao{
	private String dbserver;
	public void setDbserver(String dbserver) {
		this.dbserver = dbserver;
	}
	public String getDbserver() {
		return dbserver;
	}
	public void insert() {
		System.out.println("insert �����");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("�ɸ��ð� : " + (times/1000.0) + "��");
		System.out.println("���� �����");
	}
	
	public void update() {
		System.out.println("update �����");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("�ɸ��ð� : " + (times/1000.0) + "��");
		System.out.println("���� �����");
	}
	
	public void delete() {
		System.out.println("delete �����");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("�ɸ��ð� : " + (times/1000.0) + "��");
		System.out.println("���� �����");
	}
	
	public void select() {
		System.out.println("select �����");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("�ɸ��ð� : " + (times/1000.0) + "��");
		System.out.println("���� �����");
	}
}

