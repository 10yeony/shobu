package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//naming service(JNDI)를 이용해 datasource를 얻어오는것 
//싱글톤구사
public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("Data Look Up 성공*****");
		} catch (NamingException e) {
			System.out.println("Data Look Up 실패*****");
			e.printStackTrace();
		}
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getConnection() {
		return ds;
	}
}
