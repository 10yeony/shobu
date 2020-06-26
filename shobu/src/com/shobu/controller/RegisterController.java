package com.shobu.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shobu.model.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = "";
		String password = "";
		String nickname = "";
		String systemProfile = "";
		String originProfile = "";
		String uploadPath = req.getRealPath("image/profile");
		try {
			MultipartRequest multi = new MultipartRequest(req, uploadPath, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			id = multi.getParameter("id");
			password = multi.getParameter("password");
			nickname = multi.getParameter("nickname");
			systemProfile = multi.getFilesystemName("profile");
			originProfile = multi.getOriginalFileName("profile");
			System.out.println(id);
			System.out.println(password);
			System.out.println(nickname);
			System.out.println(uploadPath);
			System.out.println(systemProfile);
			System.out.println(originProfile);
		} catch (IOException e) {
			System.out.println("IOException Occurs");
		}
		return null;
	}

}
