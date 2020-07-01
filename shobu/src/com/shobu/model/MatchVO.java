package com.shobu.model;

public class MatchVO {
	private String date;
	private String time;
	private String home;
	private String homeImg;
	private String homeColor;
	private double homeRatio;
	private String away;
	private String awayImg;
	private String awayColor;
	private double awayRatio;
	private String homePitcher;
	private int homePitcherGames;
	private String homeWinLose;
	private String homeInning;
	private double homeERA;
	private String awayPitcher;
	private String place;
	private int awayPitcherGames;
	private String awayWinLose;
	private String awayInning;
	private double awayERA;
	
	public MatchVO() {}
	
	public MatchVO(String date, String time, String home, String away,
			String homePitcher, String awayPitcher, String place) {
		super();
		this.date = date;
		this.time = time;
		this.home = home;
		this.away = away;
		this.homePitcher = homePitcher;
		this.awayPitcher = awayPitcher;
		this.place = place;
	}

	public MatchVO(String date, String time, String home, String homeImg, String homeColor, double homeRatio,
			String away, String awayImg, String awayColor, double awayRatio, String homePitcher, int homePitcherGames,
			String homeWinLose, String homeInning, double homeERA, String awayPitcher, String place,
			int awayPitcherGames, String awayWinLose, String awayInning, double awayERA) {
		super();
		this.date = date;
		this.time = time;
		this.home = home;
		this.homeImg = homeImg;
		this.homeColor = homeColor;
		this.homeRatio = homeRatio;
		this.away = away;
		this.awayImg = awayImg;
		this.awayColor = awayColor;
		this.awayRatio = awayRatio;
		this.homePitcher = homePitcher;
		this.homePitcherGames = homePitcherGames;
		this.homeWinLose = homeWinLose;
		this.homeInning = homeInning;
		this.homeERA = homeERA;
		this.awayPitcher = awayPitcher;
		this.place = place;
		this.awayPitcherGames = awayPitcherGames;
		this.awayWinLose = awayWinLose;
		this.awayInning = awayInning;
		this.awayERA = awayERA;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public String getHomePitcher() {
		return homePitcher;
	}

	public void setHomePitcher(String homePitcher) {
		this.homePitcher = homePitcher;
	}

	public String getAwayPitcher() {
		return awayPitcher;
	}

	public void setAwayPitcher(String awayPitcher) {
		this.awayPitcher = awayPitcher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getHomeImg() {
		return homeImg;
	}

	public void setHomeImg(String homeImg) {
		this.homeImg = homeImg;
	}

	public String getAwayImg() {
		return awayImg;
	}

	public void setAwayImg(String awayImg) {
		this.awayImg = awayImg;
	}

	public double getHomeRatio() {
		return homeRatio;
	}

	public void setHomeRatio(double homeRatio) {
		this.homeRatio = homeRatio;
	}

	public double getAwayRatio() {
		return awayRatio;
	}

	public void setAwayRatio(double awayRatio) {
		this.awayRatio = awayRatio;
	}
	
	public String getHomeColor() {
		return homeColor;
	}

	public void setHomeColor(String homeColor) {
		this.homeColor = homeColor;
	}

	public String getAwayColor() {
		return awayColor;
	}

	public void setAwayColor(String awayColor) {
		this.awayColor = awayColor;
	}
	
	

	public int getHomePitcherGames() {
		return homePitcherGames;
	}

	public void setHomePitcherGames(int homePitcherGames) {
		this.homePitcherGames = homePitcherGames;
	}

	public String getHomeWinLose() {
		return homeWinLose;
	}

	public void setHomeWinLose(String homeWinLose) {
		this.homeWinLose = homeWinLose;
	}

	public String getHomeInning() {
		return homeInning;
	}

	public void setHomeInning(String homeInning) {
		this.homeInning = homeInning;
	}

	public double getHomeERA() {
		return homeERA;
	}

	public void setHomeERA(double homeERA) {
		this.homeERA = homeERA;
	}

	public int getAwayPitcherGames() {
		return awayPitcherGames;
	}

	public void setAwayPitcherGames(int awayPitcherGames) {
		this.awayPitcherGames = awayPitcherGames;
	}

	public String getAwayWinLose() {
		return awayWinLose;
	}

	public void setAwayWinLose(String awayWinLose) {
		this.awayWinLose = awayWinLose;
	}

	public String getAwayInning() {
		return awayInning;
	}

	public void setAwayInning(String awayInning) {
		this.awayInning = awayInning;
	}

	public double getAwayERA() {
		return awayERA;
	}

	public void setAwayERA(double awayERA) {
		this.awayERA = awayERA;
	}

	@Override
	public String toString() {
		return "MatchVO [date=" + date + ", time=" + time + ", home=" + home + ", homeImg=" + homeImg + ", homeColor="
				+ homeColor + ", homeRatio=" + homeRatio + ", away=" + away + ", awayImg=" + awayImg + ", awayColor="
				+ awayColor + ", awayRatio=" + awayRatio + ", homePitcher=" + homePitcher + ", homePitcherGames="
				+ homePitcherGames + ", homeWinLose=" + homeWinLose + ", homeInning=" + homeInning + ", homeERA="
				+ homeERA + ", awayPitcher=" + awayPitcher + ", place=" + place + ", awayPitcherGames="
				+ awayPitcherGames + ", awayWinLose=" + awayWinLose + ", awayInning=" + awayInning + ", awayERA="
				+ awayERA + "]";
	}

}
