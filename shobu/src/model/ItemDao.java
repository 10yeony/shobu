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
		//공장 받아오기
		ds = DataSourceManager.getInstance().getConnection();
	};
	public static ItemDao getInstance() {
		return dao;
	}
	
	//공통로직 Connection , Close All;
	public Connection getConnection() throws SQLException{
		System.out.println("DB연결 성공");
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps !=null) ps.close();
		if(conn !=null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs !=null) rs.close();
		closeAll(ps, conn);
	}
	
	//가변로직
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list=  new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM item";
			conn = getConnection();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(rs.getInt(1),
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
	
	public Item getItem(int itemid) throws SQLException{
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(itemid,
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return item;
	}
	
	public void countView(int itemid) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "UPDATE item SET count = count+ 1 WHERE item_id=?";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);
			
			System.out.println(ps.executeUpdate()+"개 업데이트");
		}finally {
			closeAll(ps, conn);
		}
	}
}//단위테스트는 드라이버 매니저를 사용해서 돌려야 DB연결됨
