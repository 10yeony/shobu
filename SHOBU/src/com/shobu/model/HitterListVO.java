package com.shobu.model;

public class HitterListVO {
	private int playerId;
	private String teamCode;
	private String name;
	private String position;
	private String image;
	private int number;
	private String birth;
	private String type;
	private int games;
	private double rate;
	private int ab;
	private int hits;
	private int hr;
	private int rbi;
	private int runs;
	private int bb;
	private int so;
	private double obp;
	private double slg;
	private double ops = obp+slg;
	private int steal;
	private int error;
	
	public HitterListVO() {}
	public HitterListVO(int playerId, String teamCode, String name, String position, String image, int number,
			String birth, String type, int games, double rate, int ab, int hits, int hr, int rbi, int runs, int bb,
			int so, double obp, double slg, double ops, int steal, int error) {
		super();
		this.playerId = playerId;
		this.teamCode = teamCode;
		this.name = name;
		this.position = position;
		this.image = image;
		this.number = number;
		this.birth = birth;
		this.type = type;
		this.games = games;
		this.rate = rate;
		this.ab = ab;
		this.hits = hits;
		this.hr = hr;
		this.rbi = rbi;
		this.runs = runs;
		this.bb = bb;
		this.so = so;
		this.obp = obp;
		this.slg = slg;
		this.ops = ops;
		this.steal = steal;
		this.error = error;
		
		
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
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getAb() {
		return ab;
	}
	public void setAb(int ab) {
		this.ab = ab;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getRbi() {
		return rbi;
	}
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getBb() {
		return bb;
	}
	public void setBb(int bb) {
		this.bb = bb;
	}
	public int getSo() {
		return so;
	}
	public void setSo(int so) {
		this.so = so;
	}
	public double getObp() {
		return obp;
	}
	public void setObp(double obp) {
		this.obp = obp;
	}
	public double getSlg() {
		return slg;
	}
	public void setSlg(double slg) {
		this.slg = slg;
	}
	public double getOps() {
		return ops;
	}
	public void setOps(double ops) {
		this.ops = ops;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "HitterListVO [playerId=" + playerId + ", teamCode=" + teamCode + ", name=" + name + ", position="
				+ position + ", image=" + image + ", number=" + number + ", birth=" + birth + ", type=" + type
				+ ", games=" + games + ", rate=" + rate + ", ab=" + ab + ", hits=" + hits + ", hr=" + hr + ", rbi="
				+ rbi + ", runs=" + runs + ", bb=" + bb + ", so=" + so + ", obp=" + obp + ", slg=" + slg + ", ops="
				+ ops + ", steal=" + steal + ", error=" + error + "]";
	}
	
	
}
