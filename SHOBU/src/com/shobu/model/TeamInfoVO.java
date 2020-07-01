package com.shobu.model;

public class TeamInfoVO {
	private String teamCode;
	private String image;
	private int rank;
	private int rankERA;
	private int rankAVG;
	
	public TeamInfoVO() {}
	
	public TeamInfoVO(String teamCode, String image, int rank, int rankERA, int rankAVG) {
		super();
		this.teamCode = teamCode;
		this.image = image;
		this.rank = rank;
		this.rankERA = rankERA;
		this.rankAVG = rankAVG;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRankERA() {
		return rankERA;
	}

	public void setRankERA(int rankERA) {
		this.rankERA = rankERA;
	}

	public int getRankAVG() {
		return rankAVG;
	}

	public void setRankAVG(int rankAVG) {
		this.rankAVG = rankAVG;
	}

	@Override
	public String toString() {
		return "TeamInfoVO [teamCode=" + teamCode + ", image=" + image + ", rank=" + rank + ", rankERA=" + rankERA
				+ ", rankAVG=" + rankAVG + "]";
	}
	
	
	
}
