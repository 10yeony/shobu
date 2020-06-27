package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MemberVO;
import com.shobu.model.ModelAndView;

public class NicknameCheckController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter out = res.getWriter();
			String nickname = req.getParameter("nickname");
			MemberVO vo = ModelDaoImpl.getInstance().FindMemberByNickname(nickname);
			if(nickname.equals(vo.getNickname())) {
				out.print(true);
			}else {
				out.print(false);
			}
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
