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

public class HitterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		
		String teamCode = req.getParameter("teamCode");
		System.out.println(teamCode);
		try {
			ArrayList<HitterListVO> list = new ArrayList<>();
			PrintWriter out = res.getWriter();
			JSONObject json = new JSONObject();
			
			if(teamCode.equals("ALL")) 
				list = ModelDaoImpl.getInstance().selectAllHitter();
			else
				list = ModelDaoImpl.getInstance().selectAllHitter(teamCode);
			
			json.put("list", list);
			
			out.print(json);
			
		} catch (Exception e) {
		}
		return null;
	}

}
