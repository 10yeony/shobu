package crawling;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.HitterVO;
import model.MatchVO;
import model.PitcherVO;
import model.PlayerVO;
import model.TeamVO;

public class PlayerUpdate {
	
	//00.NC선수단 업데이트
	public ArrayList<PlayerVO> updateNC() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&id=1&seq=&season=2020&isToto=&teamId=NC").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=HT").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=KT").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=LG").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					//System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=SK").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=OB").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=LT").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=SS").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=WO").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
				}
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerlist;
	}
	//09.한화선수단 업데이트
	public ArrayList<PlayerVO> updateHANHWA() {
		ArrayList<PlayerVO> playerlist = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			try {
				Document doc = Jsoup.connect("https://betman.co.kr/sportsTeamIntro.so?method=inquireTeamIntro&item=BS&league=BS001&seq=&id=1&isToto=&teamId=HH").get();
				Elements links = doc.select(".data_dproList tbody tr").eq(i);
				String position = links.select("th").text();
				String name = "";
				String teamCode = "";
				int playerId = 0;
				for (int j = 0 ; j<links.select("a").size(); j++) {
					PlayerVO player = new PlayerVO();
					playerId = Integer.parseInt(links.select("a").eq(j).toString().split("'")[3]);
					teamCode = links.select("a").eq(j).toString().split("'")[1];
					name = links.select("a").eq(j).text();
					
					player.setPlayerId(playerId);
					player.setTeamCode(teamCode);
					player.setName(name);
					player.setPosition(position);
					player.setImage("image/"+playerId+".jpg");
					
					playerlist.add(player);
					
					System.out.println(position + " " + name +" "+ teamCode +" " + playerId);
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
			Document doc = Jsoup.connect("https://betman.co.kr/sportsPlayerIntro.so?method=inquirePlayerIntro&item=BS&league=BS001&seq=&id=1&teamId="+teamCode+"&isToto=&playerId="+playerId).get();
			Elements links = doc.select("tbody").eq(1);
			pitcher.setGames(Integer.parseInt(links.select("td").eq(0).text()));
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
			
			System.out.println(pitcher);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pitcher;
		
	}
	
	//11.타자성적 업데이트
	public HitterVO updateHitter(int playerId, String teamCode) {
		HitterVO hitter = new HitterVO();
		try {
			Document doc = Jsoup.connect("https://betman.co.kr/sportsPlayerIntro.so?method=inquirePlayerIntro&item=BS&league=BS001&seq=&id=1&teamId="+teamCode+"&isToto=&playerId="+playerId).get();
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
			hitter.setOps(hitter.getRate()+hitter.getSlg());
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
				Document doc = Jsoup.connect("http://betman.co.kr/teamRanking.so?method=inquireRanking&item=BS&league=BS001&id=1&fromCode=left").get();
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
				System.out.println(team);
				
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
			Document doc = Jsoup.connect("http://www.statiz.co.kr/boxscore.php?opt=1&date="+date).get();
			Elements links = doc.select(".row").eq(3);
			for(int i = 0 ; i<5; i++) {
				MatchVO match = new MatchVO();
				match.setDate(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[2]);
				match.setTime(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[4]);
				match.setHome(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[5]);
				match.setAway(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[0]);
				match.setPlace(links.select(".box").eq(i).select(".pull-left a").text().split(" ")[3]);
				matchlist.add(match);
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return matchlist;
		
	}
}
