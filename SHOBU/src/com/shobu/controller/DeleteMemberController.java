package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ModelAndView;

public class DeleteMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		try {
			PrintWriter out = res.getWriter();
			boolean flag = ModelDaoImpl.getInstance().deleteMember(id, password);
			if(!flag) {
				out.print(false);
			}else {
				out.print(true);
				req.getSession().invalidate();
				req.getRequestDispatcher("index.jsp").include(req, res);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ServletException e) {
			//e.printStackTrace();
		}
		return null;
	}

}
