package com.shobu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.shobu.config.ServerInfo;
import com.shobu.crawling.PlayerUpdate;
import com.shobu.model.ChatVO;
import com.shobu.model.HitterVO;
import com.shobu.model.MapVO;
import com.shobu.model.MatchVO;
import com.shobu.model.MemberVO;
import com.shobu.model.Pitcher3VO;
import com.shobu.model.PitcherVO;
import com.shobu.model.PlayerVO;
import com.shobu.model.TeamVO;
import com.shobu.model.totoVO;

public class ModelDaoImpl implements ModelDAO{

	//실제로는 DataSource 사용

	private DataSource ds;
	private static ModelDaoImpl dao = new ModelDaoImpl();
	private ModelDaoImpl() {
		try {
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup Success..");
		}catch(NamingException e) {
			e.printStackTrace();
			//System.out.println("DataSource Lookup failed...");
		}
	}	
	public static ModelDaoImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	//단위테스트 할 때 DataSource 관련 코드는 주석으로 막고 DriverManager로 하면 됨

	/*private static ModelDaoImpl ds = new ModelDaoImpl();
	private ModelDaoImpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading Fail...."); 
		}
	}
	public static ModelDaoImpl getInstance() {
		return ds;
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}

	
	
	//단위 테스트
	public static void main(String[] args) throws Exception {
	}*/
	
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
	public void updatePlayer(PlayerVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into player values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vo.getPlayerId());
			ps.setString(2, vo.getTeamCode());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getPosition());
			ps.setString(5, vo.getImage());
			ps.setInt(6, vo.getNumber());
			ps.setString(7, vo.getBirth());
			ps.setString(8, vo.getType());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public void updateHitter(HitterVO vo, int playerId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into hitter values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, playerId);
			ps.setInt(2, vo.getGames());
			ps.setDouble(3, vo.getRate());
			ps.setInt(4, vo.getAb());
			ps.setInt(5, vo.getHits());
			ps.setInt(6, vo.getHr());
			ps.setInt(7, vo.getRbi());
			ps.setInt(8, vo.getRuns());
			ps.setInt(9, vo.getBb());
			ps.setInt(10, vo.getSo());
			ps.setDouble(11, vo.getObp());
			ps.setDouble(12, vo.getSlg());
			ps.setDouble(13, vo.getOps());
			ps.setInt(14, vo.getSteal());
			ps.setInt(15, vo.getError());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public void updatePitcher(PitcherVO vo, int playerId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into pitcher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, playerId);
			ps.setInt(2, vo.getGames());
			ps.setString(3, vo.getInning());
			ps.setDouble(4, vo.getEra());
			ps.setDouble(5, vo.getRate());
			ps.setInt(6, vo.getWin());
			ps.setInt(7, vo.getLose());
			ps.setInt(8, vo.getSave());
			ps.setInt(9, vo.getHold());
			ps.setInt(10, vo.getRuns());
			ps.setInt(11, vo.getHr());
			ps.setInt(12, vo.getHits());
			ps.setInt(13, vo.getSo());
			ps.setInt(14, vo.getBb());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public void updatePitcher3(Pitcher3VO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into pitcher3 values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vo.getPlayerId());
			ps.setString(2, vo.getDay1());
			ps.setString(3, vo.getDay2());
			ps.setString(4, vo.getDay3());
			ps.executeUpdate();
			
		} finally {
			closeAll(ps, conn);
		}
	}
	@Override
	public void updateTeam(TeamVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into team values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getTeamCode());
			ps.setString(2, "image/team/"+vo.getTeamCode()+".png");
			ps.setInt(3, vo.getRanking());
			ps.setInt(4, vo.getGames());
			ps.setInt(5, vo.getWin());
			ps.setInt(6, vo.getDraw());
			ps.setInt(7, vo.getLose());
			ps.setDouble(8, vo.getRate());
			ps.setDouble(9, vo.getDistance());
			ps.setDouble(10, vo.getTeamAVG());
			ps.setDouble(11, vo.getTeamEra());
			ps.setString(12, vo.getStream());
			ps.setString(13, vo.getGames10());
			ps.executeUpdate();
			
			System.out.println("insert OK");
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public ArrayList<TeamVO> selectAllTeam() throws SQLException {
		ArrayList<TeamVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from team order by ranking;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				TeamVO team = new TeamVO();
				team.setTeamCode(rs.getString(1));
				team.setImage(rs.getString(2));
				team.setRanking(rs.getInt(3));
				team.setGames(rs.getInt(4));
				team.setWin(rs.getInt(5));
				team.setDraw(rs.getInt(6));
				team.setLose(rs.getInt(7));
				team.setRate(rs.getDouble(8));
				team.setDistance(rs.getInt(9));
				team.setTeamAVG(rs.getDouble(10));
				team.setTeamEra(rs.getDouble(11));
				team.setStream(rs.getString(12));
				team.setGames10(rs.getString(13));
				
				
				switch(rs.getString(1)) {
				case "OB":
					team.setTeamName("두산베어스");
					break;
				case "KT":
					team.setTeamName("kt위즈");
					break;
				case "LG":
					team.setTeamName("LG트윈스");
					break;
				case "HT":
					team.setTeamName("KIA타이거즈");
					break;
				case "LT":
					team.setTeamName("롯데자이언츠");
					break;
				case "WO":
					team.setTeamName("키움히어로즈");
					break;
				case "SK":
					team.setTeamName("SK와이번스");
					break;
				case "SS":
					team.setTeamName("삼성라이온즈");
					break;
				case "NC":
					team.setTeamName("NC다이노스");
					break;
				case "HH":
					team.setTeamName("한화이글스");
					break;
				}
				
				list.add(team);
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	@Override
	public TeamVO selectTeam(String teamCode) throws SQLException {
		TeamVO team = new TeamVO();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from team where teamCode = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, teamCode);
			rs = ps.executeQuery();
			
			team.setTeamCode(rs.getString(1));
			team.setImage(rs.getString(2));
			team.setRanking(rs.getInt(3));
			team.setGames(rs.getInt(4));
			team.setWin(rs.getInt(5));
			team.setDraw(rs.getInt(6));
			team.setLose(rs.getInt(7));
			team.setRate(rs.getDouble(8));
			team.setDistance(rs.getInt(9));
			team.setTeamAVG(rs.getDouble(10));
			team.setTeamEra(rs.getDouble(11));
			team.setStream(rs.getString(12));
			team.setGames10(rs.getString(13));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return team;
	}
	@Override
	public HitterVO selectHitter(int playerId) throws SQLException {
		HitterVO hitter = new HitterVO();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from hitter where playerId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			
			hitter.setGames(rs.getInt(2));
			hitter.setRate(rs.getDouble(3));
			hitter.setAb(rs.getInt(4));
			hitter.setHits(rs.getInt(5));
			hitter.setHr(rs.getInt(6));
			hitter.setRbi(rs.getInt(7));
			hitter.setRuns(rs.getInt(8));
			hitter.setBb(rs.getInt(9));
			hitter.setSo(rs.getInt(10));
			hitter.setObp(rs.getDouble(11));
			hitter.setSlg(rs.getDouble(12));
			hitter.setOps(rs.getDouble(12));
			hitter.setSteal(rs.getInt(13));
			hitter.setError(rs.getInt(14));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return hitter;
	}
	@Override
	public ArrayList<HitterVO> selectAllHitter() throws SQLException {
		ArrayList<HitterVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from hitter";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				HitterVO hitter = new HitterVO();
				hitter.setGames(rs.getInt(2));
				hitter.setRate(rs.getDouble(3));
				hitter.setAb(rs.getInt(4));
				hitter.setHits(rs.getInt(5));
				hitter.setHr(rs.getInt(6));
				hitter.setRbi(rs.getInt(7));
				hitter.setRuns(rs.getInt(8));
				hitter.setBb(rs.getInt(9));
				hitter.setSo(rs.getInt(10));
				hitter.setObp(rs.getDouble(11));
				hitter.setSlg(rs.getDouble(12));
				hitter.setOps(rs.getDouble(12));
				hitter.setSteal(rs.getInt(13));
				hitter.setError(rs.getInt(14));
				
				list.add(hitter);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	@Override
	public PitcherVO selectPitcher(int playerId) throws SQLException {
		PitcherVO pitcher = new PitcherVO();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from pitcher where playerId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			
			pitcher.setGames(rs.getInt(2));
			pitcher.setInning(rs.getString(3));
			pitcher.setEra(rs.getDouble(4));
			pitcher.setRate(rs.getDouble(5));
			pitcher.setWin(rs.getInt(6));
			pitcher.setLose(rs.getInt(7));
			pitcher.setSave(rs.getInt(8));
			pitcher.setHold(rs.getInt(9));
			pitcher.setRuns(rs.getInt(10));
			pitcher.setHr(rs.getInt(11));
			pitcher.setHits(rs.getInt(12));
			pitcher.setSo(rs.getInt(13));
			pitcher.setBb(rs.getInt(14));
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return pitcher;
	}
	@Override
	public ArrayList<PitcherVO> selectAllPitcher() throws SQLException {
		ArrayList<PitcherVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from pitcher";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PitcherVO pitcher = new PitcherVO();
				pitcher.setGames(rs.getInt(2));
				pitcher.setInning(rs.getString(3));
				pitcher.setEra(rs.getDouble(4));
				pitcher.setRate(rs.getDouble(5));
				pitcher.setWin(rs.getInt(6));
				pitcher.setLose(rs.getInt(7));
				pitcher.setSave(rs.getInt(8));
				pitcher.setHold(rs.getInt(9));
				pitcher.setRuns(rs.getInt(10));
				pitcher.setHr(rs.getInt(11));
				pitcher.setHits(rs.getInt(12));
				pitcher.setSo(rs.getInt(13));
				pitcher.setBb(rs.getInt(14));
				
				list.add(pitcher);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	@Override
	public ArrayList<PlayerVO> selectAllPlayer() throws SQLException {
		ArrayList<PlayerVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PlayerVO player = new PlayerVO();
				player.setPlayerId(rs.getInt(1));
				player.setTeamCode(rs.getString(2));
				player.setName(rs.getString(3));
				player.setPosition(rs.getString(4));
				player.setName(rs.getString(5));
				
				list.add(player);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	@Override
	public PlayerVO selectPlayer(int playerId) throws SQLException {
		PlayerVO player= new PlayerVO();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player where playerId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			
			player.setPlayerId(rs.getInt(1));
			player.setTeamCode(rs.getString(2));
			player.setName(rs.getString(3));
			player.setPosition(rs.getString(4));
			player.setName(rs.getString(5));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	@Override
	public PlayerVO selectPlayer(String name) throws SQLException {
		PlayerVO player= new PlayerVO();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player where name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			player.setPlayerId(rs.getInt(1));
			player.setTeamCode(rs.getString(2));
			player.setName(rs.getString(3));
			player.setPosition(rs.getString(4));
			player.setName(rs.getString(5));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	@Override
	public ArrayList<PlayerVO> selectByTeamName(String teamCode) throws SQLException {
		ArrayList<PlayerVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player where teamCode = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, teamCode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PlayerVO player = new PlayerVO();
				player.setPlayerId(rs.getInt(1));
				player.setTeamCode(rs.getString(2));
				player.setName(rs.getString(3));
				player.setPosition(rs.getString(4));
				player.setName(rs.getString(5));
				
				list.add(player);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	@Override
	public boolean login(String id, String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM members WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(pass)) {
					return true;
				}
			}
			return false;
		}finally{
			closeAll(rs, ps, conn);
		}
	}
	
	@Override
	public void register(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO members (id, password, nickname, image, point) VALUES (?,?,?,?,0)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getNickname());
			ps.setString(4, vo.getImage());
			System.out.println(ps.executeUpdate()+"줄 추가");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public MemberVO FindMemberById(String id) throws SQLException{
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM members WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString("id"),
								rs.getString("password"),
								rs.getString("nickname"),
								rs.getString("image"),
								rs.getInt("point"));
			}
			return vo;
		}finally {
			closeAll(rs, ps, conn);
		}
	}
	public MemberVO FindMemberByNickname(String nickname) throws SQLException{
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM members WHERE nickname=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString("id"),
								rs.getString("password"),
								rs.getString("nickname"),
								rs.getString("image"),
								rs.getInt("point"));
			}
			return vo;
		}finally {
			closeAll(rs, ps, conn);
		}
	}
	@Override
	public void updateMatch(MatchVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "insert into matches values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getDate());
			ps.setString(2, vo.getTime());
			ps.setString(3, vo.getHome());
			ps.setString(4, vo.getAway());
			ps.setString(5, vo.getHomePitcher());
			ps.setString(6, vo.getAwayPitcher());
			ps.setString(7, vo.getPlace());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public ArrayList<MatchVO> selectMatch() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MatchVO> match = new ArrayList<MatchVO>();
		String query = "SELECT * FROM matches";
		Map<String, String> logo = new HashMap<String, String>();
		String home = "";
		String away = "";
		
		try {
			conn = getConnection();
			logo = getLogo(conn);
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				match.add(new MatchVO(rs.getString("date"), rs.getString("time"), rs.getString("home"),
						rs.getString("away"), rs.getString("homePitcher"), rs.getString("awayPitcher"), rs.getString("place")));
			}
			
			for(int i =0; i<match.size();i++) {
				home = match.get(i).getHome();
				away = match.get(i).getAway();
				System.out.println("Home: "+home+"Away: "+away);
				
				if(logo.containsKey(home) && logo.containsKey(away)) {
					match.get(i).setHomeImg(logo.get(home));
					match.get(i).setAwayImg(logo.get(away));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return match;
	}
	
	@Override
	public ArrayList<MapVO> selectMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ChatVO> selectChat() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertChat(ChatVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int resultToto(totoVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updatePoint(String id, int point) throws SQLException {
		// TODO Auto-generated method stub
	}
	
	public Map<String, String> getLogo(Connection conn) throws SQLException{
		Map<String, String> logo = new HashMap<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT teamCode,image FROM team";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				switch(rs.getString(1)) {
				case "OB":
					logo.put("두산",rs.getString(2));
					break;
				case "KT":
					logo.put("KT",rs.getString(2));
					break;
				case "LG":
					logo.put("LG",rs.getString(2));
					break;
				case "HT":
					logo.put("KIA",rs.getString(2));
					break;
				case "LT":
					logo.put("롯데",rs.getString(2));
					break;
				case "WO":
					logo.put("키움",rs.getString(2));
					break;
				case "SK":
					logo.put("SK",rs.getString(2));
					break;
				case "SS":
					logo.put("삼성",rs.getString(2));
					break;
				case "NC":
					logo.put("NC",rs.getString(2));
					break;
				case "HH":
					logo.put("한화",rs.getString(2));
					break;
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return logo;
	}

}
