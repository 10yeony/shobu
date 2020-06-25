package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelDAO {
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//비즈니스로직
	
	//00. 12:00 크롤링 후 DB업데이트
	void updatePlayer(PlayerVO vo) throws SQLException;
	void updateHitter(HitterVO vo, int playerId) throws SQLException;
	void updatePitcher(PitcherVO vo, int playerId) throws SQLException;
	void updateTeam(TeamVO vo) throws SQLException;
	
	//01. 팀 정보
	ArrayList<TeamVO> selectAllTeam() throws SQLException;
	TeamVO selectTeam(String teamCode) throws SQLException;
	
	//02. 선수 검색
	ArrayList<PlayerVO> selectAllPlayer() throws SQLException;
	PlayerVO selectPlayer(int playerId) throws SQLException;
	PlayerVO selectPlayer(String name) throws SQLException;
	
	HitterVO selectHitter(int playerId) throws SQLException;
	ArrayList<HitterVO> selectAllHitter() throws SQLException;
	PitcherVO selectPitcher(int playerId) throws SQLException;
	ArrayList<PitcherVO> selectAllPitcher() throws SQLException;
	
	//03. 팀별 선수 검색
	ArrayList<PlayerVO> selectByTeamName(String teamCode) throws SQLException;
	
	//04. 로그인
	boolean login(String id, String pass) throws SQLException;
	
	//05. 회원가입
	void register(MemberVO vo) throws SQLException;
	
	//06. 일정불러오기
	ArrayList<MatchVO> selectMatch(String date) throws SQLException;
	
	//07. 판매점
	ArrayList<MapVO> selectMap() throws SQLException;
	
	//08. 채팅
	ArrayList<ChatVO> selectChat() throws SQLException;//채팅 가져오기
	void insertChat(ChatVO vo) throws SQLException;
	
	//09. 토토결과확인
	int resultToto(totoVO vo) throws SQLException;
	
	//10. 포인트추가
	void updatePoint(String id, int point) throws SQLException; //토토 당첨
	
	
	///////////////////////////////2020-06-24///////////////////////////////////
	
	//11. 
	
	
	
}
