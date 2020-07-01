package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ModelAndView;
import com.shobu.model.TotoVO;

public class VoteTotoController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String date = req.getParameter("date");
		String game1 = req.getParameter("game1");
		String game2 = req.getParameter("game2");
		String game3 = req.getParameter("game3");
		String game4 = req.getParameter("game4");
		String game5 = req.getParameter("game5");
		int totalCount = Integer.parseInt(req.getParameter("totalCount"));
		TotoVO toto = null;
		
		ModelDaoImpl dao = ModelDaoImpl.getInstance();
		
		JSONObject json = new JSONObject();
		
		try {
			toto = dao.checkToto(id, date);
			if(toto==null) {//아직 토토에 참여하지 않았을 때
				toto = new TotoVO(id, date, game1, game2, game3, game4, game5, totalCount);
				dao.saveToto(toto);
			}
			PrintWriter out = res.getWriter();
			json.put("toto", toto);
			System.out.println(toto);
			out.print(toto);
			out.flush();
			out.close();
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} 
		return null;
	}

}
