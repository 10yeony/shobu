package com.shobu.dao;

import java.util.Stack;

public class test {

	public static void main(String[] args) {
		String game1 = "삼성/SK/삼성";
		String[] temp = game1.split("/");
		System.out.println(temp[0]+" "+temp[1]+ " "+temp[2]);
		
		String a1 = "삼성";
		String a2 = "LG";
		String a3 = "두산";
		String a4 = "키움";
		String a5 = "KT";
		
		Stack<String> stack = new Stack<>();
		stack.push(a1);
		stack.push(a2);
		stack.push(a3);
		stack.push(a4);
		stack.push(a5);
		
		String[] s = {"삼성", "LG", "삼성"};
		
		while(!stack.empty()) {
			
		}
	}

}
