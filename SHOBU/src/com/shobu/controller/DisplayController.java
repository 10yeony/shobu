package com.shobu.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ModelAndView;
import com.shobu.model.PlayerVO;

public class DisplayController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		int playerId = Integer.parseInt(req.getParameter("playerId"));
		ArrayList<PlayerVO> list = new ArrayList<>();
		PlayerVO player = new PlayerVO();
		try {
			player = ModelDaoImpl.getInstance().selectPlayer(playerId);
			PrintWriter out = res.getWriter();
			JSONObject json = new JSONObject();
			list.add(player);
			json.put("list", list);
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
