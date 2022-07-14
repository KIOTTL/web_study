package com.sist.data;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StyleData {
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";   // 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
    public static void styleAllData() throws InterruptedException, IOException
    {
        StyleData sda = new StyleData();
        int sno=0;   // 순서 주려고 선언
        
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);   // 운영체제 드라이버 설정
        ChromeOptions options = new ChromeOptions();   // 옵션 쓰려고 객체화
        options.addArguments("headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        
        WebDriver driver = new ChromeDriver(options);
    	
//    	KreamDAO dao=new KreamDAO();
//    	ArrayList<KreamVO> list=new ArrayList<KreamVO>();
    	
    	 try {
             String url = "https://kream.co.kr/social/trending";
             driver.get(url);

//			 SNO                                       NOT NULL NUMBER
//			 PICTURE                                   NOT NULL VARCHAR2(500)
//			 PROFILE                                            VARCHAR2(500)
//			 NICKNAME                                           VARCHAR2(20)
//			 CONTENT                                   NOT NULL VARCHAR2(1000)
//			 LIKE_COUNT                                         NUMBER
//			 REPLY_COUNT                                        NUMBER
//			 POSTER                                    NOT NULL VARCHAR2(500)
//			 NAME                                      NOT NULL VARCHAR2(200)
//			 PRICE                                              VARCHAR2(20)
             
//            	 List<WebElement> el = driver.findElements(By.className("card_detail"));
//            	 for (WebElement li:el) {
//                	
//                	String nickname = li.findElement(By.className("user_name")).getText();
//                	String content = li.findElement(By.className("text_box")).getText();
//                	String like = li.findElement(By.className("like_count")).getText(); 
                	
//                	int reply = Integer.parseInt(li.findElement(By.className("comment_count")).getText());
//                	
//                	if(reply>0) {
//                		reply = Integer.parseInt(li.findElement(By.className("comment_count")).getText());
//                	} else {
//                		reply=0;
//                	}
//         	for (int i=1; i<=3; i++) {
        		for (int i=2; i<=19; i++) {
        			String nickname = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div[2]/div[1]/div["+i+"]/a/div[1]/div[2]/div[1]/p")).getText();
        			String content;
        			try {
        				content = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div[2]/div[1]/div["+i+"]/a/div[1]/div[2]/p")).getText();
        			} catch(Exception ex) {content = " ";}
        			int like_count = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div["+i+"]/a/div[1]/div[2]/div[2]/a[1]/span")).getText());
        			int reply_count;
        			try {
        				reply_count = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div["+i+"]/a/div/div[2]/div[2]/a[2]/span")).getText());
        			} catch(Exception ex) {reply_count=0;}
        			String name;
        			for (int j=1; j<=3; j++ ) {
        				try {
        					name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div["+i+"]/a/div[1]/div[2]/div[3]/ul/li["+j+"]/a/div[2]/p")).getText();
//        					name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/a/div/div[2]/div[3]/ul/li/a/div[2]/p")).getText();
//        					name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div[4]/a/div[1]/div[2]/div[3]/ul/li/a/div[2]/p")).getText();
        				} catch(Exception ex) {name="";}
//        			String name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/a/div[1]/div[2]/div[3]/ul/li[2]/a/div[2]/p")).getText();
//        			String name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/a/div/div[2]/div[3]/ul/li/a/div[2]/p")).getText();
//        			String name = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div[1]/div[4]/a/div[1]/div[2]/div[3]/ul/li/a/div[2]/p")).getText();
        			
        				System.out.println(name);         
        			}
        			System.out.println(++sno+". ");
        			System.out.println(nickname);         
        			System.out.println(content);         
        			System.out.println(like_count);         
        			System.out.println(reply_count);         
//        			String nickname = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div[2]/div[1]/div[4]/a/div[1]/div[2]/div[1]/p")).getText();
//        			String nickname = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div[2]/div[1]/div[5]/a/div[1]/div[2]/div[1]/p")).getText();
//        			String content = driver.findElement(By.xpath("//*[@id='__layout']/div/div[2]/div[1]/div[2]/div[4]/div[2]/div["+i+"]/div["+j+"]/p")).getText();
//        			System.out.println(logo); 
                	
//                   System.out.println(++sno+". ");
//                   System.out.println("|"+nickname);
//                   System.out.print(element.findElement(By.tagName("img")).getAttribute("src"));
//                   System.out.print("|"+li.findElement(By.className("user_name")).getText());         
//                   System.out.print("|"+li.findElement(By.className("like_count")).getText());         
//                   System.out.print("|"+content);         
//                   System.out.print("|"+reply);         

                   System.out.println();
                   
//				   KreamVO k=new KreamVO();
//				   
//				   k.setBrand(brand);
//				   k.setName(name);
//				   k.setAmount(amount);
//				   k.setDesc(desc);
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
				   
//				   list.add(k);
                   
                }
          
             
               
          } finally {
//             driver.close();
             driver.quit();
          }
    	
    
    			
//    			FileOutputStream fos=
//    					new FileOutputStream("c:\\java_data\\kream.txt");
//    			ObjectOutputStream oos=
//    					new ObjectOutputStream(fos);
//    			oos.writeObject(list);
//    			oos.close();
//    			fos.close();
//    			System.out.println("데이터 저장 완료!!");
    
    }
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        styleAllData();
	}
}
