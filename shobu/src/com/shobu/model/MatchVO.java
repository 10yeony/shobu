package com.shobu.model;

public class MatchVO {
	private String date;
	private String time;
	private String home;
	private String away;
	private String homePitcher;
	private String awayPitcher;
	private String place;
	
	public MatchVO() {}
	
	public MatchVO(String date, String time, String home, String away, String homePitcher, String awayPitcher,
			String place) {
		super();
		this.date = date;
		this.time = time;
		this.home = home;
		this.away = away;
		this.homePitcher = homePitcher;
		this.awayPitcher = awayPitcher;
		this.place = place;
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

	@Override
	public String toString() {
		return "MatchVO [date=" + date + ", time=" + time + ", home=" + home + ", away=" + away + ", homePitcher="
				+ homePitcher + ", awayPitcher=" + awayPitcher + ", place=" + place + "]";
	}
	
	
	
}
