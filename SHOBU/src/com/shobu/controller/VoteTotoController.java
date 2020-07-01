package com.shobu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ModelDaoImpl dao = ModelDaoImpl.getInstance();
		try {
			TotoVO toto = dao.checkToto(id, date);
			if(toto==null) {
				toto = new TotoVO(id, date, game1, game2, game3, game4, game5, totalCount);
				dao.voteToto(toto);
			}
			req.getSession().setAttribute("toto", toto);
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return new ModelAndView("toto.jsp");
	}

}
