package com.shobu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MemberVO;
import com.shobu.model.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id ="";
    	String password ="";
    	String nickname ="";
    	String fileName ="";
    	String originFileName ="";
    	String uploadPath = req.getRealPath("image");
    	System.out.println(uploadPath);
    	try {
    		MultipartRequest multi = new MultipartRequest(
    				req, 
    				uploadPath,
    				5*1024*1000,
    				"UTF-8",
    				new DefaultFileRenamePolicy());
    		id = multi.getParameter("id");
    		password = multi.getParameter("password");
    		nickname = multi.getParameter("nickname");
    		
    		fileName = multi.getFilesystemName("profile");
    		originFileName = multi.getOriginalFileName("profile");
    		if(originFileName==null) {
    			ModelDaoImpl.getInstance().register(new MemberVO(id,
    															password,
    															nickname));
    		}else {
    			ModelDaoImpl.getInstance().register(new MemberVO(id,
																password,
																nickname,
																"image/"+fileName));
    		}
    		PrintWriter out = res.getWriter();
			out.println("<html><head><script>alert('"+id+" 님, 로그인해주세요.');</script></head></html>");
    	}catch(Exception e) {
    		//e.printStackTrace();
    	}
    	return new ModelAndView("index.jsp");
	}
}
