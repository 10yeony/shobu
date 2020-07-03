package com.shobu.model;

public class TotoVO2 {
	private int no;
	private String id;
	private String date;
	private String game1;
	private String game2;
	private String game3;
	private String game4;
	private String game5;
	private int totalCount;
	private int currectCount;
	private int getPoint;
	private int stackPoint;
	
	public TotoVO2() {}
	public TotoVO2(String id, String date, String game1, String game2, String game3, String game4, String game5, int totalCount) {
		super();
		this.id = id;
		this.date = date;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.game4 = game4;
		this.game5 = game5;
		this.totalCount = totalCount;
	}
	public TotoVO2(int no, String id, String date, String game1, String game2, String game3, String game4, String game5,
			int totalCount, int currectCount, int getPoint, int stackPoint) {
		super();
		this.no = no;
		this.id = id;
		this.date = date;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.game4 = game4;
		this.game5 = game5;
		this.totalCount = totalCount;
		this.currectCount = currectCount;
		this.getPoint = getPoint;
		this.stackPoint = stackPoint;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrectCount() {
		return currectCount;
	}
	public void setCurrectCount(int currectCount) {
		this.currectCount = currectCount;
	}
	public int getGetPoint() {
		return getPoint;
	}
	public void setGetPoint(int getPoint) {
		this.getPoint = getPoint;
	}
	public int getStackPoint() {
		return stackPoint;
	}
	public void setStackPoint(int stackPoint) {
		this.stackPoint = stackPoint;
	}
	
	@Override
	public String toString() {
		return "TotoVO [no=" + no + ", id=" + id + ", date=" + date + ", game1=" + game1 + ", game2=" + game2
				+ ", game3=" + game3 + ", game4=" + game4 + ", game5=" + game5 + ", totalCount=" + totalCount
				+ ", currectCount=" + currectCount + ", getPoint=" + getPoint + ", stackPoint=" + stackPoint + "]";
	}
}
