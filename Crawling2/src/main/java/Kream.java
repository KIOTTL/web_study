

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


public class Kream {
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";	// 크롬 드라이버
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		Kream krm = new Kream();
		int rank = 0;	// 순서 주려고 선언
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);	// 운영체제 드라이버 설정
		ChromeOptions options = new ChromeOptions();	// 옵션 쓰려고 객체화
		options.addArguments("headless");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriver driver = new ChromeDriver(options);
		
		try {
			String url = "https://kream.co.kr/search?category_id=34&sort=popular&per_page=40";
			driver.get(url);
			
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

			var stTime = new Date().getTime(); //현재시간
	        
			while (new Date().getTime() < stTime + 30000) { //30초 동안 무한스크롤 지속
				
				for (int i=0; i<=5; i++) {
				Thread.sleep(1000); //리소스 초과 방지
	            //executeScript: 해당 페이지에 JavaScript 명령을 보내는 거
				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", url);
				Thread.sleep(1000); //리소스 초과 방지
				}
//				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", url);
//				Thread.sleep(1000); //리소스 초과 방지
//				((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", el);

				List<WebElement> el = driver.findElements(By.className("product_info"));
				
				for (WebElement element:el) {
					System.out.println(++rank+". ");
					System.out.print(element.findElement(By.className("brand")).getText());
					System.out.print(" | "+element.findElement(By.className("name")).getText());
					System.out.print(" | "+element.findElement(By.className("amount")).getText());
					System.out.print(" | "+element.findElement(By.className("desc")).getText());
					System.out.println();

					
				}
			}
//			channelBuilder.keepaliveTime(5, TimeUnit.MINUTES);
	        
		} finally {
//			driver.close();
			driver.quit();
		}
	}

};
