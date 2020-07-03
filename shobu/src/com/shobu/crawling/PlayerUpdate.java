package com.shobu.crawling;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.shobu.model.HitterVO;
import com.shobu.model.MatchVO;
import com.shobu.model.Pitcher3VO;
import com.shobu.model.PitcherVO;
import com.shobu.model.PlayerVO;
import com.shobu.model.ResultVO;
import com.shobu.model.TeamVO;

public class PlayerUpdate {
	private final int T= 1000*60*60;
	//00.NC선수단 업데이트
	public ArrayList<PlayerVO> updateNC() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&id=1&seq=&season=2020&isToto=&teamId=NC").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");
					
					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//01.KIA선수단 업데이트
	public ArrayList<PlayerVO> updateKIA() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=HT").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");
					
					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//02.KT선수단 업데이트
	public ArrayList<PlayerVO> updateKT() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=KT").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//03.LG선수단 업데이트
	public ArrayList<PlayerVO> updateLG() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=LG").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//04.SK선수단 업데이트
	public ArrayList<PlayerVO> updateSK() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=SK").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	
	//05.두산선수단 업데이트
	public ArrayList<PlayerVO> updateDOOSAN() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=OB").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//06.롯데선수단 업데이트
	public ArrayList<PlayerVO> updateLOTTE() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=LT").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//07.삼성선수단 업데이트
	public ArrayList<PlayerVO> updateSAMSUNG() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=SS").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");

					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//08.키움선수단 업데이트
	public ArrayList<PlayerVO> updateKIWOOM() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=WO").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");
					
					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//09.한화선수단 업데이트
	public  ArrayList<PlayerVO> updateHANHWA() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=HH").timeout(T).get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				Document doc2;
				Elements links2;
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				int number = 0;
				String birth = "";
				String type = "";
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					doc2 = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
					links2 = doc2.select(".player_basic ul");
					
					if(links2.select("span").eq(1).text().equals("")) number = 0;
					else number = Integer.parseInt(links2.select("span").eq(1).text());
					
					birth = links2.select("span").eq(2).text();
					type = links2.select("span").eq(3).text().split("[(]")[1].substring(0,4);
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/player/"+playerId+".jpg");
					player.setNumber(number);
					player.setBirth(birth);
					player.setType(type);
					
					playerlist.add(player);
					
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//10.투수성적 업데이트
	public PitcherVO updatePitcher(int playerId, String teamCode) {
		PitcherVO pitcher = new PitcherVO();
		try {
			Document doc = Jsoup.connect("https://betman.co.kr/sportsPlayerIntro.so?method=inquirePlayerIntro&item=BS&league=BS001&seq=&id=1&teamId="+teamCode+"&isToto=&playerId="+playerId).timeout(T).get();
			Elements links = doc.select("tbody").eq(1);
			pitcher.setGames(Integer.parseInt(links.select("td").eq(0).text()));
			if(links.select("td").eq(1).text() == null)
				pitcher.setInning("0");
			else
				pitcher.setInning(links.select("td").eq(1).text());
			pitcher.setEra(Double.parseDouble(links.select("td").eq(2).text()));
			pitcher.setRate(Double.parseDouble(links.select("td").eq(3).text()));
			pitcher.setWin(Integer.parseInt(links.select("td").eq(4).text()));
			pitcher.setLose(Integer.parseInt(links.select("td").eq(5).text()));
			pitcher.setSave(Integer.parseInt(links.select("td").eq(6).text()));
			pitcher.setHold(Integer.parseInt(links.select("td").eq(7).text()));
			pitcher.setRuns(Integer.parseInt(links.select("td").eq(8).text()));
			pitcher.setHr(Integer.parseInt(links.select("td").eq(10).text()));
			pitcher.setHits(Integer.parseInt(links.select("td").eq(11).text()));
			pitcher.setSo(Integer.parseInt(links.select("td").eq(12).text()));
			pitcher.setBb(Integer.parseInt(links.select("td").eq(13).text()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pitcher;
		
	}
	
	//11.타자성적 업데이트
	public HitterVO updateHitter(int playerId, String teamCode) {
		HitterVO hitter = new HitterVO();
		try {
			Document doc = Jsoup.connect("https://betman.co.kr/sportsPlayerIntro.so?method=inquirePlayerIntro&item=BS&league=BS001&seq=&id=1&teamId="+teamCode+"&isToto=&playerId="+playerId).timeout(T).get();
			Elements links = doc.select("tbody").eq(1);
			hitter.setGames(Integer.parseInt(links.select("td").eq(0).text()));
			hitter.setRate(Double.parseDouble(links.select("td").eq(1).text()));
			hitter.setAb(Integer.parseInt(links.select("td").eq(2).text()));
			hitter.setHits(Integer.parseInt(links.select("td").eq(3).text()));
			hitter.setHr(Integer.parseInt(links.select("td").eq(6).text()));
			hitter.setRbi(Integer.parseInt(links.select("td").eq(7).text()));
			hitter.setRuns(Integer.parseInt(links.select("td").eq(8).text()));
			hitter.setBb(Integer.parseInt(links.select("td").eq(9).text()));
			hitter.setSo(Integer.parseInt(links.select("td").eq(10).text()));
			hitter.setObp(Double.parseDouble(links.select("td").eq(11).text()));
			hitter.setSlg(Double.parseDouble(links.select("td").eq(12).text()));
			hitter.setOps(hitter.getObp()+hitter.getSlg());
			hitter.setSteal(Integer.parseInt(links.select("td").eq(13).text()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hitter;
		
	}
	
	//12.팀 순위 업데이트
	public ArrayList<TeamVO> updateTeam(){
		ArrayList<TeamVO> teamlist = new ArrayList<>();
		try {
			for(int i = 0; i<10; i++) {
				TeamVO team = new TeamVO();
				Document doc = Jsoup.connect("http://betman.co.kr/teamRanking.so?method=inquireRanking&item=BS&league=BS001&id=1&fromCode=left").timeout(T).get();
				Elements links = doc.select(".dataH01 tbody tr").eq(i);
				
				team.setRanking(Integer.parseInt(links.select("td").eq(0).text()));
				switch (links.select("td").eq(1).text()) {
				case "두산":
					team.setTeamCode("OB");
					break;
				case "KIA":
					team.setTeamCode("HT");
					break;	
				case "KT":
					team.setTeamCode("KT");
					break;
				case "LG":
					team.setTeamCode("LG");
					break;
				case "NC":
					team.setTeamCode("NC");
					break;
				case "SK":
					team.setTeamCode("SK");
					break;
				case "롯데":
					team.setTeamCode("LT");
					break;
				case "삼성":
					team.setTeamCode("SS");
					break;
				case "키움":
					team.setTeamCode("WO");
					break;
				case "한화":
					team.setTeamCode("HH");
					break;
				default:
					break;
				}
				team.setGames(Integer.parseInt(links.select("td").eq(2).text()));
				team.setWin(Integer.parseInt(links.select("td").eq(3).text()));
				team.setDraw(Integer.parseInt(links.select("td").eq(4).text()));
				team.setLose(Integer.parseInt(links.select("td").eq(5).text()));
				team.setRate(Double.parseDouble(links.select("td").eq(6).text()));
				team.setDistance(Double.parseDouble(links.select("td").eq(7).text()));
				team.setTeamAVG(Double.parseDouble(links.select("td").eq(10).text()));
				team.setTeamEra(Double.parseDouble(links.select("td").eq(11).text()));
				team.setStream(links.select("td").eq(12).text());
				team.setGames10(links.select("td").eq(13).text());
				
				teamlist.add(team);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return teamlist;
		
	}
	
	//13.경기정보 업데이트
	//	ex)String date = "2020-06-24";
	public ArrayList<MatchVO> updateMatch(String date){
		ArrayList<MatchVO> matchlist = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("http://www.statiz.co.kr/boxscore.php?opt=1&date="+date).timeout(T).get();
			Elements links = doc.select(".row").eq(3);
			Document doc2 = Jsoup.connect("https://sports.news.naver.com/kbaseball/index.nhn").timeout(T).get();
			Elements links2 = doc2.select(".hmb_list");
			for(int i = 0 ; i<5; i++) {
				MatchVO match = new MatchVO();
				match.setDate(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[2]);
				match.setTime(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[4]);
				match.setHome(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[5]);
				match.setAway(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[0]);
				match.setPlace(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[3]);
				
				match.setHomeCode(transferTeamCode(match.getHome()));
				match.setAwayCode(transferTeamCode(match.getAway()));
				
				for(int j = 0; j<5; j++) {
					if(match.getHome().equals(links2.select("li").eq(j).select("span").eq(2).text())){
						match.setHomePitcher(links2.select("li").eq(j).select("span").eq(3).text());
						match.setAwayPitcher(links2.select("li").eq(j).select("span").eq(1).text());
					}
				}
				
				
				matchlist.add(match);
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return matchlist;
		
	}

	//14.투수 최근3경기
	public Pitcher3VO updatePitcher3(int playerId) {
		Pitcher3VO pitcher3 = new Pitcher3VO();
		try {
			Document doc = Jsoup.connect("https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId="+playerId).timeout(T).get();
			Elements links = doc.select("tbody").eq(2);
			pitcher3.setPlayerId(playerId);
			pitcher3.setDay1(links.select("tr").eq(0).select("td").eq(0).text());
			pitcher3.setDay2(links.select("tr").eq(1).select("td").eq(0).text());
			pitcher3.setDay3(links.select("tr").eq(2).select("td").eq(0).text());
			
		} catch (Exception e) {
		}
		
		return pitcher3;
		
	}
	
	//15.지난경기 결과
	public ResultVO updateResult(String date) {
		ResultVO result = new ResultVO();
		ArrayList<String> arr = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("http://www.statiz.co.kr/boxscore.php?opt=1&sopt=0&date="+date).timeout(T).get();
			Elements link = doc.select("tbody");
			
			for(int i = 1; i<6; i++) {
				Elements links = link.eq(i);
				String home = links.select("tr").eq(1).select("td").first().text();
				String away = links.select("tr").eq(2).select("td").first().text();
				
				int homescore = Integer.parseInt(links.select("tr").eq(1).select("td").last().text());
				int awayscore = Integer.parseInt(links.select("tr").eq(2).select("td").last().text());
				if(homescore > awayscore) {
					arr.add(home);
				}
				else if(homescore < awayscore) {
					arr.add(away);
				}
			}
			
			result.setDate(date);
			result.setGame1(arr.get(0));
			result.setGame2(arr.get(1));
			result.setGame3(arr.get(2));
			result.setGame4(arr.get(3));
			result.setGame5(arr.get(4));
			result.setCheck(0);
			
		} catch (Exception e) {
			
		}
		
		return result;
	}
	//팀명 -> 팀코드 변환
	public String transferTeamCode(String teamName) {
		String teamCode = null;
		
		if(teamName.equals("두산")) teamCode = "OB";
		else if(teamName.equals("NC")) teamCode = "NC";
		else if(teamName.equals("KT")) teamCode = "KT";
		else if(teamName.equals("LG")) teamCode = "LG";
		else if(teamName.equals("SK")) teamCode = "SK";
		else if(teamName.equals("KIA")) teamCode = "HT";
		else if(teamName.equals("롯데")) teamCode = "LT";
		else if(teamName.equals("삼성")) teamCode = "SS";
		else if(teamName.equals("한화")) teamCode = "HH";
		else if(teamName.equals("키움")) teamCode = "WO";
		
		return teamCode;
		
	}
	//팀코드 -> 팀명 변환
	public String transferTeamName(String teamCode) {
		String teamName = null;
		
		if(teamCode.equals("OB")) teamName = "두산";
		else if(teamCode.equals("NC")) teamName = "NC";
		else if(teamCode.equals("KT")) teamName = "KT";
		else if(teamCode.equals("LG")) teamName = "LG";
		else if(teamCode.equals("SK")) teamName = "SK";
		else if(teamCode.equals("HT")) teamName = "KIA";
		else if(teamCode.equals("LT")) teamName = "롯데";
		else if(teamCode.equals("SS")) teamName = "삼성";
		else if(teamCode.equals("HH")) teamName = "한화";
		else if(teamCode.equals("WO")) teamName = "키움";
		
		return teamName;
		
	}
}
