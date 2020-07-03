package com.shobu.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.crawling.PlayerUpdate;
import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MatchVO;
import com.shobu.model.ModelAndView;
import com.shobu.model.PlayerVO;
import com.shobu.model.ResultVO;
import com.shobu.model.TeamVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = null;
		String path ="index.jsp";
		PlayerUpdate pu = new PlayerUpdate();
		
		try {
			ArrayList<TeamVO> teamlist = pu.updateTeam();
			for(int i = 0; i<teamlist.size(); i++) {
				ModelDaoImpl.getInstance().updateTeam(teamlist.get(i));
			}
			
			ArrayList<PlayerVO> doosanlist = pu.updateDOOSAN();
			for(int i = 0; i<doosanlist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(doosanlist.get(i));
			ArrayList<PlayerVO> hanhwalist = pu.updateHANHWA();
			for(int i = 0; i<hanhwalist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(hanhwalist.get(i));
			ArrayList<PlayerVO> samsunglist = pu.updateSAMSUNG();
			for(int i = 0; i<samsunglist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(samsunglist.get(i));
			ArrayList<PlayerVO> lglist = pu.updateLG();
			for(int i = 0; i<lglist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(lglist.get(i));
			ArrayList<PlayerVO> ktlist = pu.updateKT();
			for(int i = 0; i<ktlist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(ktlist.get(i));
			ArrayList<PlayerVO> sklist = pu.updateSK();
			for(int i = 0; i<sklist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(sklist.get(i));
			ArrayList<PlayerVO> lottelist = pu.updateLOTTE();
			for(int i = 0; i<lottelist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(lottelist.get(i));
			ArrayList<PlayerVO> nclist = pu.updateNC();
			for(int i = 0; i<nclist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(nclist.get(i));
			ArrayList<PlayerVO> kiwoomlist = pu.updateKIWOOM();
			for(int i = 0; i<kiwoomlist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(kiwoomlist.get(i));
			ArrayList<PlayerVO> kialist = pu.updateKIA();
			for(int i = 0; i<kialist.size(); i++)
				ModelDaoImpl.getInstance().updatePlayer(kialist.get(i));
			
			ArrayList<PlayerVO> playerlist = ModelDaoImpl.getInstance().selectAllPlayer();
			for(int i = 0; i<playerlist.size(); i++) {
				if(playerlist.get(i).getPosition().equals("투수")) {
					ModelDaoImpl.getInstance().updatePitcher(pu.updatePitcher(playerlist.get(i).getPlayerId(), playerlist.get(i).getTeamCode()), playerlist.get(i).getPlayerId());
					ModelDaoImpl.getInstance().updatePitcher3(pu.updatePitcher3(playerlist.get(i).getPlayerId()));
				}
				else
					ModelDaoImpl.getInstance().updateHitter(pu.updateHitter(playerlist.get(i).getPlayerId(), playerlist.get(i).getTeamCode()), playerlist.get(i).getPlayerId());
			}
			
			Date TD = new Date(); // 오늘날짜
			Date YD = new Date(); // 어제날짜
			YD.setTime(TD.getTime() - ((long)1000*60*60*24));
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(date.format(YD));
			System.out.println(date.format(TD));
			
			//오늘경기 DB업데이트
			ArrayList<MatchVO> matches = pu.updateMatch(date.format(TD));
			for(int i = 0; i<matches.size(); i++) {
				ModelDaoImpl.getInstance().updateMatch(matches.get(i));
			}
			
			ResultVO result = pu.updateResult(date.format(YD));//어제경기결과
			ModelDaoImpl.getInstance().updateResult(result);//어제경기결과 DB업데이트
			ModelDaoImpl.getInstance().updatePoint(date.format(YD));//포인트적립
			
			mv = new ModelAndView(path);
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
	}
		return mv;
	}

}
