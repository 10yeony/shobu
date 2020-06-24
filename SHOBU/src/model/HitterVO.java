package model;

public class HitterVO extends PlayerVO{
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
	
	public HitterVO() {}
	
	public HitterVO(int games, double rate, int ab, int hits, int hr, int rbi, int runs, int bb, int so, double obp,
			double slg, double ops, int steal, int error) {
		super();
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
		return "HitterVO [games=" + games + ", rate=" + rate + ", ab=" + ab + ", hits=" + hits + ", hr=" + hr + ", rbi="
				+ rbi + ", runs=" + runs + ", bb=" + bb + ", so=" + so + ", obp=" + obp + ", slg=" + slg + ", ops="
				+ ops + ", steal=" + steal + ", error=" + error + "]";
	}
	
	
}
