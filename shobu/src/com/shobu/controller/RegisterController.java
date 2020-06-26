package com.shobu.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

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
		String id = "";
		String password = "";
		String nickname = "";
		String systemProfile = ""; // 중복 처리된 시스템 상의 파일 이름
		String originProfile = ""; // 실제 파일 이름
		String profileAddr = ""; //프로필 사진 주소
		
		/* getRealPath()로 하면 이클립스로 서버 켜고 끄면 저장된 파일 그때마다 날아감
		절대경로로 입력할 수도 있지만 팀원들 컴퓨터에서도 쓸 수 있도록 C 드라이브에 images 폴더 생성 */ 
		String path = "C:\\images"; //폴더 경로
		File folder = new File(path);

		//해당 디렉토리가 없을 경우 디렉토리 생성
		if (!folder.exists()) {
			try{
				folder.mkdir(); //폴더 생성합니다.
				System.out.println("C 드라이브에 images 폴더 생성 완료");
		    }catch(Exception e){
			    System.out.println("이미 존재하는 폴더입니다.");
		    }        
		}
		
		//파일 업로드
		String uploadPath = "C:/images/";
		try {
			MultipartRequest multi = new MultipartRequest(req, uploadPath, 5 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			id = multi.getParameter("id");
			password = multi.getParameter("password");
			nickname = multi.getParameter("nickname");
			systemProfile = multi.getFilesystemName("profile");
			originProfile = multi.getOriginalFileName("profile");
			profileAddr = uploadPath + systemProfile;
		} catch (IOException e) {
			System.out.println("IOException Occurs");
		}
			
		//DB에 회원 추가
		try {
			ModelDaoImpl dao = ModelDaoImpl.getInstance();
			if(originProfile==null) {
				dao.register(new MemberVO(id, password, nickname));
			}else {
				dao.register(new MemberVO(id, password, nickname, profileAddr));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception Occurs");
		}
		return new ModelAndView("index.jsp");
	}

}
