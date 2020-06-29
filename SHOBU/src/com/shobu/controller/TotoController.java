package com.shobu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MatchVO;
import com.shobu.model.MemberVO;
import com.shobu.model.ModelAndView;

public class TotoController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		/* 모의 토토 */
		ArrayList<MatchVO> matchs = null;
		/* 회원 랭킹(포인트별 Top 5) */
		try {
			matchs = ModelDaoImpl.getInstance().selectMatch();
			ArrayList<MemberVO> memberList = ModelDaoImpl.getInstance().FindTop5MemberByPoint();
			req.setAttribute("matchs", matchs);
			req.setAttribute("memberList", memberList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("toto.jsp");
	}

}
