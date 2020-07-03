package com.shobu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MapVO;
import com.shobu.model.ModelAndView;

public class MapController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = null;
		
		ArrayList<MapVO> mapList = new ArrayList<>();
		
		try {
			
				mapList=ModelDaoImpl.getInstance().selectMap();
				
				System.out.println(mapList.get(0));
				System.out.println("mapList 가져옴");
				System.out.println(mapList.size());
				req.setAttribute("mapList", mapList);
				mv= new ModelAndView("map.jsp");
				
				return mv;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
