import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import crawling.PlayerUpdate;
import model.PlayerVO;
import model.TeamVO;

public class main {

	public static void main(String[] args) {
		String name = "HT";
		int id = 62908;
		
		PlayerUpdate pu = new PlayerUpdate();
		
		
		
		/*ArrayList<PlayerVO> list = pu.updateLG();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		//PlayerVO [playerId=76290, teamName=LG, name=±èÇö¼ö, position=¿Ü¾ß¼ö]
		
		//System.out.println(pu.updateMatch("2020-06-24"));
		
		//System.out.println(pu.updateHitter(76290, "±èÇö¼ö"));
		ArrayList<TeamVO> list = pu.updateTeam();
		/*for(int i = 0; i<list.size(); i++) {
			list.get
		}*/
		
		pu.updateTeam();
	}

}
