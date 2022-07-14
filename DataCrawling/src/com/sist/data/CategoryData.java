package com.sist.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sist.dao.CategoryDAO;
import com.sist.vo.CategoryVO;

public class CategoryData {
	 private static WebDriver driver;
	 public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";   // 크롬 드라이버
	 public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	 public static void categoryAllData() throws InterruptedException, IOException
	 {
	     CategoryData catda = new CategoryData();
	     int cno=0;   // 순서 주려고 선언
	     int cno2=40;
	     int cno3=80;
	     
	     System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);   // 운영체제 드라이버 설정
	     ChromeOptions options = new ChromeOptions();   // 옵션 쓰려고 객체화
	     options.addArguments("headless");
	     options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	     
	     WebDriver driver = new ChromeDriver(options);
	     WebDriver driver2 = new ChromeDriver(options);
	     WebDriver driver3 = new ChromeDriver(options);
	 	
	 	CategoryDAO dao=new CategoryDAO();
	 	ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
	 	
	 	 try {
	          String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
	          driver.get(url);
	          String url2 = "https://kream.co.kr/search?category_id=34&sort=date_released&per_page=40";
	          driver2.get(url2);
	          String url3 = "https://kream.co.kr/search?category_id=34&sort=pricepremium&per_page=40";
	          driver3.get(url3);
	             
           	 List<WebElement> el = driver.findElements(By.className("search_result_item"));
	         List<WebElement> el2 = driver2.findElements(By.className("search_result_item"));
	         List<WebElement> el3 = driver3.findElements(By.className("search_result_item"));
           	 for (WebElement li:el) {
               	
           		 String poster = li.findElement(By.tagName("img")).getAttribute("src");
               	String brand = li.findElement(By.className("brand")).getText();
               	String name = li.findElement(By.className("name")).getText();
               	String amount = li.findElement(By.className("amount")).getText();
               	
                  System.out.println(++cno+". ");
                  System.out.print(poster);
                  System.out.print("|"+brand);         
                  System.out.print("|"+name);
                  System.out.print("|"+amount);
                  System.out.println();
	                
                  /*
                   * cno, poster, brand, name, price
                   */
					   CategoryVO c=new CategoryVO();
					   
					   c.setCno(cno);
					   c.setPoster(poster);
					   c.setBrand(brand);
					   c.setName(name);
					   c.setPrice(amount);
	                
	//				   k.setKno(kno);
	////				   k.setImg(element.findElement(By.tagName("img")).getAttribute("src"));
	//				   k.setBrand(element.findElement(By.className("brand")).getText());
	//				   k.setName(element.findElement(By.className("name")).getText());
	//				   k.setTranslated_name(element.findElement(By.className("translated_name")).getText());
	//				   k.setAmount(element.findElement(By.className("amount")).getText());
	//				   k.setDesc(element.findElement(By.className("desc")).getText());
	//				   k.setExpress_mark(element.findElement(By.className("express_mark")).getText());
	//					System.out.println(++kno+". ");
	//					System.out.print(li.findElement(By.className("brand")).getText());
	//					System.out.print(" | "+li.findElement(By.className("name")).getText());
	//					System.out.print(" | "+li.findElement(By.className("amount")).getText());
	//					System.out.print(" | "+li.findElement(By.className("desc")).getText());
	//					System.out.println();
					   
					   dao.CategoryInsert(c);
					   list.add(c);
	                
//	             }
	       
	          }
           	 System.out.println("========================================================================");
           	 for (WebElement li2:el2) {
           		 	String poster = li2.findElement(By.tagName("img")).getAttribute("src");
                	String brand = li2.findElement(By.className("brand")).getText();
                   	String name = li2.findElement(By.className("name")).getText();
                   	String amount = li2.findElement(By.className("amount")).getText();
                   	
                    System.out.println(++cno2+". ");
                    System.out.print(poster);
                    System.out.print("|"+brand);         
                    System.out.print("|"+name);
                    System.out.print("|"+amount);
                    System.out.println();
                    
					   CategoryVO c=new CategoryVO();
					   
					   c.setCno(cno2);
					   c.setPoster(poster);
					   c.setBrand(brand);
					   c.setName(name);
					   c.setPrice(amount);
					   
					   list.add(c);
					   dao.CategoryInsert(c);
           	 }
           	 
           	 System.out.println("========================================================================");

           	 for (WebElement li3:el3) {
           		String poster = li3.findElement(By.tagName("img")).getAttribute("src");
             	String brand = li3.findElement(By.className("brand")).getText();
                String name = li3.findElement(By.className("name")).getText();
                String amount = li3.findElement(By.className("amount")).getText();
                	
                 System.out.println(++cno3+". ");
                 System.out.print(poster);
                 System.out.print("|"+brand);         
                 System.out.print("|"+name);
                 System.out.print("|"+amount);
                 System.out.println();
                 
				   CategoryVO c=new CategoryVO();
				   
				   c.setCno(cno3);
				   c.setPoster(poster);
				   c.setBrand(brand);
				   c.setName(name);
				   c.setPrice(amount);
				   
				   list.add(c);
				   dao.CategoryInsert(c);
        	 }
           	 
	            
	       } finally {
	//          driver.close();
	          driver.quit();
	       }
	 	
	 
	 			
	 			FileOutputStream fos=
	 					new FileOutputStream("c:\\java_data\\category.txt");
	 			ObjectOutputStream oos=
	 					new ObjectOutputStream(fos);
	 			oos.writeObject(list);
	 			oos.close();
	 			fos.close();
	 			System.out.println("데이터 저장 완료!!");
	 
	 }
		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
	     categoryAllData();
		}
}
