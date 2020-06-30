package com.shobu.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.shobu.dao.ModelDaoImpl;
import com.shobu.model.MapVO;

public class Parsing {

	public static ArrayList<MapVO> storeParsing() throws SQLException {
		ArrayList<MapVO> storeInfo = new ArrayList<>();

		MapVO map = new MapVO();

		int page = 1;
		int loca = 101;
		
		 while (true) {
			try {
				Document doc = Jsoup.connect("https://www.sportstoto.co.kr/find_store.php?page=" + page+ "&type=s&area_1=01&area_2=0" + loca).get();
				Elements links = doc.select("tbody tr");
				page++;
				if (links.attr("data-loc1").length()==0) {
					page=1;
					loca++;
					if(loca>130) {
						break;
					}
					continue;
				}
				for (Element link : links) {
					String a = link.attr("data-loc1");
					String name = link.attr("name");
					String loX = link.attr("x-axis");
					String loY = link.attr("y-axis");
					map.setAddr(a);
					map.setStoreName(name);
					map.setLocalX(loX);
					map.setLocalY(loY);
					ModelDaoImpl.getInstance().insertMap(new MapVO(a, name, loX, loY));
					
					storeInfo.add(map);
					System.out.println(map);
					System.out.println("추가");
					
				}
				System.out.println("다음페이지 이동"+page);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return storeInfo;
	}
	
	
	
//	페이지변화
//	https://www.sportstoto.co.kr/find_store.php?page=2&type=s&area_1=05&area_2=0501
//	https://www.sportstoto.co.kr/find_store.php?page=3&type=s&area_1=05&area_2=0501	

// 	구변화	
//	https://www.sportstoto.co.kr/find_store.php?page=1&type=s&area_1=05&area_2=0503	

//	시변화
// 	https://www.sportstoto.co.kr/find_store.php?page=1&type=s&area_1=07&area_2=0701
//	https://www.sportstoto.co.kr/find_store.php?page=2&type=s&area_1=17&area_2=1701	

	
//	public static ArrayList<MapVO> storeParsing() {
//		ArrayList<MapVO> storeInfo = new ArrayList<>();
//
//		MapVO map = new MapVO();
//
//		int page = 1;
//		int loca1 =2;
//		int loca2 = 201;
//		
//		 while (true) {
//			try {
//				Document doc = Jsoup.connect("https://www.sportstoto.co.kr/find_store.php?page=" + page+ "&type=s&area_1=0"+loca1+"&area_2=0" + loca2).get();
//				Elements links = doc.select("tbody tr");
//				page++;
//				if (links.attr("data-loc1").length()==0) {
//					page=1;
//					loca2++;
//					if(loca2>230) {
//						break;
//					}
//					continue;
//				}
//				for (Element link : links) {
//					String a = link.attr("data-loc1");
//					String name = link.attr("name");
//					String loX = link.attr("x-axis");
//					String loY = link.attr("y-axis");
//					map.setAddr(a);
//					map.setStoreName(name);
//					map.setLocalX(loX);
//					map.setLocalY(loY);
//					storeInfo.add(map);
//					System.out.println(map);
//				}
//				System.out.println("다음페이지 이동"+page);
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(storeInfo.size()); 
//		System.out.println(storeInfo.get(0).get);
//		return storeInfo;
//	}
	
	
	public static void main(String[] args) throws SQLException {
//		storeParsing();
		
		System.out.println(ModelDaoImpl.getInstance().selectMap().get(1));
		System.out.println(ModelDaoImpl.getInstance().selectMap().get(1002));
		System.out.println(ModelDaoImpl.getInstance().selectMap().get(1001));

	}

}
