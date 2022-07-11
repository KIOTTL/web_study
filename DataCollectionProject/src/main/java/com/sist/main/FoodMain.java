package com.sist.main;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.FoodCategoryVO;
import com.sist.dao.FoodDAO;

/*
 * <div class="slider-container toplist-slider">
    <button class="btn-nav prev"></button>
    <button class="btn-nav next"></button>

    <div class="top_list_slide">
        <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="호텔 빙수 베스트 10곳 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/rfgqsashp1gwnwvu.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>
						// => attr() (속성값)
              <a href="/top_lists/1965_hotel_bingsu"	// => attr()
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;믿고 보는 맛집 리스트&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;NHL8COT&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">호텔 빙수 베스트 10곳</span>  // => text() (태그와 태그 사이)
                      <p class="desc">"고급 중에서도 고급! 최고의 호텔 빙수는 어디?"</p>   // => text()
 */

public class FoodMain {
	
	public void categoryData() {
		try {
			FoodDAO dao = new FoodDAO();
			Document doc = Jsoup.connect("https://www.mangoplate.com/").get();
			Elements title = doc.select("div.top_list_slide span.title");
			Elements subject = doc.select("div.top_list_slide p.desc");
			Elements poster = doc.select("div.top_list_slide img.center-croping");
			Elements link = doc.select("div.top_list_slide a");
			
			for (int i=0; i<title.size(); i++) {
				System.out.println(i+1);
				System.out.println(title.get(i).text());
				System.out.println(subject.get(i).text());
				System.out.println(poster.get(i).attr("data-lazy"));
				System.out.println(link.get(i).attr("href"));
				System.out.println("=======================================================================================");
			
				FoodCategoryVO vo = new FoodCategoryVO();
				vo.setTitle(title.get(i).text());
				vo.setSubject(subject.get(i).text());
				vo.setPoster(poster.get(i).attr("data-lazy"));
				vo.setLink(link.get(i).attr("href"));
				dao.categoryInsert(vo);
			}
			System.out.println("저장 완료");
		} catch(Exception ex) {}
	}
	
	// 맛집 데이터 수집
	/*
           <ul class="list-restaurants type-single-big top_list_restaurant_list">
              <li class="toplist_list">
                <div class="with-review">
                  <figure class="restaurant-item">
                    <a href="/restaurants/NKeKBl9J2p"
                      onclick="trackEvent('CLICK_RESTAURANT', {&quot;position&quot;:0,&quot;restaurant_key&quot;:&quot;NKeKBl9J2p&quot;})">
                      <div class="thumb">
                        <img class="center-croping lazy"
                             alt="더라이브러리 사진 - 서울특별시 중구 동호로 249 서울신라호텔 1F"
                             data-original="https://mp-seoul-image-production-s3.mangoplate.com/1160096_1655514895842804.jpg?fit=around|738:738&amp;crop=738:738;*,*&amp;output-format=jpg&amp;output-quality=80"
                             data-error="https://mp-seoul-image-production-s3.mangoplate.com/web/resources/kssf5eveeva_xlmy.jpg?fit=around|*:*&amp;crop=*:*;*,*&amp;output-format=jpg&amp;output-quality=80"
                          />
                      </div>
                    </a>
                    <figcaption>
                      <div class="info">
                        <div class="wannago_wrap">
                          <button class="btn-type-icon favorite wannago_btn "
                                  data-restaurant_uuid="10248"
                                  data-action_id="">
                          </button>
                          <p class="wannago_txt">가고싶다 </p>
                        </div>
                        <span class="title ">
                          <a href="/restaurants/NKeKBl9J2p"  
	 */
	public void foodData() {
		try {
			FoodDAO dao = new FoodDAO();
			List<FoodCategoryVO> list = dao.foodCategoryInfoData();
			for(FoodCategoryVO vo:list) {
				Document doc = Jsoup.connect("https://www.mangoplate.com"+vo.getLink()).get();	// https://www.mangoplate.com/top_lists/1965_hotel_bingsu
				System.out.println("=============="+vo.getTitle()+"==============");
				Elements link = doc.select("ul.list-restaurants figure.restaurant-item span.title a");
				for (int i=0; i<link.size(); i++) {
					System.out.println(link.get(i).attr("href"));
					Document doc2 = Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();	// 상세보기 페이지 https://www.mangoplate.com/restaurants/NKeKBl9J2p
					/*
						<section class="restaurant-detail">
						            <header>
						              <div class="restaurant_title_wrap">
						                <span class="title">
						                  <h1 class="restaurant_name">더라이브러리</h1>					  
					 */
					Element title = doc2.selectFirst("span.title h1.restaurant_name");	// Element:태그 한 개 Elements:태그 여러개
					System.out.println(title.text());
				}
			}
		} catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodMain m = new FoodMain();
		// m.categoryData();
		m.foodData();
	}

}
