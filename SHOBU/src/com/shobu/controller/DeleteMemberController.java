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
		try {
			PrintWriter out = res.getWriter();
			boolean flag = ModelDaoImpl.getInstance().login(id, password);
			if(!flag) {
				out.print("비밀번호가 틀렸습니다");
			}else {
				ModelDaoImpl.getInstance().deleteMember(id);
				out.print("정상적으로 탈퇴되었습니다");
				req.getSession().invalidate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
