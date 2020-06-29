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
		System.out.println(id);
		String password = req.getParameter("password");
		System.out.println(password);
		try {
			boolean flag = ModelDaoImpl.getInstance().login(id, password);
			System.out.println(flag);
			if(flag==true) {
				MemberVO member = ModelDaoImpl.getInstance().FindMemberById(id);
				System.out.println(member.getId());
				req.getSession().setAttribute("member", member);
				mv = new ModelAndView("index.jsp");
			}else {
				PrintWriter out = res.getWriter();
				out.print("<html><head><script>alert(\"아이디 또는 비밀번호를 잘못 입력하셨습니다.\");</script></head></html>");
				req.getRequestDispatcher("login.html").include(req, res);
				return null;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ServletException e) {
			//e.printStackTrace();
		}
		return mv;
	}
}
