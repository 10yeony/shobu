package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ModelAndView;

public class PasswordCheckController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		try {
			PrintWriter out = res.getWriter();
			boolean flag = ModelDaoImpl.getInstance().login(id, password);
			if(!flag) {
				out.print(false);
			}else {
				out.print(true);
			}
			req.getRequestDispatcher("index.jsp").include(req, res);
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
