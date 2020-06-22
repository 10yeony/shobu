package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds; 
	
	
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		
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
