package com.shobu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.model.ModelAndView;

public class LogoutController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().invalidate();
		req.setAttribute("loginFlag", false);
		return new ModelAndView("frame.jsp");
	}

}
