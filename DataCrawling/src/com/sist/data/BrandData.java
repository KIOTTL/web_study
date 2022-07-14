package com.sist.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrandData {
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";   // 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
    public static void brandAllData() throws InterruptedException, IOException
    {
        BrandData bda = new BrandData();
        int bno=0;   // 순서 주려고 선언
        
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);   // 운영체제 드라이버 설정
        ChromeOptions options = new ChromeOptions();   // 옵션 쓰려고 객체화
        options.addArguments("headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        
        WebDriver driver = new ChromeDriver(options);
    	
//    	KreamDAO dao=new KreamDAO();
//    	ArrayList<KreamVO> list=new ArrayList<KreamVO>();
    	
    	 try {
             String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
             driver.get(url);

            	 List<WebElement> el = driver.findElements(By.className("menu"));
            	 for (WebElement li:el) {
                	
                	String name = li.findElement(By.className("link_text")).getText();

                	
                   System.out.println(++bno+". ");
//                   System.out.print(element.findElement(By.tagName("img")).getAttribute("src"));
                   System.out.print("|"+li.findElement(By.className("link_text")).getText());         

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
        brandAllData();
	}
}
