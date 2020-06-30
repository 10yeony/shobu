package com.shobu.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.ChatVO;

@ServerEndpoint(value = "/wschat")
public class WsChat{
  //notice:not thread-safe
  private static ArrayList<Session> sessionList = new ArrayList<Session>();
  @OnOpen
  public void onOpen(Session session){
    try{
      sessionList.add(session);

      //asynchronous communication
      
      
      // 작업
      ArrayList<ChatVO> chatList = new ArrayList<ChatVO>();
      chatList=ModelDaoImpl.getInstance().selectChat();
      

      ChatVO temp1;
     for(int i=0;i<chatList.size();i++) {
    	 	temp1=chatList.get(i);
//    	 	 session.getBasicRemote().sendText(temp1.getId());   
        	 session.getBasicRemote().sendText(temp1.getId()+" : "+temp1.getWord()+"("+temp1.getSendTime()+")");   		 
//    	 	 session.getBasicRemote().sendObject(temp1);   	
    	 	 
     }
      
      // 작업
      
//      session.getBasicRemote().sendText("님이 채팅에 참가하셨습니다.");
    }catch(Exception e){}
  }
  
  @OnClose
  public void onClose(Session session){
//  	System.out.println("종"+session.getId());
    sessionList.remove(session);
  }
  
  @OnMessage
  public void onMessage(String msg){
	  
	  String[]temp=msg.split(" ");	// temp[0]은 아이디  | temp[1]은 채팅 내
	  // 세션에 저장된 아이디 확인하는 로직 필요
	  
	  
	  System.out.println("회원명 : "+temp[0]);	// 확인용
	  System.out.println("메시지 : "+temp[1]);	// 확인용
	  
	  
	  
	try {
		ModelDaoImpl.getInstance().insertChat(new ChatVO(temp[0], temp[1]));
	} catch (SQLException e1) {
		System.out.println("오류발생");
	}
	  
	SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");

    try{
      for(Session session : sessionList){
    	  Date time = new Date();
    	  String time1= format.format(time);
    	  System.out.println(time1);
        //asynchronous communication
        session.getBasicRemote().sendText(temp[0]+" : "+temp[1]+"("+time1+")");
      }
    }catch(IOException e){}
  }
}





