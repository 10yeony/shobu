package com.shobu.model;

public class PlayerVO {
	private int playerId;
	private String teamCode;
	private String name;
	private String position;
	private String image;
	private int number;
	private String birth;
	private String type;
	
	public PlayerVO() {}
	
	public PlayerVO(int playerId, String teamCode, String name, String position, String image, int number, String birth,
			String type) {
		super();
		this.playerId = playerId;
		this.teamCode = teamCode;
		this.name = name;
		this.position = position;
		this.image = image;
		this.number = number;
		this.birth = birth;
		this.type = type;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PlayerVO [playerId=" + playerId + ", teamCode=" + teamCode + ", name=" + name + ", position=" + position
				+ ", image=" + image + ", number=" + number + ", birth=" + birth + ", type=" + type + "]";
	}
	
	

	
}
