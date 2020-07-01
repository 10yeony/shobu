package com.shobu.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.HitterListVO;
import com.shobu.model.ModelAndView;
import com.shobu.model.PitcherListVO;
import com.shobu.model.TeamInfoVO;

public class TeamInfoController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String teamCode = req.getParameter("teamCode");
		TeamInfoVO teaminfo = new TeamInfoVO();
		PitcherListVO pitcher_ERA = new PitcherListVO();
		PitcherListVO pitcher_WIN = new PitcherListVO();
		PitcherListVO pitcher_SAVE = new PitcherListVO();
		PitcherListVO pitcher_SO = new PitcherListVO();
		HitterListVO hitter_RATE = new HitterListVO();
		HitterListVO hitter_RBI = new HitterListVO();
		HitterListVO hitter_HR = new HitterListVO();
		HitterListVO hitter_HITS = new HitterListVO();
		
		try {
			ArrayList<TeamInfoVO> teamlist = new ArrayList<>();
			ArrayList<HitterListVO> hitterlist = new ArrayList<>();
			ArrayList<PitcherListVO> pitcherlist = new ArrayList<>();
			
			PrintWriter out = res.getWriter();
			JSONObject json = new JSONObject();
			
			teaminfo.setTeamCode(teamCode);
			teaminfo.setImage(ModelDaoImpl.getInstance().selectTeam(teamCode).getImage());
			teaminfo.setRank(ModelDaoImpl.getInstance().selectTeam(teamCode).getRanking());
			teaminfo.setRankAVG(ModelDaoImpl.getInstance().selectTeamRankAVG(teamCode));
			teaminfo.setRankERA(ModelDaoImpl.getInstance().selectTeamRankERA(teamCode));
			teamlist.add(teaminfo);
			System.out.println(teaminfo.getImage()+teaminfo.getRank());
			
			pitcher_ERA = ModelDaoImpl.getInstance().selectPlayerRankERA(teamCode);
			pitcher_WIN = ModelDaoImpl.getInstance().selectPlayerRankWIN(teamCode);
			pitcher_SAVE = ModelDaoImpl.getInstance().selectPlayerRankSAVE(teamCode);
			pitcher_SO = ModelDaoImpl.getInstance().selectPlayerRankSO(teamCode);
			pitcherlist.add(pitcher_ERA);
			pitcherlist.add(pitcher_WIN);
			pitcherlist.add(pitcher_SAVE);
			pitcherlist.add(pitcher_SO);
			
			hitter_RATE = ModelDaoImpl.getInstance().selectPlayerRankAVG(teamCode);
			hitter_RBI = ModelDaoImpl.getInstance().selectPlayerRankRBI(teamCode);
			hitter_HR = ModelDaoImpl.getInstance().selectPlayerRankHR(teamCode);
			hitter_HITS = ModelDaoImpl.getInstance().selectPlayerRankHITS(teamCode);
			hitterlist.add(hitter_RATE);
			hitterlist.add(hitter_RBI);
			hitterlist.add(hitter_HR);
			hitterlist.add(hitter_HITS);
			
			json.put("teamlist", teamlist);
			json.put("pitcherlist", pitcherlist);
			json.put("hitterlist", hitterlist);
			
			out.print(json);
			
		} catch (Exception e) {
		}
		return null;
	}

}
