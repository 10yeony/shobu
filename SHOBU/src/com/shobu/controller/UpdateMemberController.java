package com.shobu.controller;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MemberVO;
import com.shobu.model.ModelAndView;

public class UpdateMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id ="";
    	String password ="";
    	String nickname ="";
    	String fileName ="";
    	String originFileName ="";
    	String uploadPath = req.getRealPath("image/profile");
    	System.out.println(uploadPath);
    	try {
    		MultipartRequest multi = new MultipartRequest(req, 
    													uploadPath,
    													5*1024*1000,
    													"UTF-8",
    													new DefaultFileRenamePolicy());
    		id = multi.getParameter("id");
    		password = multi.getParameter("passwordCheck");
    		nickname = multi.getParameter("nickname");
    		fileName = nullOrEmptyToReplaceString(multi.getFilesystemName("profile"), "");
    		System.out.println(multi.getFilesystemName("profile"));
    		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")); //현재 시간
    		int i = -1;
          	i = fileName.lastIndexOf("."); // 파일 확장자 위치
          	String saveFileName = now + "_"+ id + fileName.substring(i, fileName.length());  //현재시간과 확장자 합치기
          	System.out.println(saveFileName);
          	File oldFile = new File(uploadPath, fileName); //예전 파일
    		File newFile = new File(uploadPath, saveFileName); //현재 파일
   
    		oldFile.renameTo(newFile); // 파일명 변경
    		
    		originFileName = multi.getOriginalFileName("profile");
    		if(originFileName==null) {
    			ModelDaoImpl.getInstance().updateMember(new MemberVO(id,
    															password,
    															nickname));
    		}else {
    			ModelDaoImpl.getInstance().updateMember(new MemberVO(id,
																password,
																nickname,
																"image/profile/"+saveFileName));
    		}
    		MemberVO member = ModelDaoImpl.getInstance().FindMemberById(id);
    		PrintWriter out = res.getWriter();
    		out.print(true);
    		req.getSession().setAttribute("member", member);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public static String nullOrEmptyToReplaceString(String str, String replaceStr) {
		if (str == null || "".equals(str)) {
			return replaceStr;
		}
		return str;
	}
}
