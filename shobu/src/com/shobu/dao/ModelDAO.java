package com.shobu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shobu.model.ChatVO;
import com.shobu.model.HitterListVO;
import com.shobu.model.HitterVO;
import com.shobu.model.MapVO;
import com.shobu.model.MatchVO;
import com.shobu.model.MemberVO;
import com.shobu.model.Pitcher3VO;
import com.shobu.model.PitcherListVO;
import com.shobu.model.PitcherVO;
import com.shobu.model.PlayerVO;
import com.shobu.model.ResultVO;
import com.shobu.model.TeamInfoVO;
import com.shobu.model.TeamVO;

public interface ModelDAO {
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
		
	//00. DB Update at 12:00
	void updateResult(ResultVO vo) throws SQLException;
	void updatePlayer(PlayerVO vo) throws SQLException;
	void updateHitter(HitterVO vo, int playerId) throws SQLException;
	void updatePitcher(PitcherVO vo, int playerId) throws SQLException;
	void updateTeam(TeamVO vo) throws SQLException;
	void updateMatch(MatchVO vo) throws SQLException;
	void updatePitcher3(Pitcher3VO vo) throws SQLException;
	//01. Select Team
	ArrayList<TeamVO> selectAllTeam() throws SQLException;
	TeamVO selectTeam(String teamCode) throws SQLException;
	int selectTeamRankERA(String teamCode) throws SQLException;
	int selectTeamRankAVG(String teamCode) throws SQLException;
	
	PitcherListVO selectPlayerRankERA(String teamCode) throws SQLException;
	PitcherListVO selectPlayerRankWIN(String teamCode) throws SQLException;
	PitcherListVO selectPlayerRankSAVE(String teamCode) throws SQLException;
	PitcherListVO selectPlayerRankSO(String teamCode) throws SQLException;
	
	HitterListVO selectPlayerRankAVG(String teamCode) throws SQLException;
	HitterListVO selectPlayerRankRBI(String teamCode) throws SQLException;
	HitterListVO selectPlayerRankHR(String teamCode) throws SQLException;
	HitterListVO selectPlayerRankHITS(String teamCode) throws SQLException;
	
	//02. Select Player, Hitter, Pitcher
	ArrayList<PlayerVO> selectAllPlayer() throws SQLException;
	PlayerVO selectPlayer(int playerId) throws SQLException;
	ArrayList<PlayerVO> selectPlayer(String name) throws SQLException;
	
	HitterVO selectHitter(int playerId) throws SQLException;
	ArrayList<HitterListVO> selectAllHitter() throws SQLException;
	ArrayList<HitterListVO> selectAllHitter(String teamCode) throws SQLException;
	PitcherVO selectPitcher(int playerId) throws SQLException;
	ArrayList<PitcherListVO> selectAllPitcher() throws SQLException;
	ArrayList<PitcherListVO> selectAllPitcher(String teamCode) throws SQLException;
	
	
	//03. Select Player By Team Name
	ArrayList<PlayerVO> selectByTeamName(String teamCode) throws SQLException;
	
	//04. Login
	boolean login(String id, String pass) throws SQLException;
	
	//05. Register
	void register(MemberVO vo) throws SQLException;
	
	//06. Search Member
	MemberVO FindMemberById(String id) throws SQLException;
	MemberVO FindMemberByNickname(String nickname) throws SQLException;
	ArrayList<MemberVO> FindTop5MemberByPoint() throws SQLException;
	
	//06. Select Match by Date
	ArrayList<MatchVO> selectMatch() throws SQLException;
	
	//07.  Select Map
	ArrayList<MapVO> selectMap() throws SQLException;
	
	//08. Select Chat
	ArrayList<ChatVO> selectChat() throws SQLException;
	void insertChat(ChatVO vo) throws SQLException;
	
	//10. Update Point
	boolean updatePoint(String id) throws SQLException;
	
	
	///////////////////////////////2020-06-24///////////////////////////////////
	
	//11. 
	
	
	
}
