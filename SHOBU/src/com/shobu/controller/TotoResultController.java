package com.shobu.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ModelAndView;
import com.shobu.model.TotoResultVO;

public class TotoResultController implements Controller  {
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		ArrayList<TotoResultVO> totoResultList = new ArrayList<>();
		ModelDaoImpl dao = ModelDaoImpl.getInstance();
		JSONObject json = new JSONObject();
		try {
			totoResultList = dao.getAllToto(id);
			json.put("totoResultList", totoResultList);
			PrintWriter out = res.getWriter();
			out.print(totoResultList);
			System.out.println(totoResultList);
		} catch (Exception e) {
			System.out.println("GetLogic ERROR: " + e.getMessage());
			//e.printStackTrace();
		}
		return null;
	}
}
