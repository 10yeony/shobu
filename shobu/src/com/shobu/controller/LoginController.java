package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MemberVO;
import com.shobu.model.ModelAndView;

public class LoginController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = null;
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		try {
			boolean flag = ModelDaoImpl.getInstance().login(id, password);
			if(flag==true) {
				MemberVO member = ModelDaoImpl.getInstance().FindMemberById(id);
				System.out.println(member.getId());
				req.getSession().setAttribute("member", member);
				mv = new ModelAndView("index.jsp");
			}else {
				mv = new ModelAndView("loginFail.jsp");
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		} 
		return mv;
	}
}
