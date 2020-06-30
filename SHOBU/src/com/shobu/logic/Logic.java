package com.shobu.logic;

import com.shobu.model.PitcherVO;
import com.shobu.model.TeamVO;

public class Logic {
	private TeamVO awayTeam;
	private TeamVO homeTeam;
	private PitcherVO awayPitcher;
	private PitcherVO homePitcher;
	
	private double[] scores= {50.0,50.0};
	
// 두 팀정보, 선발선수 정보 주
	public void setTeam(TeamVO awayTeam,TeamVO homeTeam) {
		this.awayTeam=awayTeam;
		this.homeTeam=homeTeam;
	}
	
	public void setPitcher(PitcherVO awayPitcher,PitcherVO homePitcher) {
		this.awayPitcher=awayPitcher;
		this.homePitcher=homePitcher;
	}
	

// 실행메소
	public double[] execute() {
		teamRank();
		teamHitRate();
		teamDefenceRate();
		pitcherDefenceRate();
		return scores;
	}
	
	
// 팀승률 비교 알고리즘.
	private void teamRank() {
		double teamRan1=awayTeam.getRate();
		double teamRan2=homeTeam.getRate();
		
		double temp = Math.abs(teamRan1-teamRan2);
	
		if(temp>=30) {
			if(awayTeam.getGames()>15 || homeTeam.getGames()>15) {
				if(teamRan1>teamRan2) {
					scores[0]+=temp;
					scores[1]-=temp;
				}else {
					scores[1]+=temp;
					scores[0]-=temp;
				}
			}
		}
	}
	
// 팀타율 비교 알고리즘	
	private void teamHitRate() {
		
		double teamHit1= awayTeam.getTeamAVG();
		double teamHit2= homeTeam.getTeamAVG();
		
		double bigAvg=0;
		double smallAvg=0;
		
		double temp = 0;
		
		if(teamHit1>teamHit2) {
			bigAvg=teamHit1;
			smallAvg=teamHit2;
		}else if(teamHit1<teamHit2) {
			bigAvg=teamHit2;
			smallAvg=teamHit1;
		}
		
		temp = bigAvg - smallAvg;
		temp = temp*100;
		
		if(teamHit1>teamHit2) {
			scores[0]+=temp;
			scores[1]-=temp;
			
		}else if(teamHit1<teamHit2) {
			scores[1]+=temp;
			scores[0]-=temp;
		}	
	}

//팀방어율 비교 알고리즘
	private void teamDefenceRate() {
		double teamDfs1= awayTeam.getTeamEra();
		double teamDfs2= homeTeam.getTeamEra();
		
		double temp = Math.abs(teamDfs1-teamDfs2);
		
		if(teamDfs1>teamDfs2) {
			scores[0]-=temp;
			scores[1]+=temp;
		}else if(teamDfs1<teamDfs2) {
			scores[0]+=temp;
			scores[1]-=temp;
		}
	}
	
// 투수방어율 비교 알고리즘.
	private void pitcherDefenceRate() {
		double pitcherDfs1=awayPitcher.getEra();
		double pitcherDfs2=homePitcher.getEra();

		String pitcher1Ining = awayPitcher.getInning().split(" ")[0];
		String pitcher2Ining = homePitcher.getInning().split(" ")[0];
		if(Integer.parseInt(pitcher1Ining)<16 || Integer.parseInt(pitcher2Ining)<16) {
			return;
		}
		
		double temp = Math.abs(pitcherDfs1-pitcherDfs2);
		
		if(pitcherDfs1>pitcherDfs2) {
			scores[0]-=temp;
			scores[1]+=temp;
		}else if(pitcherDfs1<pitcherDfs2) {
			scores[0]+=temp;
			scores[1]-=temp;
		}
		
	}
}
