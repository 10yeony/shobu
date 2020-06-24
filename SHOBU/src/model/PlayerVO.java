package model;

public class PlayerVO {
	private int playerId;
	private String teamName;
	private String name;
	private String position;
	private String image;
	
	public PlayerVO() {}
	
	public PlayerVO(int playerId, String teamName, String name, String position, String image) {
		super();
		this.playerId = playerId;
		this.teamName = teamName;
		this.name = name;
		this.position = position;
		this.image = image;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	@Override
	public String toString() {
		return "PlayerVO [playerId=" + playerId + ", teamName=" + teamName + ", name=" + name + ", position=" + position
				+ ", image=" + image + "]";
	}
	
	
	
	
}
