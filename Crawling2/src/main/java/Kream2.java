

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Kream2 {
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";	// 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		Kream2 krm = new Kream2();
		int rank = 0;	// 순서 주려고 선언
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);	// 운영체제 드라이버 설정
		ChromeOptions options = new ChromeOptions();	// 옵션 쓰려고 객체화
		options.addArguments("headless");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriver driver = new ChromeDriver(options);
		WebDriver driver1 = new ChromeDriver(options);
		
		try {
			String url = "https://kream.co.kr/search?category_id=34&keyword=%EC%98%A4%ED%8A%B8%EB%A6%AC&sort=popular&per_page=40";
			driver.get(url);
//			String url = element.findElement(By.tagName("a")).getAttribute("href");
//			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);	
//			Thread.sleep(1000);
//			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);	
//			Thread.sleep(1000);
			
//			List<WebElement> el = driver.findElements(By.className("product_info"));
//			driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
//			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
//			WebElement html = driver.findElement(By.tagName("html"));
//			html.sendKeys(Keys.END);
//			Thread.sleep(2000);
//			sendKeys(Keys.END);
			
			List<WebElement> element = driver.findElements(By.className("search_result_item"));
			
			for (WebElement el:element) {
//				driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MICROSECONDS);
//				driver1.manage().timeouts().implicitlyWait(10000,TimeUnit.MICROSECONDS);
				
				String durl = el.findElement(By.tagName("a")).getAttribute("href");
//				System.out.println(durl);
				driver1.navigate().to(durl);
				Thread.sleep(500);
//				
				List<WebElement> element2 = driver1.findElements(By.className("column_box"));
				for (WebElement el2:element2) {
				System.out.println(++rank+". ");
//				System.out.println(el2.findElement(By.className("brand")).getText());
				System.out.println(el2.findElement(By.xpath(".//div[@class='main_title_box']/p")).getText());
//				System.out.println(el2.findElement(By.className("sub_title")).getText());

				System.out.println();
				}
				
				
			}
			

//			var stTime = new Date().getTime(); //현재시간
//	        
//			while (new Date().getTime() < stTime + 15000) { //30초 동안 무한스크롤 지속
//				
////				for (int i=0; i<=5; i++) {
////				Thread.sleep(1000); //리소스 초과 방지
////	            //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
////				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", url);
////				Thread.sleep(1000); //리소스 초과 방지
////				}
//				Thread.sleep(1000); //리소스 초과 방지
//				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", url);
////				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", el);
//
//				List<WebElement> el = driver.findElements(By.className("column_box"));
//				
//				for (WebElement element:el) {
//					System.out.println(++rank+". ");
//					System.out.print(element.findElement(By.className("brand")).getText());
//					System.out.print(" | "+element.findElement(By.className("title")).getText());
//					System.out.print(" | "+element.findElement(By.className("sub_title")).getText());
////					System.out.print(" | "+element.findElement(By.className("desc")).getText());
//					System.out.println();
//
//					
//				}
//			}
//			channelBuilder.keepaliveTime(5, TimeUnit.MINUTES);
	        
		} finally {
//			driver.close();
			driver.quit();
		}
	}

};
