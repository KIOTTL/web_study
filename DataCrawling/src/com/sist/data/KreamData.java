package com.sist.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sist.dao.KreamDAO;
import com.sist.vo.KreamVO;
public class KreamData {
	
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";   // 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
    public static void kreamAllData() throws InterruptedException, IOException
    {
        KreamData krm = new KreamData();
        int kno=0;   // 순서 주려고 선언
        
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);   // 운영체제 드라이버 설정
        ChromeOptions options = new ChromeOptions();   // 옵션 쓰려고 객체화
        options.addArguments("headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        
        WebDriver driver = new ChromeDriver(options);
    	
    	KreamDAO dao=new KreamDAO();
    	ArrayList<KreamVO> list=new ArrayList<KreamVO>();
    	
    	 try {
             String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
             driver.get(url);
             
//             WebElement element = driver.findElement(By.cssSelector("#__layout > div > div.container.search.sm > div.content > div > div.search_result.sm > div.search_result_list > div:nth-child(1) > a > div.product_info"));
//             element.sendKeys(Keys.END);
             
//             List<WebElement> el = driver.findElements(By.className("search_result_item"));
//             element = driver.findElements(By.className("search_result_item"));

             var stTime = new Date().getTime(); //현재시간
//             driver.findElement(By.className("product_info")).sendKeys(Keys.END);
               
             while (new Date().getTime() < stTime + 30000) { //30초 동안 무한스크롤 지속
 				
            	 for (int i=0; i<=3; i++) {
 					Thread.sleep(1000); //리소스 초과 방지
 		            //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
 					((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", url);
 					Thread.sleep(1000); //리소스 초과 방지
 					}
//                   Thread.sleep(500); //리소스 초과 방지
//                   //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
//                   ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", el);
            	 List<WebElement> el = driver.findElements(By.className("search_result_item"));
            	 for (WebElement li:el) {
//                	Document doc=Jsoup.connect(url).get();
//                	Elements brand=doc.select("");
//    				//System.out.println(title);
//    				Elements singer=doc.select("table.list-wrap td.info a.artist");
//    				Elements ablum=doc.select("table.list-wrap td.info a.albumtitle");
//    				Elements poster=doc.select("a.cover img");
//    				Elements etc=null;
                	
                	String brand = li.findElement(By.className("brand")).getText();
                	String name = li.findElement(By.className("name")).getText();
                	String amount = li.findElement(By.className("amount")).getText();
                	String desc = li.findElement(By.className("desc")).getText();
                	
                   System.out.println(++kno+". ");
//                   System.out.print(element.findElement(By.tagName("img")).getAttribute("src"));
                   System.out.print("|"+li.findElement(By.className("brand")).getText());         
                   System.out.print("|"+li.findElement(By.className("name")).getText());
//                   System.out.print("|"+element.findElement(By.className("translated_name")).getText());
                   System.out.print("|"+li.findElement(By.className("amount")).getText());
                   System.out.print("|"+li.findElement(By.className("desc")).getText());
//                   System.out.print("|"+element.findElement(By.className("express_mark")).getText());
                   System.out.println();
                   
				   KreamVO k=new KreamVO();
				   
				   k.setBrand(brand);
				   k.setName(name);
				   k.setAmount(amount);
				   k.setDesc(desc);
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
				   
				   list.add(k);
                   
                }
          
             }
               
          } finally {
//             driver.close();
             driver.quit();
          }
    	
    
    			
    			FileOutputStream fos=
    					new FileOutputStream("c:\\java_data\\kream.txt");
    			ObjectOutputStream oos=
    					new ObjectOutputStream(fos);
    			oos.writeObject(list);
    			oos.close();
    			fos.close();
    			System.out.println("데이터 저장 완료!!");
    
    }
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        kreamAllData();
	}

}