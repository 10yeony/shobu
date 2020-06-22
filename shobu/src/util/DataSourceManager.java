package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * 비즈니스로직을 하기 위한 전처리 단계이므로 model에 안 넣고 util로 빼는 게 좋음.(경우에 따라 다르긴 함)
 * JNDI API(Naming Service)를 이용해서 DataSource를 리턴받아 온다.(look-up)
 * (JNDI 서비스를 이용해서 xml에 바인딩함. Content.xml에서 수정된 스키마에 맞게 url 수정)
 * 싱글톤 구사
 */
public class DataSourceManager {
	private DataSource ds; //javax.sql에서 가져와야 함.
	
	//싱글톤
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		//InitialContext 객체의 lookup()을 이용해서 ds 하나 받아오는 로직...
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup OK....");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail....");
		}
		
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getConnection() {
		return ds;
	}
}
