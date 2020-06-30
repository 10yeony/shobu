package com.shobu.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.HitterListVO;
import com.shobu.model.ModelAndView;
import com.shobu.model.PitcherListVO;

public class PitcherController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		
		String teamCode = req.getParameter("teamCode");
		System.out.println(teamCode);
		try {
			ArrayList<PitcherListVO> list = new ArrayList<>();
			PrintWriter out = res.getWriter();
			JSONObject json = new JSONObject();
			
			if(teamCode.equals("ALL")) 
				list = ModelDaoImpl.getInstance().selectAllPitcher();
			else
				list = ModelDaoImpl.getInstance().selectAllPitcher(teamCode);
			
			json.put("list", list);
			
			out.print(json);
		} catch (Exception e) {
		}
		
		return null;
	}

}
