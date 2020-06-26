package com.shobu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.controller.Controller;
import com.shobu.model.ModelAndView;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//hidden 값으로 들어온 요청 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String reqURI = req.getRequestURI();
		System.out.println("requestURI: "+reqURI);
		String contextPath = req.getContextPath();
		System.out.println("ContextPath: "+contextPath);
		String command = reqURI.substring(contextPath.length()+1);
		System.out.println("Command: " + command);
		
		Controller cmd = HandlerMapping.getInstance().createCmd(command);
		String path = "index.jsp";
		ModelAndView mv = null;
	
		try {
			mv = cmd.execute(req, res);
			path = mv.getPath();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("**** DispatcherServlet ERROR****");
		}
		if (mv !=null ) {
			if(!mv.isRedirect()) req.getRequestDispatcher(path).forward(req, res);
			else res.sendRedirect(path);
		}
	}

}


