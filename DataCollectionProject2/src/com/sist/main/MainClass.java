package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String html ="<script id=sc>[{name:'hong',sex:'man'},{name:'hong2',sex:'man2'}]</script>" 
				+"<div class=\"row\">"
				+ "  <div class=\"col-md-4\">"
				+ "    <div class=\"thumbnail\">"
				+ "      <a href=\"/w3images/lights.jpg\">"
				+ "        <img src=\"/w3images/lights.jpg\" alt=\"Lights\" style=\"width:100%\">"
				+ "        <div class=\"caption\">"
				+ "          <p>Lorem ipsum...1</p>"	// selectFirst() / select("div.caption p").get(0)
				+ "        </div>"		
				+ "      </a>"
				+ "    </div>"
				+ "  </div>"
				+ "  <div class=\"col-md-4\">"
				+ "    <div class=\"thumbnail\">"
				+ "      <a href=\"/w3images/nature.jpg\">"
				+ "        <img src=\"/w3images/nature.jpg\" alt=\"Nature\" style=\"width:100%\">"
				+ "        <div class=\"caption\">"
				+ "          <p>Lorem ipsum...2</p>"
				+ "        </div>"
				+ "      </a>"
				+ "    </div>"
				+ "  </div>"
				+ "  <div class=\"col-md-4\">"
				+ "    <div class=\"thumbnail\">"
				+ "      <a href=\"/w3images/fjords.jpg\">"
				+ "        <img src=\"/w3images/fjords.jpg\" alt=\"Fjords\" style=\"width:100%\">"
				+ "        <div id=\"caption\">"
				+ "          <p>Lorem ipsum...3</p>"	//
				+ "        </div>"
				+ "      </a>"
				+ "    </div>"
				+ "  </div>"
				+ "</div>"
				+"<p>Hello Jsoup</p>";
		
		/*
		 * 	text() ==> 태그 사이 <p>Lorem ipsum...</p>
		 *  attr() ==> 속성값 <img src=\"/w3images/fjords.jpg\" alt=\"Fjords\" style=\"width:100%\">
		 *         ==> attr("src"|"alt"|"style") => img, a
		 *  html() ==> 태그 자체
		 *  data() ==> javascript
		 *  
		 *  Elements : 태그 여러개 모아서 가져오기 (ex)p태그 Lorem ipsum 여러개 가져올 때)
		 *  Element => CSS 선택자 이용 => id(태그명#id명), class(태그명.class명)
		 */
		
		try {
			Document doc = Jsoup.parse(html);	// parse() 내부
			// connect() 외부 => web사이트 주소
			Element p = doc.selectFirst("div#caption p");
			System.out.println(p.text());
			
			System.out.println();
			
			Elements ps1 = doc.select("p");
			System.out.println(p);
			
			System.out.println();

			Elements ps = doc.select("div.caption p");
			System.out.println(ps);
			for (int i=0; i<ps.size(); i++) {
				System.out.println(ps.get(i).text());
			}
			
			System.out.println();
			
			Elements img = doc.select("div.thumbnail img");
			System.out.println(img);
			for (int i=0; i<img.size(); i++) {
				System.out.println(img.get(i).attr("src"));
			}
			Elements img2 = doc.select("div.thumbnail");
			for (int i=0; i<img2.size(); i++) {
				System.out.println(img2.get(i).html());
			}
			
			System.out.println();
			
			Element sc = doc.selectFirst("#sc");
			System.out.println(sc);
			System.out.println(sc.data());	// text() 안 됨 => script 읽을 때
		} catch(Exception ex) {}
	}

}
