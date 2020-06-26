package com.shobu.model;

public class Pitcher3VO {
	private int playerId;
	private String day1;
	private String day2;
	private String day3;
	public Pitcher3VO() {}
	public Pitcher3VO(int playerId, String day1, String day2, String day3) {
		super();
		this.playerId = playerId;
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getDay3() {
		return day3;
	}
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	@Override
	public String toString() {
		return "Pitcher3VO [playerId=" + playerId + ", day1=" + day1 + ", day2=" + day2 + ", day3=" + day3 + "]";
	}
	
	
}
