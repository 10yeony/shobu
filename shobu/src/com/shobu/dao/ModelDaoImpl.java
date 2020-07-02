package com.shobu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.jws.WebParam.Mode;

import com.shobu.config.ServerInfo;
import com.shobu.controller.Playerlist;
import com.shobu.datasource.DataSourceManager;
import com.shobu.logic.Logic;
import com.shobu.model.ChatVO;
import com.shobu.model.HitterListVO;
import com.shobu.model.HitterVO;
import com.shobu.model.MapVO;
import com.shobu.model.MatchVO;
import com.shobu.model.MemberVO;
import com.shobu.model.Pitcher3VO;
import com.shobu.model.PitcherListVO;
import com.shobu.model.PitcherVO;
import com.shobu.model.PlayerListVO;
import com.shobu.model.PlayerVO;
import com.shobu.model.ResultVO;
import com.shobu.model.TeamVO;
import com.shobu.model.TotoVO;

public class ModelDaoImpl implements ModelDAO{

	/*
	//실제로는 DataSource 사용
	private DataSourceManager dsm = DataSourceManager.getInstance();
	private static ModelDaoImpl dao = new ModelDaoImpl();
	private ModelDaoImpl() {}	
	public static ModelDaoImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		return dsm.getConnection();
	}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		dsm.close(ps);
		dsm.close(conn);
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		dsm.close(rs);
		closeAll(ps, conn);		
	}
	*/
	
	//단위테스트 할 때 DataSource 관련 코드는 주석으로 막고 DriverManager로 하면 됨
	private static ModelDaoImpl ds = new ModelDaoImpl();
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
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	//단위 테스트
	public static void main(String[] args) throws Exception {
		ModelDaoImpl dao = ModelDaoImpl.getInstance();
		String date = "2020-06-27";
		dao.updatePoint(date);
	}
	
	
	
	/* ================= 업데이트 ===================== */
	
	/* 선수 업데이트 */
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
	
	/* 타자 업데이트 */
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
	
	/* 투수 업데이트 */
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
	
	/* 투수 최근 3경기 업데이트 */
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
	
	/* 팀 업데이트 */
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
	/* ================================================ */
	
	
	
	/* ================= 선수 및 팀 정보 불러오기 ===================== */
	
