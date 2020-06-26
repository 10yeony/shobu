package com.shobu.model;

public class PitcherVO extends PlayerVO{
	private int games;
	private String inning;
	private double era;
	private double rate;
	private int win;
	private int lose;
	private int save;
	private int hold;
	private int runs;
	private int hr;
	private int hits;
	private int so;
	private int bb;
	
	public PitcherVO() {}
	
	public PitcherVO(int games, String inning, double era, double rate, int win, int lose, int save, int hold, int runs,
			int hr, int hits, int so, int bb) {
		super();
		this.games = games;
		this.inning = inning;
		this.era = era;
		this.rate = rate;
		this.win = win;
		this.lose = lose;
		this.save = save;
		this.hold = hold;
		this.runs = runs;
		this.hr = hr;
		this.hits = hits;
		this.so = so;
		this.bb = bb;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public String getInning() {
		return inning;
	}

	public void setInning(String inning) {
		this.inning = inning;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public int getHold() {
		return hold;
	}

	public void setHold(int hold) {
		this.hold = hold;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getSo() {
		return so;
	}

	public void setSo(int so) {
		this.so = so;
	}

	public int getBb() {
		return bb;
	}

	public void setBb(int bb) {
		this.bb = bb;
	}

	@Override
	public String toString() {
		return "PitcherVO [games=" + games + ", inning=" + inning + ", era=" + era + ", rate=" + rate + ", win=" + win
				+ ", lose=" + lose + ", save=" + save + ", hold=" + hold + ", runs=" + runs + ", hr=" + hr + ", hits="
				+ hits + ", so=" + so + ", bb=" + bb + "]";
	}
	
	
	
}
