package com.shobu.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MatchVO;
import com.shobu.model.ModelAndView;
import com.shobu.model.TeamVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		
		//teamvo, matchvo
		ArrayList<TeamVO> teams = null;
		ArrayList<MatchVO> matchs = null;
		ModelDaoImpl dao = ModelDaoImpl.getInstance();
		
		try {
			
			teams = dao.selectAllTeam();
			matchs = dao.selectMatch();
			req.setAttribute("teams", teams);
			req.setAttribute("matchs", matchs);
			System.out.println(teams);
			System.out.println(matchs);
			
		}catch (Exception e) {
			e.printStackTrace();
			//System.out.println("MainController Error*****");
		}
		
		return new ModelAndView("index.jsp", false);
	}

}
