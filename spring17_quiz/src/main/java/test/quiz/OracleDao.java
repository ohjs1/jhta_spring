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
		System.out.println("insert 실행됨");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("걸린시간 : " + (times/1000.0) + "초");
		System.out.println("실행 종료됨");
	}
	
	public void update() {
		System.out.println("update 실행됨");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("걸린시간 : " + (times/1000.0) + "초");
		System.out.println("실행 종료됨");
	}
	
	public void delete() {
		System.out.println("delete 실행됨");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("걸린시간 : " + (times/1000.0) + "초");
		System.out.println("실행 종료됨");
	}
	
	public void select() {
		System.out.println("select 실행됨");
		long beforeTime = System.currentTimeMillis();
		
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<1000000; j++);
		}
		
		long atterTime = System.currentTimeMillis();
		long times = atterTime - beforeTime;
		System.out.println("걸린시간 : " + (times/1000.0) + "초");
		System.out.println("실행 종료됨");
	}
}

