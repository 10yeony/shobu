package com.shobu.model;

public class TotoResultVO {
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
	private String result1;
	private String result2;
	private String result3;
	private String result4;
	private String result5;
	private int point;
	
	public TotoResultVO() {}
	/*public TotoResultVO(int no, String id, String date, String game1, String game2, String game3, String game4, String game5,
			int totalCount, int currectCount, int getPoint, int stackPoint, String result1, String result2, String result3, String result4, String result5, int point) {
		super(no, id, date, game1, game2, game3, game4, game5, totalCount, currectCount, getPoint, stackPoint);
		this.result1 = result1;
		this.result2 = result2;
		this.result3 = result3;
		this.result4 = result4;
		this.result5 = result5;
		this.point = point;
	}*/

	public String getResult1() {
		return result1;
	}
	public TotoResultVO(int no, String id, String date, String game1, String game2, String game3, String game4,
			String game5, int totalCount, int currectCount, int getPoint, int stackPoint, String result1,
			String result2, String result3, String result4, String result5, int point) {
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
		this.result1 = result1;
		this.result2 = result2;
		this.result3 = result3;
		this.result4 = result4;
		this.result5 = result5;
		this.point = point;
	}
	
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getResult3() {
		return result3;
	}
	public void setResult3(String result3) {
		this.result3 = result3;
	}
	public String getResult4() {
		return result4;
	}
	public void setResult4(String result4) {
		this.result4 = result4;
	}
	public String getResult5() {
		return result5;
	}
	public void setResult5(String result5) {
		this.result5 = result5;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "totoResult [no=" + no + ", id=" + id + ", date=" + date + ", game1=" + game1 + ", game2=" + game2
				+ ", game3=" + game3 + ", game4=" + game4 + ", game5=" + game5 + ", totalCount=" + totalCount
				+ ", currectCount=" + currectCount + ", getPoint=" + getPoint + ", stackPoint=" + stackPoint
				+ ", result1=" + result1 + ", result2=" + result2 + ", result3=" + result3 + ", result4=" + result4
				+ ", result5=" + result5 + ", point=" + point + "]";
	}
}
