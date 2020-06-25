package com.shobu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.command.CmdInterface;
import com.shobu.command.InsertCmd;
import com.shobu.model.ModelAndView;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		CmdInterface cmd = null;

		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String uri = requestURI.substring(contextPath.length());

		switch (uri) {
		case "insert.do":
			cmd = new InsertCmd();
			break;
		}
		
		ModelAndView mv= cmd.execute(req, res);
		if (mv.isRedirect() == false) req.getRequestDispatcher(mv.getPath()).forward(req, res);
		else res.sendRedirect(mv.getPath());
	}
}
