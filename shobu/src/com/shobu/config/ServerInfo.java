package com.shobu.config;

public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; 
	String URL = "jdbc:mysql://127.0.0.1:3306/shobu?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	//String URL = "jdbc:mysql://192.168.0.84:3306/shobu?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASS = "1234";
}