	/* 모든 팀 정보 불러오기 */
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
					team.setTeamName("두산 베어스");
					break;
				case "KT":
					team.setTeamName("kt 위즈");
					break;
				case "LG":
					team.setTeamName("LG 트윈스");
					break;
				case "HT":
					team.setTeamName("기아 타이거즈");
					break;
				case "LT":
					team.setTeamName("롯데 자이언츠");
					break;
				case "WO":
					team.setTeamName("키움 히어로즈");
					break;
				case "SK":
					team.setTeamName("SK 와이번스");
					break;
				case "SS":
					team.setTeamName("삼성 라이온즈");
					break;
				case "NC":
					team.setTeamName("NC 다이노스");
					break;
				case "HH":
					team.setTeamName("한화 이글스");
					break;
				}
				
				list.add(team);
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/* 팀 코드로 특정 팀 불러오기 */
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
			
			if(rs.next()) {
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
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return team;
	}
	
	@Override
	public int selectTeamRankERA(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = getConnection();
			String query = "select teamCode, rank() over(order by teamERA) as 'rank' from team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("teamCode").equals(teamCode)) result = rs.getInt("rank");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return result;
	}
	@Override
	public int selectTeamRankAVG(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = getConnection();
			String query = "select teamCode, rank() over(order by teamAVG desc) as 'rank' from team";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("teamCode").equals(teamCode)) result = rs.getInt("rank");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return result;
	}
	//방어율 1위
	@Override
	public PitcherListVO selectPlayerRankERA(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PitcherListVO player = new PitcherListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, c.era, p.playerId from player p, pitcher c where p.playerid = c.playerid AND cast(inning as signed) > (select games from team where teamCode = 'LT') order by era limit 1";
			else
				query = "select p.name, c.era, p.playerId from player p, pitcher c where p.playerid = c.playerid AND p.teamCode = '"+teamCode+"' AND cast(inning as signed) > (select games from team where teamCode = '"+teamCode+"') order by win desc, era limit 1";
			ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	player.setName(rs.getString(1));
	        	player.setEra(rs.getDouble(2));
	        	player.setPlayerId(rs.getInt(3));
	        }
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//다승 1위
	@Override
	public PitcherListVO selectPlayerRankWIN(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PitcherListVO player = new PitcherListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, c.win, p.playerId from player p, pitcher c where p.playerid = c.playerid order by win desc, era limit 1";
			else
				query = "select p.name, c.win, p.playerId from player p, pitcher c where p.playerid = c.playerid AND p.teamCode = '"+teamCode+"' order by win desc, era limit 1";
			ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	player.setName(rs.getString(1));
	        	player.setWin(rs.getInt(2));
	        	player.setPlayerId(rs.getInt(3));
	        }
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//세이브 1위
	@Override
	public PitcherListVO selectPlayerRankSAVE(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PitcherListVO player = new PitcherListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, c.save, p.playerId from player p, pitcher c where p.playerid = c.playerid order by save desc, era limit 1";
			else
				query = "select p.name, c.save, p.playerId from player p, pitcher c where p.playerid = c.playerid AND p.teamCode = '"+teamCode+"' order by save desc, era limit 1";
			ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	player.setName(rs.getString(1));
	        	player.setSave(rs.getInt(2));
	        	player.setPlayerId(rs.getInt(3));
	        }
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//삼진 1위
	@Override
	public PitcherListVO selectPlayerRankSO(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PitcherListVO player = new PitcherListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, c.so, p.playerId from player p, pitcher c where p.playerid = c.playerid order by so desc, era limit 1";
			else
				query = "select p.name, c.so, p.playerId from player p, pitcher c where p.playerid = c.playerid AND p.teamCode = '"+teamCode+"' order by so desc, era limit 1";
			ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	player.setName(rs.getString(1));
	        	player.setSo(rs.getInt(2));
	        	player.setPlayerId(rs.getInt(3));
	        }
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//타율 1위
	@Override
	public HitterListVO selectPlayerRankAVG(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HitterListVO player = new HitterListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, h.rate, p.playerId from player p, hitter h where p.playerId = h.playerId AND h.ab*3 > (select games from team where teamCode='LT') order by rate desc limit 1";
			else
				query = "select p.name, h.rate, p.playerId from player p, hitter h where p.playerId = h.playerId AND p.teamCode = '"+teamCode+"' AND h.ab*3 > (select games from team where teamCode='"+teamCode+"') order by rate desc limit 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				player.setName(rs.getString(1));
				player.setRate(rs.getDouble(2));
				player.setPlayerId(rs.getInt(3));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//타점 1위
	@Override
	public HitterListVO selectPlayerRankRBI(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HitterListVO player = new HitterListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, h.rbi, p.playerId from player p, hitter h where p.playerId = h.playerId order by rbi desc limit 1";
			else
				query = "select p.name, h.rbi, p.playerId from player p, hitter h where p.playerId = h.playerId AND p.teamCode = '"+teamCode+"' order by rbi desc limit 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				player.setName(rs.getString(1));
				player.setRbi(rs.getInt(2));
				player.setPlayerId(rs.getInt(3));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	
	//홈런 1위
	@Override
	public HitterListVO selectPlayerRankHR(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HitterListVO player = new HitterListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, h.hr, p.playerId from player p, hitter h where p.playerId = h.playerId order by hr desc limit 1";
			else
				query = "select p.name, h.hr, p.playerId from player p, hitter h where p.playerId = h.playerId AND p.teamCode = '"+teamCode+"' order by hr desc limit 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				player.setName(rs.getString(1));
				player.setHr(rs.getInt(2));
				player.setPlayerId(rs.getInt(3));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	//안타 1위
	@Override
	public HitterListVO selectPlayerRankHITS(String teamCode) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HitterListVO player = new HitterListVO();
		String query;
		
		try {
			conn = getConnection();
			if(teamCode.equals("ALL"))
				query = "select p.name, h.hits, p.playerId from player p, hitter h where p.playerId = h.playerId order by hits desc limit 1";
			else
				query = "select p.name, h.hits, p.playerId from player p, hitter h where p.playerId = h.playerId AND p.teamCode = '"+teamCode+"' order by hits desc limit 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				player.setName(rs.getString(1));
				player.setHits(rs.getInt(2));
				player.setPlayerId(rs.getInt(3));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}

	
	/* 선수ID로 특정 타자 불러오기 */
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
	
	/* 모든 타자 불러오기 */
	@Override
	public ArrayList<HitterListVO> selectAllHitter() throws SQLException {
		ArrayList<HitterListVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player p, hitter h where p.playerId = h.playerId order by rate desc";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				HitterListVO hitter = new HitterListVO();
				hitter.setPlayerId(rs.getInt(1));
				hitter.setTeamCode(rs.getString(2));
				hitter.setName(rs.getString(3));
				hitter.setPosition(rs.getString(4));
				hitter.setImage(rs.getString(5));
				hitter.setNumber(rs.getInt(6));
				hitter.setBirth(rs.getString(7));
				hitter.setType(rs.getString(8));
				hitter.setGames(rs.getInt(10));
				hitter.setRate(rs.getDouble(11));
				hitter.setAb(rs.getInt(12));
				hitter.setHits(rs.getInt(13));
				hitter.setHr(rs.getInt(14));
				hitter.setRbi(rs.getInt(15));
				hitter.setRuns(rs.getInt(16));
				hitter.setBb(rs.getInt(17));
				hitter.setSo(rs.getInt(18));
				hitter.setObp(rs.getDouble(19));
				hitter.setSlg(rs.getDouble(20));
				hitter.setOps(rs.getDouble(21));
				hitter.setSteal(rs.getInt(22));
				hitter.setError(rs.getInt(23));
				
				list.add(hitter);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/* 선수ID로 특정 투수 불러오기 */
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
			
			if(rs.next()) {
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
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return pitcher;
	}
	
	/* 모든 투수 불러오기 */
	@Override
	public ArrayList<PitcherListVO> selectAllPitcher() throws SQLException {
		ArrayList<PitcherListVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player p, pitcher c where c.playerId = p.playerId and c.inning is not null order by era";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PitcherListVO pitcher = new PitcherListVO();
				pitcher.setPlayerId(rs.getInt(1));
				pitcher.setTeamCode(rs.getString(2));
				pitcher.setName(rs.getString(3));
				pitcher.setPosition(rs.getString(4));
				pitcher.setImage(rs.getString(5));
				pitcher.setNumber(rs.getInt(6));
				pitcher.setBirth(rs.getString(7));
				pitcher.setType(rs.getString(8));
				pitcher.setGames(rs.getInt(10));
				pitcher.setInning(rs.getString(11));
				pitcher.setEra(rs.getDouble(12));
				pitcher.setRate(rs.getDouble(13));
				pitcher.setWin(rs.getInt(14));
				pitcher.setLose(rs.getInt(15));
				pitcher.setSave(rs.getInt(16));
				pitcher.setHold(rs.getInt(17));
				pitcher.setRuns(rs.getInt(18));
				pitcher.setHr(rs.getInt(19));
				pitcher.setHits(rs.getInt(20));
				pitcher.setSo(rs.getInt(21));
				pitcher.setBb(rs.getInt(22));
				
				list.add(pitcher);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/* 모든 선수 불러오기 */
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
	
	/* 선수 ID로 특정 선수 불러오기 */
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
			
			while(rs.next()) {
				player.setPlayerId(rs.getInt(1));
				player.setTeamCode(rs.getString(2));
				player.setName(rs.getString(3));
				player.setPosition(rs.getString(4));
				player.setImage(rs.getString(5));
				player.setNumber(rs.getInt(6));
				player.setBirth(rs.getString(7));
				player.setType(rs.getString(8));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return player;
	}
	
	/* 이름으로 특정 선수 불러오기(동명이인) */
	@Override
	public ArrayList<PlayerVO> selectPlayer(String name) throws SQLException {
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
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
			while(rs.next()) {
				player.setPlayerId(rs.getInt(1));
				player.setTeamCode(rs.getString(2));
				player.setName(rs.getString(3));
				player.setPosition(rs.getString(4));
				player.setName(rs.getString(5));
				
				players.add(player);
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return players;
	}
	
	/* 팀 코드로 선수 목록 불러오기 */
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
	public ArrayList<HitterListVO> selectAllHitter(String teamCode) throws SQLException {
		ArrayList<HitterListVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player p, hitter h where p.teamCode = ? and p.playerId = h.playerId order by rate desc";
			ps = conn.prepareStatement(query);
			ps.setString(1, teamCode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				HitterListVO hitter = new HitterListVO();
				hitter.setPlayerId(rs.getInt(1));
				hitter.setTeamCode(rs.getString(2));
				hitter.setName(rs.getString(3));
				hitter.setPosition(rs.getString(4));
				hitter.setImage(rs.getString(5));
				hitter.setNumber(rs.getInt(6));
				hitter.setBirth(rs.getString(7));
				hitter.setType(rs.getString(8));
				hitter.setGames(rs.getInt(10));
				hitter.setRate(rs.getDouble(11));
				hitter.setAb(rs.getInt(12));
				hitter.setHits(rs.getInt(13));
				hitter.setHr(rs.getInt(14));
				hitter.setRbi(rs.getInt(15));
				hitter.setRuns(rs.getInt(16));
				hitter.setBb(rs.getInt(17));
				hitter.setSo(rs.getInt(18));
				hitter.setObp(rs.getDouble(19));
				hitter.setSlg(rs.getDouble(20));
				hitter.setOps(rs.getDouble(21));
				hitter.setSteal(rs.getInt(22));
				hitter.setError(rs.getInt(23));
				
				list.add(hitter);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	@Override
	public ArrayList<PitcherListVO> selectAllPitcher(String teamCode) throws SQLException {
		ArrayList<PitcherListVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from player p, pitcher c where p.teamCode = ? and p.playerId = c.playerId and c.inning is not null order by era";
			ps = conn.prepareStatement(query);
			ps.setString(1, teamCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				PitcherListVO pitcher = new PitcherListVO();
				pitcher.setPlayerId(rs.getInt(1));
				pitcher.setTeamCode(rs.getString(2));
				pitcher.setName(rs.getString(3));
				pitcher.setPosition(rs.getString(4));
				pitcher.setImage(rs.getString(5));
				pitcher.setNumber(rs.getInt(6));
				pitcher.setBirth(rs.getString(7));
				pitcher.setType(rs.getString(8));
				pitcher.setGames(rs.getInt(10));
				pitcher.setInning(rs.getString(11));
				pitcher.setEra(rs.getDouble(12));
				pitcher.setRate(rs.getDouble(13));
				pitcher.setWin(rs.getInt(14));
				pitcher.setLose(rs.getInt(15));
				pitcher.setSave(rs.getInt(16));
				pitcher.setHold(rs.getInt(17));
				pitcher.setRuns(rs.getInt(18));
				pitcher.setHr(rs.getInt(19));
				pitcher.setHits(rs.getInt(20));
				pitcher.setSo(rs.getInt(21));
				pitcher.setBb(rs.getInt(22));
				
				list.add(pitcher);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	/* ================= 회원 관리 ===================== */
	
	/* 로그인 */
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
	
	/* 회원 가입 */
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
			conn.commit();
			closeAll(ps, conn);
		}
	}
	
	/* 회원 정보 수정 */
	public void updateMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = getConnection();
			if(vo.getImage().equals("image/profile/default.png")) {
				//프로필 사진을 변경하지 않았을 경우 파일값이 null이 되고 에러가 남
				//따라서 UpdateMemberServlet에서 파일 없이 생성자를 달리하여 vo를 생성해줌.
				//이미지 없이 vo를 생성하면 MemberVO에서 기본적으로 image/profile/default.png 값이 입력됨.
				//프로필 사진을 기본 프로필 사진으로 바꾸지 않기 위해 넣어주는 if문
				query = "UPDATE members SET password=?, nickname=? WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getPassword());
				ps.setString(2, vo.getNickname());
				ps.setString(3, vo.getId());
			}else {
				query = "UPDATE members SET password=?, nickname=?, image=? WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getPassword());
				ps.setString(2, vo.getNickname());
				ps.setString(3, vo.getImage());
				ps.setString(4, vo.getId());
			}
			System.out.println(ps.executeUpdate()+"줄 수정");
		}finally {
			closeAll(rs, ps, conn);
		}
	}
	
	/* 회원 탈퇴(로그인된 상태에서 탈퇴가 가능하므로 id만 받음) */
	public void deleteMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "DELETE FROM members WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		}finally {
			closeAll(ps, conn);
		}
	}
	
	/* ID로 회원 찾기 */
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
	
	/* 닉네임으로 회원 찾기 */
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
	
	/* ================================================ */
	
	
	
	/* ================= 경기 관련 ===================== */
	
	/* 경기 업데이트 */
	@Override
	public void updateMatch(MatchVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "insert into matches values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getDate());
			ps.setString(2, vo.getTime());
			ps.setString(3, vo.getHome());
			ps.setString(4, vo.getAway());
			ps.setString(5, vo.getHomePitcher());
			ps.setString(6, vo.getAwayPitcher());
			ps.setString(7, vo.getPlace());
			ps.setString(8, vo.getHomeCode());
			ps.setString(9, vo.getAwayCode());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
		
	}
	
	/* 모든 경기 불러오기 */
	@Override
	public ArrayList<MatchVO> selectMatch() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<MatchVO> matchs = new ArrayList<MatchVO>();
		String query = "SELECT * FROM matches";
		
		ArrayList<PlayerVO> tmp = new ArrayList<PlayerVO>();
		double[] winningRate = null;
		PitcherVO awayPitcher = null;
		PitcherVO homePitcher = null;
		TeamVO awayTeam=null;
		TeamVO homeTeam=null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MatchVO match = new MatchVO();
				
				//set date, time, awayinfo, homeinfo, plce
				match.setDate(rs.getString("date"));
				match.setTime(rs.getString("time"));
				match.setAway(rs.getString("away"));
				match.setHome(rs.getString("home"));
				match.setAwayPitcher(rs.getString("awayPitcher"));
				match.setHomePitcher(rs.getString("homePitcher"));
				match.setPlace(rs.getString("place"));
				
				homeTeam = selectTeam(rs.getString("homeCode"));
				awayTeam = selectTeam(rs.getString("awayCode"));
				
				//get pitcher info
				tmp = selectPlayer(rs.getString("awayPitcher"));
				for(PlayerVO p: tmp) {
					if (awayTeam.getTeamCode().equals(p.getTeamCode())) awayPitcher = selectPitcher(p.getPlayerId());
				}
				
				tmp = selectPlayer(rs.getString("homePitcher"));
				for(PlayerVO p: tmp) {
					if (homeTeam.getTeamCode().equals(p.getTeamCode())) homePitcher = selectPitcher(p.getPlayerId());
				}
				
				//get winning ratio
				Logic logic = new Logic();
				logic.setTeam(awayTeam, homeTeam);
				logic.setPitcher(awayPitcher, homePitcher);
				winningRate = logic.execute();
				
				//set winningRatio, img, color
				match.setAwayRatio(winningRate[0]);
				match.setHomeRatio(winningRate[1]);
				match.setAwayImg(awayTeam.getImage());
				match.setHomeImg(homeTeam.getImage());
				match.setAwayColor(getColor(awayTeam.getTeamCode()));
				match.setHomeColor(getColor(homeTeam.getTeamCode()));
				
				//pitcher info
				match.setHomePitcherGames(homePitcher.getGames());
				match.setHomeWinLose(homePitcher.getWin()+"승 "+homePitcher.getLose()+"패");
				match.setHomeInning(homePitcher.getInning());
				match.setHomeERA(homePitcher.getEra());
				
				match.setAwayPitcherGames(awayPitcher.getGames());
				match.setAwayWinLose(awayPitcher.getWin()+"승 "+awayPitcher.getLose()+"패");
				match.setAwayInning(awayPitcher.getInning());
				match.setAwayERA(awayPitcher.getEra());
				
				matchs.add(match);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return matchs;
	}
	/* ================================================ */
	
	
	
	/* ================= 지도 상에 나타낼 토토판매점 ===================== */
	public void insertMap(MapVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "insert into map(address,name,locaX,locaY) values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getAddr());
			ps.setString(2, vo.getStoreName());
			ps.setString(3, vo.getLocalX());
			ps.setString(4, vo.getLocalY());
			
			System.out.println(ps.executeUpdate()+"줄 추가");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}
	
	/* ================================================ */
	
	@Override
	public ArrayList<MapVO> selectMap() throws SQLException {
		ArrayList<MapVO> mapList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select address, name, locaX, locaY from map";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				MapVO map = new MapVO();
						map.setAddr(rs.getString(1));
						map.setStoreName(rs.getString(2));
						map.setLocalX(rs.getString(3));
						map.setLocalY(rs.getString(4));
						
				mapList.add(map);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return mapList;
	}
	
	/* ================= 채팅 관련 ================= */
	
	/* 채팅 불러오기 */
	@Override
	public ArrayList<ChatVO> selectChat() throws SQLException {
		ArrayList<ChatVO> chatList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from chat";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				ChatVO chat = new ChatVO();
						chat.setId(rs.getString(2));
						chat.setWord(rs.getString(3));
						chat.setSendTime(rs.getString(4));
				chatList.add(chat);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return chatList;
	}
	
	/* 채팅 추가하기 */
	@Override
	public void insertChat(ChatVO vo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "INSERT INTO chat (id, word) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getWord());

			
			System.out.println(ps.executeUpdate()+"줄 추가");
			
		}finally {
			closeAll(ps, conn);
		}
		
		
	}

	/* ================================================ */
	
	
	
	/* ================= 모의 토토 및 결과 ================= */
	//
	
	//해당 날짜 경기 결과에 따른 포인트 업데이트
	public boolean updatePoint(String date) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/* 필요한 주요 변수 미리 선언 */
		String id = "";
		String game1 = "";
		String game2 = "";
		String game3 = "";
		String game4 = "";
		String game5 = "";
		int totalCount = 0;
		int currectCount = 0;
		int getPoint = 0;
		int stackPoint = 0;
		int point = 0;
		
		try {
			conn = getConnection();
			
			//이미 처리한 날짜면 false 리턴
			String query = "SELECT * FROM result WHERE date=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, date);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("winCheck")==1) {
					System.out.println("이미 처리한 날짜입니다.");
					return false;
				}
			}
			rs.close();
			ps.close();
			
			query = "SELECT * FROM (SELECT t.*, r.game1 result1, r.game2 result2, r.game3 result3, r.game4 result4, r.game5 result5, m.point FROM members m, toto t, result r WHERE m.id=t.id AND t.date=r.date) a WHERE date=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, date);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
				System.out.println("id : "+id);
				
				//회원이 뽑은 토토 (원정팀/홈팀/선택팀/정답여부)
				game1 = rs.getString("game1");
				game2 = rs.getString("game2");
				game3 = rs.getString("game3");
				game4 = rs.getString("game4");
				game5 = rs.getString("game5");
				System.out.println("game1~5 : "+game1+" "+game2+" "+game3+" "+game4+" "+game5);
				String[] game1Str = game1.split("/");
				String[] game2Str = game2.split("/");
				String[] game3Str = game3.split("/");
				String[] game4Str = game4.split("/");
				String[] game5Str = game5.split("/");
						
				//경기결과를 Stack에 하나씩 담음
				Stack<String> stack = new Stack<>();
				stack.push(rs.getString("result1"));
				stack.push(rs.getString("result2"));
				stack.push(rs.getString("result3"));
				stack.push(rs.getString("result4"));
				stack.push(rs.getString("result5"));
				
				//경기결과를 하나씩 뽑아가면서 모의토토 선택과 비교
				while(!stack.empty()) {
					String pop = stack.pop();
					System.out.println("스택 : "+pop);
					if(game1Str.length>1 && pop.equals(game1Str[2])) {
						currectCount++;
						game1 = game1Str[0]+"/"+game1Str[1]+"/"+game1Str[2]+"/true";
						System.out.println("현재 맞힌 개수 : "+currectCount);
						System.out.println("game1 : "+game1);
					}
					if(game2Str.length>1 && pop.equals(game2Str[2])) {
						currectCount++;
						game2 = game2Str[0]+"/"+game2Str[1]+"/"+game2Str[2]+"/true";
						System.out.println("현재 맞힌 개수 : "+currectCount);
						System.out.println("game2 : "+game2);
					}
					if(game3Str.length>1 && pop.equals(game3Str[2])) {
						currectCount++;
						game3 = game3Str[0]+"/"+game3Str[1]+"/"+game3Str[2]+"/true";
						System.out.println("현재 맞힌 개수 : "+currectCount);
						System.out.println("game3 : "+game3);
					}
					if(game4Str.length>1 && pop.equals(game4Str[2])) {
						currectCount++;
						game4 = game4Str[0]+"/"+game4Str[1]+"/"+game4Str[2]+"/true";
						System.out.println("현재 맞힌 개수 : "+currectCount);
						System.out.println("game4 : "+game4);
					}
					if(game5Str.length>1 && pop.equals(game5Str[2])) {
						currectCount++;
						game5 = game5Str[0]+"/"+game5Str[1]+"/"+game5Str[2]+"/true";
						System.out.println("현재 맞힌 개수 : "+currectCount);
						System.out.println("game5 : "+game5);
					}
				}//!stack.empty()
				
				//총 투표 갯수와 맞힌 갯수 비교
				totalCount = rs.getInt("totalCount");
				System.out.println("총 개수 : "+totalCount);
				if(totalCount == currectCount) {
					getPoint = (int) Math.pow(2, currectCount-1);//획득 포인트
					System.out.println("얻은 포인트 : "+getPoint);
				}
				point = rs.getInt("point") + getPoint;//총 포인트
				System.out.println("총 포인트 : "+point);
				stackPoint = point;//누적포인트
				System.out.println("누적 포인트 : "+stackPoint);
				
				//game1~5, 맞힌개수, 획득포인트, 누적포인트 업데이트
				query = "UPDATE toto SET game1=?, game2=?, game3=?, game4=?, game5=?, currectCount=?, getPoint=?, stackPoint=? Where id=? AND date=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, game1);
				ps.setString(2, game2);
				ps.setString(3, game3);
				ps.setString(4, game4);
				ps.setString(5, game5);
				ps.setInt(6, currectCount);
				ps.setInt(7, getPoint);
				ps.setInt(8, stackPoint);
				ps.setString(9, id);
				ps.setString(10, date);
				ps.executeUpdate();
			}//rs.next()
			
			//해당 날짜 check를 1로 변경
			query = "UPDATE result SET winCheck=? Where date=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, 1);
			ps.setString(2, date);
			ps.executeUpdate();
		}finally {
			closeAll(rs, ps, conn);
		}
		return true;
	}

	//이때까지의 토토 모두 가져오기 (조인한 걸로 수정....)
	public ArrayList<TotoVO> getAllToto(String id) throws SQLException{
		ArrayList<TotoVO> totoList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM toto WHERE id=? ORDER BY date DESC";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				totoList.add(new TotoVO(rs.getInt("no"),
						id,
						rs.getString("date"),
						rs.getString("game1"),
						rs.getString("game2"),
						rs.getString("game3"),
						rs.getString("game4"),
						rs.getString("game5"),
						rs.getInt("totalCount"),
						rs.getInt("currentCount"),
						rs.getInt("getPoint"),
						rs.getInt("stackPoint")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return totoList;
	}

	/* 모의 토토 중복 확인하기(이미 투표했을 경우 화면에 띄울 수 있도록 TotoVo로 반환) */
	public TotoVO checkToto(String id, String date) throws SQLException{
		TotoVO toto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM toto WHERE id=? AND date=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, date);
			rs = ps.executeQuery();
			if(rs.next()) {
				toto = new TotoVO(rs.getString("id"),
						rs.getString("date"),
						rs.getString("game1"),
						rs.getString("game2"),
						rs.getString("game3"),
						rs.getString("game4"),
						rs.getString("game5"),
						rs.getInt("totalCount"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return toto;
	}

	/* 모의 토토 선택 저장하기 */
	public void saveToto(TotoVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO toto (id, date, game1, game2, game3, game4, game5, totalCount) VALUES (?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getDate());
			ps.setString(3, vo.getGame1());
			ps.setString(4, vo.getGame2());
			ps.setString(5, vo.getGame3());
			ps.setString(6, vo.getGame4());
			ps.setString(7, vo.getGame5());
			ps.setInt(8, vo.getTotalCount());
			ps.executeUpdate();
		}finally {
			closeAll(ps, conn);
		}
	}

	/* 포인트 순으로 모의 토토 랭킹 Top5 멤버 가져오기 */
	public ArrayList<MemberVO> FindTop5MemberByPoint() throws SQLException{
		ArrayList<MemberVO> memberList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM members ORDER BY point DESC, nickName ASC LIMIT 5;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberVO(rs.getString("id"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getString("image"),
						rs.getInt("point")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return memberList;
	}
	
	
	/* ================================================ */
	
	
	
	/* ================= 팀별 색상 불러오기  =================  */
	public String getColor(String teamCode){
		
		String color = "";
		
		switch(teamCode) {
		case "OB":
			color = "#131230";
			break;
		case "KT":
			color =  "#000000";
			break;
		case "LG":
			color =  "#C30452";
			break;
		case "HT":
			color =  "#C70125";
			break;
		case "LT":
			color =  "#002955";
			break;
		case "WO":
			color =  "#820024";
			break;
		case "SK":
			color =  "#FF0000";
			break;
		case "SS":
			color =  "#074CA1";
			break;
		case "NC":
			color =  "#315288";
			break;
		case "HH":
			color =  "#FF6600";
			break;
			}
		return color;
	}
	@Override
	public void updateResult(ResultVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "insert into result values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getDate());
			ps.setString(2, vo.getGame1());
			ps.setString(3, vo.getGame2());
			ps.setString(4, vo.getGame3());
			ps.setString(5, vo.getGame4());
			ps.setString(6, vo.getGame5());
			ps.setInt(7, vo.getCheck());
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
	}
	

}
