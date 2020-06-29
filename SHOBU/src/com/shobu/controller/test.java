package com.shobu.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

	public static void main(String[] args) {
		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
		int i = -1;
      	/*i = fileName.lastIndexOf("."); // 파일 확장자 위치
      	String realFileName = now + fileName.substring(i, fileName.length());  //현재시간과 확장자 합치기*/
		String saveFileName = now+"_"+"id@#567812";
		System.out.println(saveFileName);

	}

}
