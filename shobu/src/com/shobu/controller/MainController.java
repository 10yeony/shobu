package com.shobu.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

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
		
		//for Ajax
		JSONObject json = new JSONObject();
		
		
		try {
			PrintWriter out = res.getWriter();
			
			teams = dao.selectAllTeam();
			matchs = dao.selectMatch();
			json.put("teams", teams);
			json.put("matchs", matchs);
			
			out.print(json);
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("MainController Error*****");
		}
		
		return null;
	}

}
