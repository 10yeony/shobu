package com.shobu.model;

public class TotoVO {
	private String id;
	private String date;
	private String game1;
	private String game2;
	private String game3;
	private String game4;
	private String game5;
	
	public TotoVO() {}
	public TotoVO(String id, String date, String game1, String game2, String game3, String game4, String game5) {
		super();
		this.id = id;
		this.date = date;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.game4 = game4;
		this.game5 = game5;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "totoVO [id=" + id + ", date=" + date + ", game1=" + game1 + ", game2=" + game2 + ", game3=" + game3
				+ ", game4=" + game4 + ", game5=" + game5 + "]";
	}
}
