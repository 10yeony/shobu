package com.shobu.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.controller.Controller;
import com.shobu.model.ModelAndView;

public class LogoutController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().invalidate();
		req.setAttribute("loginFlag", false);
		return new ModelAndView("index.jsp");
	}

}
