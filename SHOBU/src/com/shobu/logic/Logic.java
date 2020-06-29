package com.shobu.logic;

import com.shobu.model.PitcherVO;
import com.shobu.model.TeamVO;

public class Logic {
	private TeamVO team1;
	private TeamVO team2;
	private PitcherVO pitcher1;
	private PitcherVO pitcher2;
	
	private double[] scores= {50.0,50.0};
	
// 두 팀정보, 선발선수 정보 주
	public void setTeam(TeamVO team1,TeamVO team2) {
		this.team1=team1;
		this.team2=team2;
	}
	
	public void setPitcher(PitcherVO pitcher1,PitcherVO pitcher2) {
		this.pitcher1=pitcher1;
		this.pitcher2=pitcher2;
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
		double teamRan1=team1.getRate();
		double teamRan2=team2.getRate();
		
		double temp = Math.abs(teamRan1-teamRan2);
	
		if(temp>=30) {
			if(team1.getGames()>15 || team2.getGames()>15) {
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
		
		double teamHit1= team1.getTeamAVG();
		double teamHit2= team2.getTeamAVG();
		
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
		double teamDfs1= team1.getTeamEra();
		double teamDfs2= team2.getTeamEra();
		
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
		double pitcherDfs1=pitcher1.getEra();
		double pitcherDfs2=pitcher2.getEra();

		String pitcher1Ining = pitcher1.getInning().split(" ")[0];
		String pitcher2Ining = pitcher2.getInning().split(" ")[0];
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
