package com.shobu.model;

public class ChatVO {
	
	private String id;
	private String word;
	private String sendTime;
	
	public ChatVO() {}

	public ChatVO(String id, String word, String sendTime) {
		super();
		this.id = id;
		this.word = word;
		this.sendTime = sendTime;
	}
	public ChatVO(String id, String word) {
		this.id = id;
		this.word = word;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "ChatVO [id=" + id + ", word=" + word + ", sendTime=" + sendTime + "]";
	}
	
	
}
