package com.sist.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sist.dao.BrandDAO;
import com.sist.vo.BrandVO;


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
    	
    	BrandDAO dao=new BrandDAO();
    	ArrayList<BrandVO> list=new ArrayList<BrandVO>();
    	
    	 try {
             String url = "https://kream.co.kr/";
             driver.get(url);

//            	 List<WebElement> el = driver.findElements(By.className("menu"));
//            	 for (WebElement li:el) {
                	for (int i=1; i<=3; i++) {
                		for (int j=1; j<=5; j++) {
                			String logo = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div["+i+"]/div["+j+"]/div/picture/img")).getAttribute("src");
                			String name = driver.findElement(By.xpath("//*[@id='__layout']/div/div[2]/div[1]/div[2]/div[4]/div[2]/div["+i+"]/div["+j+"]/p")).getText();
                			System.out.println(++bno+". ");
                			System.out.println(name);         
                			System.out.println(logo);  
                			
         				   BrandVO b=new BrandVO();
        				   
        				   b.setBno(bno);
        				   b.setLogo(logo);
        				   b.setName(name);
        				   
        				   list.add(b);
        				   dao.BrandInsert(b);
                		}
                	}
                	

                   
//				   BrandVO b=new BrandVO();
//				   
//				   b.setBno(bno);
//				   b.setLogo(logo);
//				   b.setName(name);
//				   b.setDesc(desc);
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
                   
//                }
          
             
               
          } finally {
//             driver.close();
             driver.quit();
          }
    	
    
    			
    			FileOutputStream fos=
    					new FileOutputStream("c:\\java_data\\brand.txt");
    			ObjectOutputStream oos=
    					new ObjectOutputStream(fos);
    			oos.writeObject(list);
    			oos.close();
    			fos.close();
    			System.out.println("데이터 저장 완료!!");
    
    }
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        brandAllData();
	}
}
