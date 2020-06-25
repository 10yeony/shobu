package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crawling.PlayerUpdate;
import model.ModelDaoImpl;
import model.PitcherVO;
import model.PlayerVO;
import model.TeamVO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerUpdate pu = new PlayerUpdate();
		
		ArrayList<TeamVO> teamlist = pu.updateTeam();
		
		
		ArrayList<PlayerVO> doosanlist = pu.updateDOOSAN();
		ArrayList<PlayerVO> hanhwalist = pu.updateHANHWA();
		ArrayList<PlayerVO> kialist = pu.updateKIA();
		ArrayList<PlayerVO> kiwoomlist = pu.updateKIWOOM();
		ArrayList<PlayerVO> ktlist = pu.updateKT();
		ArrayList<PlayerVO> lglist = pu.updateLG();
		ArrayList<PlayerVO> lottelist = pu.updateLOTTE();
		ArrayList<PlayerVO> nclist = pu.updateNC();
		ArrayList<PlayerVO> samsunglist = pu.updateSAMSUNG();
		ArrayList<PlayerVO> sklist = pu.updateSK();
		
		
		try {
			for(int i = 0; i<teamlist.size(); i++) {
				ModelDaoImpl.getInstance().updateTeam(teamlist.get(i));
			}
			for(int i = 0; i<doosanlist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(doosanlist.get(i));
				if(doosanlist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(doosanlist.get(i).getPlayerId(), doosanlist.get(i).getTeamCode()), doosanlist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(doosanlist.get(i).getPlayerId(), doosanlist.get(i).getTeamCode()), doosanlist.get(i).getPlayerId());
			}
			for(int i = 0; i<hanhwalist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(hanhwalist.get(i));
				if(hanhwalist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(hanhwalist.get(i).getPlayerId(), hanhwalist.get(i).getTeamCode()), hanhwalist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(hanhwalist.get(i).getPlayerId(), hanhwalist.get(i).getTeamCode()), hanhwalist.get(i).getPlayerId());
			}
			for(int i = 0; i<sklist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(sklist.get(i));
				if(sklist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(sklist.get(i).getPlayerId(), sklist.get(i).getTeamCode()), sklist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(sklist.get(i).getPlayerId(), sklist.get(i).getTeamCode()), sklist.get(i).getPlayerId());
			}
			for(int i = 0; i<samsunglist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(samsunglist.get(i));
				if(samsunglist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(samsunglist.get(i).getPlayerId(), samsunglist.get(i).getTeamCode()), samsunglist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(samsunglist.get(i).getPlayerId(), samsunglist.get(i).getTeamCode()), samsunglist.get(i).getPlayerId());
			}
			for(int i = 0; i<nclist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(nclist.get(i));
				if(nclist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(nclist.get(i).getPlayerId(), nclist.get(i).getTeamCode()), nclist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(nclist.get(i).getPlayerId(), nclist.get(i).getTeamCode()), nclist.get(i).getPlayerId());
			}
			for(int i = 0; i<lottelist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(lottelist.get(i));
				if(lottelist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(lottelist.get(i).getPlayerId(), lottelist.get(i).getTeamCode()), lottelist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(lottelist.get(i).getPlayerId(), lottelist.get(i).getTeamCode()), lottelist.get(i).getPlayerId());
			}
			for(int i = 0; i<lglist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(lglist.get(i));
				if(lglist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(lglist.get(i).getPlayerId(), lglist.get(i).getTeamCode()), lglist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(lglist.get(i).getPlayerId(), lglist.get(i).getTeamCode()), lglist.get(i).getPlayerId());
			}
			for(int i = 0; i<ktlist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(ktlist.get(i));
				if(ktlist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(ktlist.get(i).getPlayerId(), ktlist.get(i).getTeamCode()), ktlist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(ktlist.get(i).getPlayerId(), ktlist.get(i).getTeamCode()), ktlist.get(i).getPlayerId());
			}
			for(int i = 0; i<kiwoomlist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(kiwoomlist.get(i));
				if(kiwoomlist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(kiwoomlist.get(i).getPlayerId(), kiwoomlist.get(i).getTeamCode()), kiwoomlist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(kiwoomlist.get(i).getPlayerId(), kiwoomlist.get(i).getTeamCode()), kiwoomlist.get(i).getPlayerId());
			}
			for(int i = 0; i<kialist.size(); i++){
				ModelDaoImpl.getInstance().updatePlayer(kialist.get(i));
				if(kialist.get(i).getPosition().equals("투수"))
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(kialist.get(i).getPlayerId(), kialist.get(i).getTeamCode()), kialist.get(i).getPlayerId());
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(kialist.get(i).getPlayerId(), kialist.get(i).getTeamCode()), kialist.get(i).getPlayerId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
	}


