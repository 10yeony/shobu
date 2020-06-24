package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ModelDaoImpl;

public class ModelDaoImpl implements ModelDAO{
	private DataSource ds;
	
	private static ModelDaoImpl dao = new ModelDaoImpl();
	private ModelDaoImpl() {
		try {
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup Success..");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup failed...");
		}
	}	
	public static ModelDaoImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	@Override
	public void updateDB() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PlayerVO searchByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PlayerVO> searchByTeamName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void teamRecord() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
