package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDao {
	private DataSource ds;
	
	private static ItemDao dao = new ItemDao();
	private ItemDao() {
		
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static ItemDao getInstance() {
		return dao;
	}
	
	//공통적인 로직... Connection, closeAll()
	public Connection getConnection() throws SQLException{
		System.out.println("디비 연결 성공...");
		return ds.getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	//가변적인 로직...
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM item";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(
						rs.getInt(1), 
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6)));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
}
