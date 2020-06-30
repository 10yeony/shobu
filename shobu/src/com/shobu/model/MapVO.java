package com.shobu.model;

public class MapVO {

	private String addr;
	private String storeName;
	private String localX;
	private String localY;
	public MapVO(String addr, String storeName, String localX, String localY) {
		super();
		this.addr = addr;
		this.storeName = storeName;
		this.localX = localX;
		this.localY = localY;
	}
	
	public MapVO() {}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocalX() {
		return localX;
	}

	public void setLocalX(String localX) {
		this.localX = localX;
	}

	public String getLocalY() {
		return localY;
	}

	public void setLocalY(String localY) {
		this.localY = localY;
	}

	@Override
	public String toString() {
		return "MapVO [addr=" + addr + ", storeName=" + storeName + ", localX=" + localX + ", localY=" + localY + "]";
	}
	
	
}
