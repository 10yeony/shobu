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
		try {
			ModelDaoImpl.getInstance().deleteMember(id);
			PrintWriter out = res.getWriter();
			out.print("<html><head><script>alert('성공적으로 탈퇴되었습니다');</script></head></html>");
			req.getSession().invalidate();
			req.getRequestDispatcher("index.jsp").include(req, res);
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (ServletException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return null;
	}

}
