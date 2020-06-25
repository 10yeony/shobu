package com.shobu.model;

public class TeamVO {
	private String teamCode;
	private String image;
	private int ranking;
	private int games;
	private int win;
	private int draw;
	private int lose;
	private double rate;
	private double distance;
	private double teamAVG;
	private double teamEra;
	private String stream;
	private String games10;
	
	public TeamVO() {}

	public TeamVO(String teamCode, String image, int ranking, int games, int win, int draw, int lose, double rate,
			double distance, double teamAVG, double teamEra, String stream, String games10) {
		super();
		this.teamCode = teamCode;
		this.image = image;
		this.ranking = ranking;
		this.games = games;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
		this.rate = rate;
		this.distance = distance;
		this.teamAVG = teamAVG;
		this.teamEra = teamEra;
		this.stream = stream;
		this.games10 = games10;
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTeamAVG() {
		return teamAVG;
	}

	public void setTeamAVG(double teamAVG) {
		this.teamAVG = teamAVG;
	}

	public double getTeamEra() {
		return teamEra;
	}

	public void setTeamEra(double teamEra) {
		this.teamEra = teamEra;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getGames10() {
		return games10;
	}

	public void setGames10(String games10) {
		this.games10 = games10;
	}

	@Override
	public String toString() {
		return "TeamVO [teamCode=" + teamCode + ", image=" + image + ", ranking=" + ranking + ", games=" + games
				+ ", win=" + win + ", draw=" + draw + ", lose=" + lose + ", rate=" + rate + ", distance=" + distance
				+ ", teamAVG=" + teamAVG + ", teamEra=" + teamEra + ", stream=" + stream + ", games10=" + games10 + "]";
	}

	
}
