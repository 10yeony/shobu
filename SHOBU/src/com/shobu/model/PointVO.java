package com.shobu.model;

public class PointVO {
	private String id;
	private String date;
	private int totalCount;
	private int currentCount;
	private int get;
	private int stack;
	
	public PointVO() {}
	public PointVO(String id, String date, int totalCount, int currentCount, int get, int stack) {
		super();
		this.id = id;
		this.date = date;
		this.totalCount = totalCount;
		this.currentCount = currentCount;
		this.get = get;
		this.stack = stack;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getGet() {
		return get;
	}
	public void setGet(int get) {
		this.get = get;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
	
	@Override
	public String toString() {
		return "PointVO [id=" + id + ", date=" + date + ", totalCount=" + totalCount + ", currentCount=" + currentCount
				+ ", get=" + get + ", stack=" + stack + "]";
	}
}
