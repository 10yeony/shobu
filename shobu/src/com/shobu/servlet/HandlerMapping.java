package com.shobu.servlet;

import com.shobu.controller.Controller;
import com.shobu.controller.DeleteMemberController;
import com.shobu.controller.IdCheckController;
import com.shobu.controller.DisplayController;
import com.shobu.controller.HitterController;
import com.shobu.controller.LoginController;
import com.shobu.controller.LogoutController;
import com.shobu.controller.MainController;
import com.shobu.controller.MapController;
import com.shobu.controller.NicknameCheckController;
import com.shobu.controller.Playerlist;
import com.shobu.controller.PitcherController;
import com.shobu.controller.RegisterController;
import com.shobu.controller.TeamInfoController;
import com.shobu.controller.TotoController;
import com.shobu.controller.UpdateController;
import com.shobu.controller.UpdateMemberController;
import com.shobu.controller.VoteTotoController;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createCmd(String command) {
		Controller controller = null;
		
		if(command.equals("main.do")) {
			controller = new MainController();
			System.out.println("MainController 생성됨");
		}
		else if(command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController 생성됨");	
		}
		else if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 생성됨");	
		}
		else if(command.equals("register.do")){
			controller = new RegisterController();
			System.out.println("RegisterController 생성됨");	
		}
		else if(command.equals("idCheck.do")){
			controller = new IdCheckController();
			System.out.println("IdCheckController 생성됨");	
		}
		else if(command.equals("nicknameCheck.do")){
			controller = new NicknameCheckController();
			System.out.println("NicknameCheckController 생성됨");	
		}
		else if(command.equals("updateMember.do")) {
			controller = new UpdateMemberController();
			System.out.println("UpdateMemberController 생성됨");	
		}
		else if(command.equals("deleteMember.do")) {
			controller = new DeleteMemberController();
			System.out.println("DeleteMemberController 생성됨");	
			
		}
		else if(command.equals("toto.do")) {
			controller = new TotoController();
			System.out.println("TotoController 생성됨");	
		}
		else if(command.equals("voteToto.do")) {
			controller = new VoteTotoController();
			System.out.println("VoteTotoController 생성됨");
		}
		else if(command.equals("update.do")){
			controller = new UpdateController();
			System.out.println("UpdateController 생성됨");	
		}
		else if(command.equals("pitcher.do")) {
			controller = new PitcherController();
			System.out.println("Pitcher 생성됨");
		}
		else if(command.equals("hitter.do")) {
			controller = new HitterController();
			System.out.println("Hitter 생성됨");
		}
		else if(command.equals("display.do")) {
			controller = new DisplayController();
			System.out.println("Display 생성됨");
		}
		else if(command.equals("teaminfo.do")) {
			controller = new TeamInfoController();
			System.out.println("TeamInfo 생성됨");
		}
		else if(command.equals("mapList.do")) {
			controller = new MapController();
			System.out.println("TeamInfo 생성됨");
		}
		
		return controller;
	}

}