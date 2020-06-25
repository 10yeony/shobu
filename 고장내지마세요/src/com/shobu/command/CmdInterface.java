package com.shobu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.model.ModelAndView;

public interface CmdInterface {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res);
}
