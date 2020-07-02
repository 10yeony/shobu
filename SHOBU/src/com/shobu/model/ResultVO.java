package com.shobu.model;

public class ResultVO {
	private String date;
	private String game1;
	private String game2;
	private String game3;
	private String game4;
	private String game5;
	private int check;
	
	public ResultVO() {}

	public ResultVO(String date, String game1, String game2, String game3, String game4, String game5, int check) {
		super();
		this.date = date;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.game4 = game4;
		this.game5 = game5;
		this.check = check;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGame1() {
		return game1;
	}

	public void setGame1(String game1) {
		this.game1 = game1;
	}

	public String getGame2() {
		return game2;
	}

	public void setGame2(String game2) {
		this.game2 = game2;
	}

	public String getGame3() {
		return game3;
	}

	public void setGame3(String game3) {
		this.game3 = game3;
	}

	public String getGame4() {
		return game4;
	}

	public void setGame4(String game4) {
		this.game4 = game4;
	}

	public String getGame5() {
		return game5;
	}

	public void setGame5(String game5) {
		this.game5 = game5;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "ResultVO [date=" + date + ", game1=" + game1 + ", game2=" + game2 + ", game3=" + game3 + ", game4="
				+ game4 + ", game5=" + game5 + ", check=" + check + "]";
	}
	
}
