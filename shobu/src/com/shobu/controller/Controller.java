package com.shobu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.model.ModelAndView;

public interface Controller {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res);
}
