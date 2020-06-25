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
	
	//����Ͻ�����
	
	//00. 12:00 ũ�Ѹ� �� DB������Ʈ
	void updatePlayer(PlayerVO vo) throws SQLException;
	void updateHitter(HitterVO vo, int playerId) throws SQLException;
	void updatePitcher(PitcherVO vo, int playerId) throws SQLException;
	void updateTeam(TeamVO vo) throws SQLException;
	
	//01. �� ����
	ArrayList<TeamVO> selectAllTeam() throws SQLException;
	TeamVO selectTeam(String teamCode) throws SQLException;
	
	//02. ���� �˻�
	ArrayList<PlayerVO> selectAllPlayer() throws SQLException;
	PlayerVO selectPlayer(int playerId) throws SQLException;
	PlayerVO selectPlayer(String name) throws SQLException;
	
	HitterVO selectHitter(int playerId) throws SQLException;
	ArrayList<HitterVO> selectAllHitter() throws SQLException;
	PitcherVO selectPitcher(int playerId) throws SQLException;
	ArrayList<PitcherVO> selectAllPitcher() throws SQLException;
	
	//03. ���� ���� �˻�
	ArrayList<PlayerVO> selectByTeamName(String teamCode) throws SQLException;
	
	//04. �α���
	boolean login(String id, String pass) throws SQLException;
	
	//05. ȸ������
	void register(MemberVO vo) throws SQLException;
	
	//06. �����ҷ�����
	ArrayList<MatchVO> selectMatch(String date) throws SQLException;
	
	//07. �Ǹ���
	ArrayList<MapVO> selectMap() throws SQLException;
	
	//08. ä��
	ArrayList<ChatVO> selectChat() throws SQLException;//ä�� ��������
	void insertChat(ChatVO vo) throws SQLException;
	
	//09. ������Ȯ��
	int resultToto(totoVO vo) throws SQLException;
	
	//10. ����Ʈ�߰�
	void updatePoint(String id, int point) throws SQLException; //���� ��÷
	
	
	///////////////////////////////2020-06-24///////////////////////////////////
	
	//11. 
	
	
	
}
