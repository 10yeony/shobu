package com.shobu.config;

public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; 
	
	//집에서 단위 테스트 할 때 로컬 DB 서버 주소
	//String URL = "jdbc:mysql://localhost:3306/shobu?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	
	//학원에서 단위 테스트할 때 민호씨 DB 서버 주소
	String URL = "jdbc:mysql://192.168.0.76:3306/shobu?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	
	String USER = "root";
	String PASS = "1234";
}
