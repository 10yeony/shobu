package com.shobu.controller;

import java.sql.SQLException;

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
		System.out.println(id);
		String password = req.getParameter("password");
		System.out.println(password);
		try {
			boolean flag = ModelDaoImpl.getInstance().login(id, password);
			System.out.println(flag);
			if(flag==true) {
				MemberVO vo = ModelDaoImpl.getInstance().FindMemberById(id);
				System.out.println(vo.getId());
				req.getSession().setAttribute("vo", vo);
				mv = new ModelAndView("index.jsp");
			}else {
				mv = new ModelAndView("loginFail.html");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception Occurs");
		}
		return mv;
	}

}
